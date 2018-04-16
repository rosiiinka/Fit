package com.example.my_fit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactsController {
    @GetMapping("/contacts")
    public ModelAndView contacts() {
        return new ModelAndView("contacts/contacts.html");
    }
}
