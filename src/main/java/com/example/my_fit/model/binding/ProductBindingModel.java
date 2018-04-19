package com.example.my_fit.model.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductBindingModel {
    @NotEmpty(message = "Product name cannot be empty.")
    @Size(min=3, max=20, message = "Product name must be between 3 and 20 symbols long.")
    private String name;

    @NotEmpty(message = "Product calories cannot be empty.")
    private Integer calories;

    public ProductBindingModel() {
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
