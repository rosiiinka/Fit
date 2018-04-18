package com.example.my_fit.services.product;

import com.example.my_fit.model.entity.Product;
import com.example.my_fit.model.view.ProductCreateRequestModel;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductCreateRequestModel model);

    List<ProductCreateRequestModel> getAllProducts();
}
