package com.example.my_fit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
    @GetMapping("/error")
    public ModelAndView contacts() {
        return new ModelAndView("fragments/errorPage.html");
    }
}
