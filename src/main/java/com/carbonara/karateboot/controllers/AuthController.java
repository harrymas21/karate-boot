package com.carbonara.karateboot.controllers;

import com.carbonara.karateboot.dtos.UserDTO;
import com.carbonara.karateboot.models.UserInfo;
import com.carbonara.karateboot.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.carbonara.karateboot.services.UserService;
import java.io.IOException;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("app")
public class AuthController {
    @Autowired
	private UserService userService;
    
    @Autowired
	private ClubService clubService;
    
	@GetMapping("login")
	public ModelAndView login() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("custom-login");
	    return mav;
        }	
	@GetMapping("secure/user-home")
	public ModelAndView home() {
            ModelAndView mav = new ModelAndView();
	    mav.setViewName("user-home");
	    return mav;
        }
	@GetMapping("error")
	public ModelAndView error() {
	    ModelAndView mav = new ModelAndView();
	    String errorMessage= "You are not authorized to view the requested data.";
	    mav.addObject("errorMsg", errorMessage);
	    mav.setViewName("403");
	    return mav;
        }
        
        @GetMapping("register")
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new UserDTO());
                modelAndView.addObject("clubs", clubService.listAllClubs());
		modelAndView.setViewName("registration");
		return modelAndView;
        }
        
        @PostMapping("register")
	public ModelAndView createNewUser(@Valid @ModelAttribute("user")UserDTO dto, BindingResult bindingResult, ModelAndView modelAndView)
        throws IOException{
		//ModelAndView modelAndView = new ModelAndView();
		UserInfo userExists = userService.findUserByEmail(dto.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
                        modelAndView.addObject("clubs", clubService.listAllClubs());
			modelAndView.setViewName("registration");
		} else {
                    UserInfo user = new UserInfo();
                        user.setClub(clubService.getClubByName(dto.getClub()));
                        user.setAddress(dto.getAddress());
                        user.setEmail(dto.getEmail());
                        user.setUsername(dto.getUsername());
                        user.setFirstname(dto.getFirstname());
                        user.setLastname(dto.getLastname());
                        user.setPassword(dto.getPassword());
                        user.setPhone(dto.getPhone());
                        user.setRole(dto.getRole());
                        user.setRank(dto.getRank());
                        user.setEnabled(dto.getEnabled());
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new UserDTO());
			modelAndView.setViewName("registration");	
		}
		return modelAndView;
}
}
