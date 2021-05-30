package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExtraFeaturesController {
    @Autowired
    private ExtraFeaturesController Featureservice;

    @PostMapping("/addFeature")
    public ExtraFeature addFeature(@RequestBody ExtraFeature extraFeature){
        return Featureservice.addFeature(extraFeature);
    }

    @GetMapping("/getFeatures")
    public List<ExtraFeature> getFeatures(){
        return Featureservice.getFeatures();
    }

    @GetMapping("/getFeature/{id}")
    public ExtraFeature getFeature(@PathVariable int id){
        return Featureservice.getFeature(id);
    }

    @DeleteMapping("/deleteFeature/{id}")
    public void deleteFeature(@PathVariable int id){
        Featureservice.deleteFeature(id);
    }
}