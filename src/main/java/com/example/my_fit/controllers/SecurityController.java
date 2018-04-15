package com.example.my_fit.controllers;

import com.example.my_fit.model.view.UserRegisterRequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/users/login.html");
    }

    @PostMapping("/login")
    public ModelAndView login(UserRegisterRequestModel model) {
        return new ModelAndView("redirect:/home");
    }
}
