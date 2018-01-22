package com.carbonara.karateboot.controllers;

import com.carbonara.karateboot.models.UserInfo;
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
	    String errorMessage= "You are not authorized for the requested data.";
	    mav.addObject("errorMsg", errorMessage);
	    mav.setViewName("403");
	    return mav;
        }
        
        @GetMapping("register")
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		UserInfo user = new UserInfo();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
        }
        
        @PostMapping("register")
	public ModelAndView createNewUser(@Valid @ModelAttribute("user")UserInfo user, BindingResult bindingResult, ModelAndView modelAndView)
        throws IOException{
		//ModelAndView modelAndView = new ModelAndView();
		UserInfo userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new UserInfo());
			modelAndView.setViewName("registration");	
		}
		return modelAndView;
}
}
