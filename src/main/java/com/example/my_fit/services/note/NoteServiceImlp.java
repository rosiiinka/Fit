package com.example.my_fit.services.note;

import com.example.my_fit.model.entity.Note;
import com.example.my_fit.model.view.NoteViewModel;
import com.example.my_fit.repositories.NoteRepository;
import com.example.my_fit.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoteServiceImlp implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteServiceImlp(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Note createNote(NoteViewModel model) {
        Note note = new Note();
        note.setId(model.getId());
        note.setProduct(model.getProduct());
        note.setQuantity(model.getQuantity());

//        User user = this.userRepository.findAllById(model.getId());
//        user.getNotes().add(note);
//        note.getUsers().add(user);
//
//        this.userRepository.save(user);

        return this.noteRepository.save(note);
    }

    @Override
    public List<NoteViewModel> getAllNotes() {
            ModelMapper modelMapper = new ModelMapper();

            return this.noteRepository
                    .findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, NoteViewModel.class))
                    .collect(Collectors.toList());

    }
}
