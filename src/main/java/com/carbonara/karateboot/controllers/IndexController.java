package com.carbonara.karateboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String index() {
        return "custom-login";
    }
//    @RequestMapping("/error")
//    String errorMethod() {
//        return "errors/error";
//    }

}
