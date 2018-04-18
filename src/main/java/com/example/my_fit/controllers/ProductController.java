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

    @GetMapping("/products/create_product")
//    @PreAuthorize("hasRole('USER')")
    public ModelAndView createProduct() {
        return new ModelAndView("/products/product.html");
    }

    @PostMapping("/notes/product")
    public ModelAndView createProduct(ProductCreateRequestModel model) {
        this.productService.createProduct(model);

        return new ModelAndView("redirect:/products/product");
    }

    @GetMapping("/products")
//    @PreAuthorize("isAuthenticated()")
    public ModelAndView products( ModelAndView modelAndView) {
        modelAndView.setViewName("products/products");

        modelAndView.addObject("products", this.productService.getAllProducts());

        return modelAndView;
    }

    @GetMapping("/products/product")
//    @PreAuthorize("isAuthenticated()")
    public ModelAndView product( ModelAndView modelAndView, Long id) {
        modelAndView.setViewName("products/product");

        modelAndView.addObject("product", this.productService.getById(id));

        return modelAndView;
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView deleteProduct(@PathVariable Long id, ModelAndView modelAndView, Model model, ModelMapper modelMapper) {
//        ProductServiceModel productById = this.productService.getById(id);
//
//        modelAndView.setViewName("create_product");
//
////        model.addAttribute("name", modelMapper.map(productById, AddVirusBindingModel.class));
//
//        ProductCreateRequestModel viewModel = new ProductCreateRequestModel();
//        viewModel.setId(productById.getId());
//
////        modelAndView.addObject("virusViewModel", viewModel);
//
//        return modelAndView;
//    }
//
//    @PostMapping("/delete/{id}")
//    public ModelAndView deleteConfirm(@PathVariable Long id, ModelAndView modelAndView) {
//        this.productService.deleteProduct(id);
//
//        modelAndView.setViewName("redirect:/modes");
//
//        return modelAndView;
//    }


}
