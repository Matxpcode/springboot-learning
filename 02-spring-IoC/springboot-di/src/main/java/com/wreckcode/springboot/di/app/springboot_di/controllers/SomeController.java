package com.wreckcode.springboot.di.app.springboot_di.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.wreckcode.springboot.di.app.springboot_di.models.Product;
import com.wreckcode.springboot.di.app.springboot_di.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class SomeController {

    private ProductService service = new ProductService();

    @GetMapping("/list")
    public List<Product> list() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
    
}
