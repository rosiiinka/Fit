package com.example.my_fit.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class ModeController {

    @GetMapping("/modes/modes")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView modes() {
        return new ModelAndView("modes/modes.html");
    }
}
