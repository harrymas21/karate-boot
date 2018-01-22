package com.carbonara.karateboot.controllers;

import com.carbonara.karateboot.models.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.carbonara.karateboot.services.ClubService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClubController {
    @Autowired
	private ClubService clubService;
    
    @RequestMapping(value = "app/secure/clubs", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("clubs", clubService.listAllClubs());
        return "club/index";
    }
    
    @RequestMapping("app/secure/club/{id}")
    public String showClub(@PathVariable Integer id, Model model) {
        model.addAttribute("club", clubService.getClubById(id));
        return "club/show";
    }
    
    @RequestMapping("app/secure/club/new")
    public String newClub(Model model) {
        model.addAttribute("club", new Club());
        return "club/form";
    }
    
     @RequestMapping("app/secure/club/edit/{id}")
    public String editEvent(@PathVariable Integer id, Model model) {
        model.addAttribute("club", clubService.getClubById(id));
        return "club/form";
    }
    
    //save to database and redirect to show
    @RequestMapping(value = "app/secure/club/", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("club")Club club,BindingResult bindingResult){
        Club clubExists = clubService.getClubByName(club.getName());
        if (clubExists != null) {
			bindingResult
					.rejectValue("name", "error.club",
							"There is already a club registered with the name provided");
		}
        if (bindingResult.hasErrors()) {
			return "club/form";
		} else {
			clubService.saveClub(club);
			return "redirect:/app/secure/clubs";
		}
    }
    
    //delete event and go back to index
    @RequestMapping("app/secure/club/confirmdelete/{id}")
    public String deleteEvent(@PathVariable Integer id, Model model) {
        model.addAttribute("club", clubService.getClubById(id));
        return "club/confirm-delete";
    }
    
    @RequestMapping("app/secure/club/delete/{id}")
    public String deleteEvent(@PathVariable Integer id) {
        clubService.deleteClub(id);
        return "redirect:/app/secure/clubs";
    }
}
