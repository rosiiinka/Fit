package com.example.my_fit.services.note;

import com.example.my_fit.model.entity.Note;
import com.example.my_fit.model.view.NoteViewModel;

import java.util.List;

public interface NoteService {
    Note createNote(NoteViewModel model);

    List<NoteViewModel> getAllNotes();
}
