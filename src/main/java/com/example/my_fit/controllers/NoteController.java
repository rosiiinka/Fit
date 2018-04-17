package com.example.my_fit.controllers;

import com.example.my_fit.model.view.NoteCreateRequestModel;
import com.example.my_fit.services.note.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteController{



    private final NoteService noteService;

    public NoteController( NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes/note")
//    @PreAuthorize("isAuthenticated()")
    public ModelAndView note() {
        return new ModelAndView("/notes/note.html");
    }

    @PostMapping("/notes/note")
    public ModelAndView createNote(NoteCreateRequestModel model) {
        this.noteService.createNote(model);

        return new ModelAndView("redirect:/notes/note");
    }


}
