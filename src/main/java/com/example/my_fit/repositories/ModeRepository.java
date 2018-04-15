package com.example.my_fit.repositories;

import com.example.my_fit.model.entity.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepository extends JpaRepository<Mode, Long> {

    Mode findAllByTitle(String title);
}
