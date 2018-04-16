package com.example.my_fit.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    private Long id;

    private String name;

    private Integer calories;

    private Set<Note> notes;

    public Product() {
        this.notes = new HashSet<>();
    }

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

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
