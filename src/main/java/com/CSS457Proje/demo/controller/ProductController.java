package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService Productservice;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return Productservice.saveProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() { return Productservice.getProducts(); }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable int id){
        return Productservice.getProduct(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id){
        Productservice.deleteProduct(id);
    }
}
