package com.example.my_fit.controllers;

import com.example.my_fit.model.view.UserRegisterRequestModel;
import com.example.my_fit.services.user.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/register")
    public ModelAndView register(){
        return new ModelAndView("users/register.html");
    }

    @PostMapping("/users/register")
    public ModelAndView register(UserRegisterRequestModel model) {
        this.userService.register(model);

        return new ModelAndView("redirect:/login");
    }

    @GetMapping("/users/profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView profile() {
        return new ModelAndView("/users/profile.html");
    }

    @PostMapping("/logout")
    public ModelAndView logout(@RequestParam(required = false, name = "logout") String logout, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        modelAndView.setViewName("redirect:/login");

        if(logout != null) redirectAttributes.addFlashAttribute("logout", logout);

        return modelAndView;
    }

}
