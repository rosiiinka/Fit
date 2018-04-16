package com.example.my_fit.services.product;

import com.example.my_fit.model.entity.Product;
import com.example.my_fit.model.view.ProductCreateRequestModel;

public interface ProductService {
    Product createProduct(ProductCreateRequestModel model);
}
