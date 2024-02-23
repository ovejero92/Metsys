package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.services.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("/api/products")
    public List<Product> getAll(){
        return service.getAll();
    }
    @GetMapping("/api/products/{id}")
    public Product getById(@PathVariable String id){
        return service.getById(Long.parseLong(id));
    }
    @DeleteMapping("/api/products/{id}")
    public void remove(@PathVariable String id) {
        service.remove(Long.parseLong(id));
    }
    @PostMapping("/api/products")
    public void save(@RequestBody Product product) {
        service.save(product);
    }

}