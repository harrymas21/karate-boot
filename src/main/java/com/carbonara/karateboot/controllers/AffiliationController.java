package com.carbonara.karateboot.controllers;

import com.carbonara.karateboot.dtos.AffiliationDTO;
import com.carbonara.karateboot.dtos.DateAndVarDTO;
import com.carbonara.karateboot.dtos.DateDTO;
import com.carbonara.karateboot.models.Affiliation;
import com.carbonara.karateboot.models.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.carbonara.karateboot.services.AffiliationService;
import com.carbonara.karateboot.services.ClubService;
import com.carbonara.karateboot.services.UserService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AffiliationController {
    @Autowired
	private AffiliationService affiliationService;
    @Autowired
	private UserService userService;
    @Autowired
	private ClubService clubService;
    //show index form with two date selectors
    @RequestMapping(value = "app/secure/affiliations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("date", new DateDTO());
        return "affiliation/index";
    }
    
    //receive date object and get list of club payments
    @RequestMapping(value = "app/secure/affiliation/statement", method = RequestMethod.POST)
    public String getDates(@Valid @ModelAttribute("date")DateDTO dto,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            return "affiliation/index";
        }
        else {
        model.addAttribute("statements",affiliationService.listAllStatements(dto.getStartDate(), dto.getEndDate()));
        return "affiliation/statements";
        }
    }
    
    //show index form with two date selectors and club dropdown
    @RequestMapping(value = "app/secure/affiliation/club", method = RequestMethod.GET)
    public String affiliationByClubForm(Model model) {
        model.addAttribute("date", new DateAndVarDTO());
        model.addAttribute("clubs", clubService.listAllClubs());
        return "affiliation/byClubForm";
    }
    
    //get payments by club
    @RequestMapping(value = "app/secure/affiliation/statement/club", method = RequestMethod.POST)
    public String getDatesAndClub(@Valid @ModelAttribute("date")DateAndVarDTO dto,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("clubs", clubService.listAllClubs());
            return "affiliation/byClubForm";
        }
        else {
            Club club = clubService.getClubByName(dto.getVar());
            model.addAttribute("clubName",club.getName());
        model.addAttribute("statements",affiliationService.listAllStatementsByClub(dto.getStartDate(), dto.getEndDate(),club));
        return "affiliation/byClubPayments";
        }
    }
    
    //show affiliation form
    @RequestMapping(value = "app/secure/affiliation/new", method = RequestMethod.GET)
    public String affiliationForm(Model model) {
        model.addAttribute("affiliation", new AffiliationDTO());
        model.addAttribute("clubs", clubService.listAllClubs());
        return "affiliation/insertAffiliation";
    }
    
    //save to database and redirect to show
    @RequestMapping(value = "app/secure/affiliation/new/save", method = RequestMethod.POST)
    public String savePost(@Valid @ModelAttribute("post")AffiliationDTO dto,BindingResult bindingResult,Model model)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("clubs", clubService.listAllClubs());
            //model.addAttribute("affiliation", new AffiliationDTO());
            return "affiliation/insertAffiliation";
        } else {
            Affiliation affiliation = new Affiliation();
            affiliation.setUser(userService.getLoggedInUser());
            affiliation.setClub(clubService.getClubByName(dto.getClubName()));
            affiliation.setJournalDescription(dto.getJournalDescription());
            affiliation.setAmount(dto.getAmount());
            affiliation.setPaid(dto.getPaid());
            affiliation.setBalance(dto.getBalance());
            affiliationService.saveAffiliation(affiliation);
            return "redirect:/app/secure/affiliation/statement/"+affiliation.getTransactionCode();	
		}
    }
    
    //display receipt after receiving payment.
    @RequestMapping("app/secure/affiliation/statement/{code}")
    public String receiptForEvent(@PathVariable String code, Model model) {
        model.addAttribute("affiliation",affiliationService.getStatementByCode(code));
        return "affiliation/paymentReceipt";
    }
}
