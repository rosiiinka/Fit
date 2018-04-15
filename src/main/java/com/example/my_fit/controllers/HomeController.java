package com.example.my_fit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {

    @GetMapping("/home")
    public ModelAndView index() {
        return new ModelAndView("home/home.html");
    }
}
