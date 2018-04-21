package com.example.my_fit.model.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ModeBindingModel {

    @NotEmpty(message = "Title name cannot be empty.")
    @Size(min=3, max=20, message = "Title name must be between 3 and 30 symbols long.")
    private String title;

    @NotEmpty(message = "Description calories cannot be empty.")
    @Size(min=100, max=1000, message = "Description name must be between 3 and 250 symbols long.")
    private String Description;

    public ModeBindingModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
