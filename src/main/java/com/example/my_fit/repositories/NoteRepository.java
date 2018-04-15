package com.example.my_fit.repositories;

import com.example.my_fit.model.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    Note findAllByUsers (Long id);
}
