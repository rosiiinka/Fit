package com.example.my_fit.services.note;

import com.example.my_fit.model.entity.Note;
import com.example.my_fit.model.entity.User;
import com.example.my_fit.model.view.NoteViewModel;
import com.example.my_fit.repositories.NoteRepository;
import com.example.my_fit.repositories.UserRepository;
import com.example.my_fit.services.user.UserServiceImpl;
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
    private final UserServiceImpl userService;

    public NoteServiceImlp(NoteRepository noteRepository, UserRepository userRepository, UserServiceImpl userService) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public Note createNote(NoteViewModel model, Long id) {
        Note note = new Note();
        note.setId(model.getId());
        note.setProduct(model.getProduct());
        note.setQuantity(model.getQuantity());

        User user = this.userService.findUserEntityById(id);
        note.setUser(user);


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
