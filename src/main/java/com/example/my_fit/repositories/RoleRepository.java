package com.example.my_fit.repositories;

import com.example.my_fit.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findFirstByName(String name);
}
