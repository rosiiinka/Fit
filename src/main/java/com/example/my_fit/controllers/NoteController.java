package com.example.my_fit.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class NoteController{

    @GetMapping("/notes/note")
    @PreAuthorize("hasRole('USER')")
    public ModelAndView note() {
        return new ModelAndView("notes/note.html");
    }

    @GetMapping("/notes/product")
    @PreAuthorize("hasRole('USER')")
    public ModelAndView createProduct() {
        return new ModelAndView("notes/product.html");
    }
}
