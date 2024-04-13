package com.bexos.productservice.controllers;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/categories")
@Getter
@Setter
@RefreshScope // This will refresh all the @value data in this bean after /actuator/refresh is called
public class CategoryController {
    @Value("${app.prop1}")
    private String prop1;

    @GetMapping("/prop")
    public String getProp1(){
        return prop1;
    }
}
