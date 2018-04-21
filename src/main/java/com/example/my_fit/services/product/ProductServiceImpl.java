package com.example.my_fit.services.product;

import com.example.my_fit.model.entity.Product;
import com.example.my_fit.model.service.ProductServiceModel;
import com.example.my_fit.model.view.ProductViewModel;
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
    public Product createProduct(ProductViewModel model) {
        Product product = new Product();
        product.setId(model.getId());
        product.setName(model.getName());
        product.setCalories(model.getCalories());

        return this.productRepository.save(product);
    }

    @Override
    public List<ProductViewModel> getAllProducts() {
        ModelMapper modelMapper = new ModelMapper();

        return this.productRepository
                .findAll()
                .stream()
                .map(x -> modelMapper.map(x, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductServiceModel getById(Long id) {

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(this.productRepository.findById(id), ProductServiceModel.class);
    }

//    @Override
//    public void editProduct(Long id, ProductBindingModel product) {
//        ModelMapper modelMapper = new ModelMapper();
//
//        Product productEntity = this.productRepository
//                .findById(id)
//                .orElse(null);
//
//        if(productEntity == null) return;
//
//        modelMapper.map(product, productEntity);
//
//        productEntity.setName(product.getName());
//        productEntity.setCalories(product.getCalories());
//
//        this.productRepository.save(productEntity);
//    }
//
//    @Override
//    public void deleteProduct(Long id) {
//        if(this.productRepository.findById(id).orElse(null) != null) {
//            this.productRepository.deleteById(id);
//        }
//    }
}
