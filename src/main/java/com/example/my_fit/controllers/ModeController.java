package com.example.my_fit.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class ModeController {

    @GetMapping("/modes/modes")
    @PreAuthorize("hasRole('USER')")
    public ModelAndView modes() {
        return new ModelAndView("modes/modes.html");
    }

    @GetMapping("/modes/mode/(id)")
    @PreAuthorize("hasRole('USER')")
    public ModelAndView mode() {
        return new ModelAndView("modes/mode.html");
    }

    @GetMapping("/modes/mode/(id)")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createMode() {
        return new ModelAndView("modes/createMode.html");
    }
}
