package com.example.my_fit.controllers;

import com.example.my_fit.model.view.ModeCreateRequestModel;
import com.example.my_fit.services.mode.ModeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public class ModeController {

    private final ModeService modeService;

    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

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

    @GetMapping("/modes/create_mode")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createMode() {
        return new ModelAndView("modes/createMode.html");
    }

    @PostMapping("/modes/create_mode")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createMode(ModeCreateRequestModel model) {
        this.modeService.createMode(model);

        return new ModelAndView("redirect:/modes");
    }

}
