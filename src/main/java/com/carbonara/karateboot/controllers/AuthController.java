package com.carbonara.karateboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.carbonara.karateboot.services.UserService;

@Controller
@RequestMapping("app")
public class AuthController {
    @Autowired
	private UserService userInfoService;
	@GetMapping("login")
	public ModelAndView login() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("custom-login");
	    return mav;
        }	
	@GetMapping("secure/user-home")
	public ModelAndView getAllUserArticles() {
//	    ModelAndView mav = new ModelAndView();
//	    mav.addObject("userArticles", userInfoService.getAllUserArticles());
//	    mav.setViewName("articles");
//	    return mav;
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
}
