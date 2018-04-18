package com.example.my_fit.services.note;

import com.example.my_fit.model.entity.Note;
import com.example.my_fit.model.view.NoteCreateRequestModel;
import com.example.my_fit.repositories.NoteRepository;
import com.example.my_fit.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NoteServiceImlp implements NoteService {

    private final NoteRepository noteRepository;
    private final ProductRepository productRepository;

    public NoteServiceImlp(NoteRepository noteRepository, ProductRepository productRepository) {
        this.noteRepository = noteRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Note createNote(NoteCreateRequestModel model) {
        Note note = new Note();
        note.setProduct(model.getProduct());
        note.setQuantity(model.getQuantity());

//        Product product = (Product) this.productRepository.findAllByNameAndCalories("");
//        product.getName().add(product);
//        product.getCalories().add(product);

//        this.productRepository.save(product);

        return this.noteRepository.save(note);
    }

    @Override
    public List<NoteCreateRequestModel> getAllNotes() {
            ModelMapper modelMapper = new ModelMapper();

            return this.noteRepository
                    .findAll()
                    .stream()
                    .map(x -> modelMapper.map(x, NoteCreateRequestModel.class))
                    .collect(Collectors.toList());

    }
}
