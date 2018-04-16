package com.example.my_fit.services.note;

import com.example.my_fit.model.entity.Note;
import com.example.my_fit.model.view.NoteCreateRequestModel;
import com.example.my_fit.repositories.NoteRepository;

public class NoteServiceImlp implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImlp(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNote(NoteCreateRequestModel model) {
        Note note = new Note();
        note.setProducts(model.getProduct());
        note.setQuantity(model.getQuantity());

        return this.noteRepository.save(note);
    }
}
