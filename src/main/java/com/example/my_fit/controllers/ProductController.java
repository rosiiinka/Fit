package com.example.my_fit.controllers;

import com.example.my_fit.model.binding.ProductBindingModel;
import com.example.my_fit.model.service.ProductServiceModel;
import com.example.my_fit.model.view.ProductCreateRequestModel;
import com.example.my_fit.services.product.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products/create_product")
//    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView product( ModelAndView modelAndView, Long id) {
        modelAndView.setViewName("products/product");

        modelAndView.addObject("product", this.productService.getById(id));

        return modelAndView;
    }

    @PostMapping("/products/create_product")
//    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createProduct(ProductCreateRequestModel model) {
        this.productService.createProduct(model);

        return new ModelAndView("redirect:/products/product");
    }

    @GetMapping("/products")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ModelAndView products( ModelAndView modelAndView) {
        modelAndView.setViewName("products/products");

        modelAndView.addObject("products", this.productService.getAllProducts());

        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    //    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView editProduct(@PathVariable Long id, ModelAndView modelAndView, Model model, ModelMapper modelMapper) {
        ProductServiceModel productById = this.productService.getById(id);

        modelAndView.setViewName("products");

        if(!model.containsAttribute("productInput")) {
            ProductBindingModel bindingModel = modelMapper.map(productById, ProductBindingModel.class);

            model.addAttribute("productInput", bindingModel);
        }

        ProductCreateRequestModel viewModel = new ProductCreateRequestModel();

        viewModel.setId(productById.getId());

        modelAndView.addObject("productViewModel", viewModel);

        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    //    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView editProductConfirm(@PathVariable Long id, @Valid @ModelAttribute(name = "productInput") ProductBindingModel productBindingModel, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productInput", bindingResult);
            redirectAttributes.addFlashAttribute("productInput", productBindingModel);

            modelAndView.setViewName("redirect:/products");
        } else {
            this.productService.editProduct(id, productBindingModel);
            modelAndView.setViewName("redirect:/products");
        }

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    //    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView deleteVirus(@PathVariable Long id, ModelAndView modelAndView, Model model, ModelMapper modelMapper) {
        ProductServiceModel productById = this.productService.getById(id);

        modelAndView.setViewName("products");

        model.addAttribute("productInput", modelMapper.map(productById, ProductBindingModel.class));

        ProductCreateRequestModel viewModel = new ProductCreateRequestModel();
        viewModel.setId(productById.getId());

        modelAndView.addObject("productViewModel", viewModel);

        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    //    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView deleteConfirm(@PathVariable Long id, ModelAndView modelAndView) {
        this.productService.deleteProduct(id);

        modelAndView.setViewName("redirect:/products");

        return modelAndView;
    }

}
