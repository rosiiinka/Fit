package com.example.my_fit.services.product;

import com.example.my_fit.model.entity.Product;
import com.example.my_fit.model.service.ProductServiceModel;
import com.example.my_fit.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductViewModel model);

    List<ProductViewModel> getAllProducts();

    ProductServiceModel getById(Long id);

//    void deleteProduct(Long id);
//
//    void editProduct(Long id, ProductBindingModel product);

}
