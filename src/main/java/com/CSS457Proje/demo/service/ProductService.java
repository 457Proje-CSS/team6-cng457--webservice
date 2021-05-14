package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.repository.productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private productrepository repo;

    public Product saveProduct(Product product){
        return repo.save(product);
    }

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProduct(int productID){
        return repo.findById(productID).orElse(null);
    }

    public void deleteProduct(int id){
         repo.deleteById(id);
    }

}
