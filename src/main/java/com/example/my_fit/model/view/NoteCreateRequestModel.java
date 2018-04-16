package com.example.my_fit.model.view;

import com.example.my_fit.model.entity.Product;

import java.util.Set;

public class NoteCreateRequestModel {
    private Set<Product> product;

    private Integer quantity;

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
