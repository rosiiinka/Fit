package com.example.my_fit.services.note;

import com.example.my_fit.model.entity.Note;
import com.example.my_fit.model.view.NoteCreateRequestModel;
import com.example.my_fit.repositories.NoteRepository;
import com.example.my_fit.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
        note.setProducts(model.getProduct());
        note.setQuantity(model.getQuantity());

//        Product product = (Product) this.productRepository.findAllByNameAndCalories("");
//        product.getName().add(product);
//        product.getCalories().add(product);

//        this.productRepository.save(product);

        return this.noteRepository.save(note);
    }
}
