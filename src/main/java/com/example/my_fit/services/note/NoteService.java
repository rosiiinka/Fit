package com.example.my_fit.services.note;

import com.example.my_fit.model.entity.Note;
import com.example.my_fit.model.view.NoteCreateRequestModel;

public interface NoteService {
    Note createNote(NoteCreateRequestModel model);
}
