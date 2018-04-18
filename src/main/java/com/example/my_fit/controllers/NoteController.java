package com.example.my_fit.controllers;

import com.example.my_fit.model.view.NoteCreateRequestModel;
import com.example.my_fit.services.note.NoteService;
import com.example.my_fit.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController{



    private final NoteService noteService;

    private final ProductService productService;

    public NoteController(NoteService noteService, ProductService productService) {
        this.noteService = noteService;
        this.productService = productService;
    }

    @GetMapping("/notes")
//    @PreAuthorize("isAuthenticated()")
    public ModelAndView note( ModelAndView modelAndView) {
        modelAndView.setViewName("notes/note");

        modelAndView.addObject("notes", this.noteService.getAllNotes());
        modelAndView.addObject("products", this.productService.getAllProducts());

        return modelAndView;
    }

    @PostMapping("/notes")
    public ModelAndView createNote(NoteCreateRequestModel model) {
        this.noteService.createNote(model);

        return new ModelAndView("redirect:/notes/note");
    }


}
