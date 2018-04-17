package com.example.my_fit.controllers;

import com.example.my_fit.model.view.ProductCreateRequestModel;
import com.example.my_fit.services.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/notes/product")
//    @PreAuthorize("hasRole('USER')")
    public ModelAndView createProduct() {
        return new ModelAndView("/notes/product.html");
    }

    @PostMapping("/notes/product")
    public ModelAndView createProduct(ProductCreateRequestModel model) {
        this.productService.createProduct(model);

        return new ModelAndView("redirect:/notes/product");
    }
}
