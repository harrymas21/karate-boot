package com.carbonara.karateboot.controllers;

import com.carbonara.karateboot.dtos.EventRegisterDTO;
import com.carbonara.karateboot.models.Event;
import com.carbonara.karateboot.models.EventRegister;
import com.carbonara.karateboot.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.carbonara.karateboot.services.EventService;
import com.carbonara.karateboot.services.UserService;
import java.io.IOException;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {
    @Autowired
	private EventService eventService;
    @Autowired
	private UserService userService;
    
    @RequestMapping(value = "app/secure/events", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("events", eventService.listAllEvents());
        return "event/index";
    }
    
    @RequestMapping("app/secure/event/{id}")
    public String showEvent(@PathVariable Integer id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "event/show";
    }
    
    @RequestMapping("app/secure/event/new")
    public String newProduct(Model model) {
        model.addAttribute("event", new Event());
        return "event/form";
    }
    
     @RequestMapping("app/secure/event/edit/{id}")
    public String editEvent(@PathVariable Integer id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "event/form";
    }
    
    //save to database and redirect to show
    @RequestMapping(value = "app/secure/event/", method = RequestMethod.POST)
    public String saveProduct(@Valid @ModelAttribute("event")Event event,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
			return "event/form";
		} else {
			eventService.saveEvent(event);
			return "redirect:/app/secure/events";	
		}
    }    
    
    //confirm first
    @RequestMapping("app/secure/event/confirmdelete/{id}")
    public String deleteEvent(@PathVariable Integer id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        return "event/confirm-delete";
    }
    
    //delete event and go back to index
    @RequestMapping("app/secure/event/delete/{id}")
    public String deleteEvent(@PathVariable Integer id) {
        eventService.deleteEvent(id);
        return "redirect:/app/secure/events";
    }
    //register for an event show form
    @RequestMapping("app/secure/event/register/{id}")
    public String registerForEvent(@PathVariable Integer id, Model model) {
        model.addAttribute("event", eventService.getEventById(id));
        model.addAttribute("register", new EventRegisterDTO());
        return "event/register";
    }
    
    //save registration to db then redirect to receipt
    @RequestMapping("app/secure/blog/event/register/")
    public String saveEventRegistration(@Valid @ModelAttribute("register")EventRegisterDTO dto,BindingResult bindingResult,Model model)
    { 
       //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       EventRegister e = new EventRegister();
       //e.setUser(userService.findByUsername(auth.getName()));
       e.setUser(userService.getLoggedInUser());
       e.setEvent(eventService.getEventById(dto.getEventId()));
       e.setResult("PARTICIPATION");
       e.setPoints(0);
       e.setCategory(dto.getCategory());
       EventRegister exists = eventService.findByEventAndUser(eventService.getEventById(dto.getEventId()),userService.getLoggedInUser());
       if(exists==null)
       {
           eventService.saveRegistration(e);
           return "redirect:/app/secure/event/receipt/"+dto.getEventId();
       }
       else{
           model.addAttribute("error","You have already registered.");
           return "redirect:/app/secure/event/register/"+dto.getEventId();
       }
    }
    
    @RequestMapping("app/secure/event/receipt/{id}")
    public String receiptForEvent(@PathVariable Integer id, Model model) {
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //UserInfo user = (userService.findByUsername(auth.getName()));
        UserInfo user = (userService.getLoggedInUser());
        Event event = eventService.getEventById(id);
        model.addAttribute("receipt", eventService.findByEventAndUser(event,user));
        return "event/receipt";
    }
}
