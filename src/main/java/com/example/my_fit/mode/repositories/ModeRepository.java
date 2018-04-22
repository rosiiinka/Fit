package com.example.my_fit.mode.repositories;

import com.example.my_fit.mode.model.entity.Mode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeRepository extends JpaRepository<Mode, Long> {

    Mode findAllByTitle(String title);
}
