package com.example.my_fit.repositories;

import com.example.my_fit.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findAllByNameAndCalories(String name, Integer calories);
}
