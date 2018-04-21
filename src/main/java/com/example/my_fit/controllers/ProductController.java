package com.example.my_fit.controllers;

import com.example.my_fit.model.view.ProductViewModel;
import com.example.my_fit.services.product.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
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

//
//    @GetMapping("/products/create_product")
////    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView product( ModelAndView modelAndView, @PathVariable Long id) {
//        modelAndView.setViewName("/products/create_product");
//
//        modelAndView.addObject("product", this.productService.getById(id));
//
//        return modelAndView;
//    }


    @GetMapping("/products/create_product")
//    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createMode() {
        return new ModelAndView("products/create_product.html");
    }


    @PostMapping("/products/create_product")
//    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createProduct(ProductViewModel model) {
        this.productService.createProduct(model);

        return new ModelAndView("redirect:/products/create_product");
    }

    @GetMapping("/products")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ModelAndView products( ModelAndView modelAndView) {
        modelAndView.setViewName("products/products");

        modelAndView.addObject("products", this.productService.getAllProducts());

        return modelAndView;
    }

//    @GetMapping("/edit/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView editProduct(@PathVariable Long id, ModelAndView modelAndView, Model model, ModelMapper modelMapper) {
//        ProductServiceModel productById = this.productService.getById(id);
//
//        modelAndView.setViewName("create_product");
//
//        if(!model.containsAttribute("productInput")) {
//            ProductBindingModel bindingModel = modelMapper.map(productById, ProductBindingModel.class);
//
//            model.addAttribute("productInput", bindingModel);
//        }
//
//        ProductViewModel viewModel = new ProductViewModel();
//
//        viewModel.setId(productById.getId());
//
//        modelAndView.addObject("productViewModel", viewModel);
//
//        return modelAndView;
//    }
//
//    @PostMapping("/edit/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView editProductConfirm(@PathVariable Long id, @Valid @ModelAttribute(name = "productInput") ProductBindingModel productBindingModel, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes) {
//        if(bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productInput", bindingResult);
//            redirectAttributes.addFlashAttribute("productInput", productBindingModel);
//
//            modelAndView.setViewName("redirect:create_product");
//        } else {
//            this.productService.editProduct(id, productBindingModel);
//            modelAndView.setViewName("redirect:/products");
//        }
//
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView deleteProduct(@PathVariable Long id, ModelAndView modelAndView, Model model, ModelMapper modelMapper) {
//        ProductServiceModel productById = this.productService.getById(id);
//
//        modelAndView.setViewName("create_product");
//
//        model.addAttribute("productInput", modelMapper.map(productById, ProductBindingModel.class));
//
//        ProductViewModel viewModel = new ProductViewModel();
//        viewModel.setId(productById.getId());
//
//        modelAndView.addObject("productViewModel", viewModel);
//
//        return modelAndView;
//    }
//
//    @PostMapping("/delete/{id}")
//    //    @PreAuthorize("hasRole('ADMIN')")
//    public ModelAndView deleteConfirm(@PathVariable Long id, ModelAndView modelAndView) {
//        this.productService.deleteProduct(id);
//
//        modelAndView.setViewName("redirect:/products");
//
//        return modelAndView;
//    }
}
