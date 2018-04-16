package com.example.my_fit.controllers;

import com.example.my_fit.model.view.NoteCreateRequestModel;
import com.example.my_fit.model.view.ProductCreateRequestModel;
import com.example.my_fit.services.note.NoteService;
import com.example.my_fit.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController{

    private final ProductService productService;

    private final NoteService noteService;

    public NoteController(ProductService productService, NoteService noteService) {
        this.productService = productService;
        this.noteService = noteService;
    }

    @GetMapping("/notes/note")
//    @PreAuthorize("isAuthenticated()")
    public ModelAndView note() {
        return new ModelAndView("/notes/note.html");
    }

    @PostMapping("/notes/product")
    public ModelAndView createNote(NoteCreateRequestModel model) {
        this.noteService.createNote(model);

        return new ModelAndView("redirect:/product");
    }

    @GetMapping("/notes/product")
//    @PreAuthorize("hasRole('USER')")
    public ModelAndView createProduct() {
        return new ModelAndView("/notes/product.html");
    }

    @PostMapping("/notes/product")
    public ModelAndView createProduct(ProductCreateRequestModel model) {
        this.productService.createProduct(model);

        return new ModelAndView("redirect:/product");
    }
}
