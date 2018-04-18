package com.example.my_fit.controllers;

import com.example.my_fit.model.view.ModeCreateRequestModel;
import com.example.my_fit.services.mode.ModeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModeController {

    private final ModeService modeService;

    public ModeController(ModeService modeService) {
        this.modeService = modeService;
    }

    @GetMapping("/modes")
//    @PreAuthorize("hasRole('USER')")
    public ModelAndView modes( ModelAndView modelAndView) {
        modelAndView.setViewName("modes/modes");

        modelAndView.addObject("modes", this.modeService.getAllModes());

        return modelAndView;
    }

    @GetMapping("/modes/mode/{id}")
//    @PreAuthorize("hasRole('USER')")
    public ModelAndView mode( ModelAndView modelAndView, @PathVariable Long id) {
        modelAndView.setViewName("modes/mode");

        modelAndView.addObject("modes", this.modeService.getAllModes());
        modelAndView.addObject("mode", this.modeService.getById(id));

        return modelAndView;
    }

    @GetMapping("/modes/create_mode")
//    @PreAuthorize("isAuto")
    public ModelAndView createMode() {
        return new ModelAndView("modes/createMode.html");
    }

    @PostMapping("/modes/create_mode")
    public ModelAndView createMode(ModeCreateRequestModel model) {
        this.modeService.createMode(model);

        return new ModelAndView("redirect:/modes");
    }


}
