package com.carbonara.karateboot.controllers;

import com.carbonara.karateboot.dtos.CommentDTO;
import com.carbonara.karateboot.models.Blog;
import com.carbonara.karateboot.models.Comment;
import com.carbonara.karateboot.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.carbonara.karateboot.services.CommentService;
import com.carbonara.karateboot.services.BlogService;
import com.carbonara.karateboot.services.UserService;
import java.io.IOException;
import java.security.Principal;
import java.util.*;
import javax.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {
    @Autowired
	private BlogService blogService;
    @Autowired
	private CommentService commentService;
    @Autowired
	private UserService userService;
    
    
    
    @RequestMapping(value = "app/secure/blog", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("posts", blogService.listAllPosts());
        return "blog/index";
    }
    
    @RequestMapping(value="app/secure/blog/{id}", method = RequestMethod.GET)
    public String showPost(@PathVariable Integer id, Model model) {
        model.addAttribute("comments", commentService.findByBlogId(id));
        model.addAttribute("post", blogService.getPostById(id));
        model.addAttribute("comment", new CommentDTO());
        return "blog/show";
    }
    
    @RequestMapping("app/secure/blog/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Blog());
        return "blog/form";
    }
    
     @RequestMapping("app/secure/blog/edit/{id}")
    public String editPost(@PathVariable Integer id, Model model) {
        model.addAttribute("post", blogService.getPostById(id));
        return "blog/form";
    }
    
    
    //save to database and redirect to show
    @RequestMapping(value = "app/secure/blog/", method = RequestMethod.POST)
    public String savePost(@Valid @ModelAttribute("post")Blog blog,BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
			return "blog/form";
		} else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                        blog.setAuthor(userService.findByUsername(auth.getName()));
			blogService.savePost(blog);
			return "redirect:/app/secure/blog";	
		}
    }
    
    //delete event and go back to index
    @RequestMapping("app/secure/blog/confirmdelete/{id}")
    public String deleteEvent(@PathVariable Integer id, Model model) {
        model.addAttribute("club", blogService.getPostById(id));
        return "blog/confirm-delete";
    }
    
    @RequestMapping("app/secure/blog/delete/{id}")
    public String deleteEvent(@PathVariable Integer id) {
        blogService.deletePost(id);
        return "redirect:/app/secure/blog";
    }
    
    //add comment-------
    @RequestMapping(value = "/app/secure/blog/comment/", method = RequestMethod.POST)
    public String saveComment(@Valid @ModelAttribute("comment")CommentDTO c,BindingResult bindingResult)
    {
        Comment comment = new Comment();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            comment.setBlogId(blogService.getPostById(c.getBlogId()));
            comment.setAuthor(userService.findByUsername(auth.getName()));
            comment.setBody(c.getBody());
            commentService.saveComment(comment);
            return "redirect:/app/secure/blog/"+c.getBlogId(); 
    }
}
