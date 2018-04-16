package com.example.my_fit.services.product;

import com.example.my_fit.model.entity.Product;
import com.example.my_fit.model.view.ProductCreateRequestModel;
import com.example.my_fit.repositories.ProductRepository;

public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(ProductCreateRequestModel model) {
        Product product = new Product();
        product.setName(model.getName());
        product.setCalories(model.getCalories());

        return this.productRepository.save(product);
    }
}
