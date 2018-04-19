package com.example.my_fit.model.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class NoteBindingModel {

    @NotEmpty(message = "Title name cannot be empty.")
    @Size(min=3, max=20, message = "Title name must be between 3 and 30 symbols long.")
    private String product;

    @NotEmpty(message = "Quantity calories cannot be empty.")
    private String quantity;

    public NoteBindingModel() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
