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

    @GetMapping("/getPhonebyBrand/{brand}")
    public List<Phone> getPhonebyBrand(@PathVariable String brand){ return phoneService.getPhonebyBrand(brand); }

    @GetMapping("/getPhonebyInternalmemory/{internalmemory}")
    public List<Phone> getPhonebyInternalMemory(@PathVariable int internalmemory){ return phoneService.getPhonebyInternalmemory(internalmemory); }

    @GetMapping("/getPhonebyName/{name}")
    public List<Phone> getPhonebyName(@PathVariable String name){ return phoneService.getPhonebyName(name); }

    @GetMapping("/getPhonebyPrice/{price}")
    public List<Phone> getPhonebyPrice(@PathVariable int price){ return phoneService.getPhonebyPrice(price); }

    @GetMapping("/getPhonebyModel/{model}")
    public List<Phone> getPhonebyModel(@PathVariable String model){ return phoneService.getPhonebyModel(model); }

    @GetMapping("/getPhonebyScreensize/{screenSize}")
    public List<Phone> getPhonebyScreenSize(@PathVariable String screenSize){ return phoneService.getPhonebyScreenSize(screenSize); }

}
