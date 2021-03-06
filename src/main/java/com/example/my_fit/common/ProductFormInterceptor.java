package com.example.my_fit.common;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class ProductFormInterceptor extends HandlerInterceptorAdapter {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;

        if(method.hasMethodAnnotation(GetMapping.class)) {
            GetMapping annotation = method.getMethodAnnotation(GetMapping.class);

            if(Arrays.stream(annotation.path()).anyMatch(x -> x.contains("edit"))) {
                modelAndView.addObject("formMode", "edit");
            } else if(Arrays.stream(annotation.path()).anyMatch(x -> x.contains("delete"))) {
                modelAndView.addObject("formMode", "delete");
            }
        }
    }
}
