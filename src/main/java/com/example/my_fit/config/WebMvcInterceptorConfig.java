package com.example.my_fit.config;

import com.example.my_fit.common.ModeFormInterceptor;
import com.example.my_fit.common.ProductFormInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcInterceptorConfig implements WebMvcConfigurer {

    private final ProductFormInterceptor productFormInterceptor;
    private final ModeFormInterceptor modeFormInterceptor;

    @Autowired
    public WebMvcInterceptorConfig(ProductFormInterceptor productFormInterceptor, ModeFormInterceptor modeFormInterceptor) {
        this.productFormInterceptor = productFormInterceptor;
        this.modeFormInterceptor = modeFormInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.productFormInterceptor)
                .addPathPatterns( "/products/edit/{id}", "/products/delete/{id}");

        registry.addInterceptor(this.modeFormInterceptor)
                .addPathPatterns( "/modes/edit/{id}", "/modes/delete/{id}");
    }
}
