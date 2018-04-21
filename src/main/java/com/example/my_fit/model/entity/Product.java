package com.example.my_fit.model.entity;

import javax.persistence.*;

@Entity
public class Product {

    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer calories;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }
}
