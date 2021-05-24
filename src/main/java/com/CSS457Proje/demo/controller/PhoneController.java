package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.service.PhoneService;
import com.CSS457Proje.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @PostMapping("/addPhone")
    public Phone addProduct(@RequestBody Phone phone){
        return phoneService.savePhone(phone);
    }

    @GetMapping("/getPhones")
    public List<Phone> getProducts() { return phoneService.getPhones(); }

    @GetMapping("/getPhone/{id}")
    public Phone getProduct(@PathVariable int id){
        return phoneService.getPhone(id);
    }

    @DeleteMapping("/deletePhone/{id}")
    public void deleteProduct(@PathVariable int id){
        phoneService.deletePhone(id);
    }
}
