package com.example.my_fit.services.product;

import com.example.my_fit.model.entity.Product;
import com.example.my_fit.model.view.ProductCreateRequestModel;
import com.example.my_fit.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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

    @Override
    public List<ProductCreateRequestModel> getAllProducts() {
        ModelMapper modelMapper = new ModelMapper();

        return this.productRepository
                .findAll()
                .stream()
                .map(x -> modelMapper.map(x, ProductCreateRequestModel.class))
                .collect(Collectors.toList());
    }
}
