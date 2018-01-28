package com.carbonara.karateboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.carbonara.karateboot.services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
	private UserService userService;
    
    //alll users
    @RequestMapping(value = "app/secure/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "user/index";
    }
    
    //return logged in user and show details
    @RequestMapping(value = "app/secure/user/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        model.addAttribute("user", userService.getLoggedInUser());
        return "user/show";
    }
    
    //reset password to String 123456
     @RequestMapping("app/secure/user/reset/{id}")
    public String editUser(@PathVariable int id) {
        userService.resetPassword(id);
        return "redirect:/app/secure/users";
    }
    
    //dont delete users only set to isEnabled = 0
    @RequestMapping("app/secure/user/disable/{id}")
    public String deleteEvent(@PathVariable int id) {
        userService.disableUser(id);
        return "redirect:/app/secure/users";
    }
}
