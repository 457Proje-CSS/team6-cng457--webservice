package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.service.ExtraFeaturesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * This Controller does database connection with webservice in terms of ExtraFeature entity
 */
@RestController
public class ExtraFeaturesController {
    @Autowired
    private ExtraFeaturesService Featureservice;
    /**
     * This function adds Extra Feature with given ExtraFeature  informations with POST request method
     * @param extraFeature with request body
     * @return Extra feature goes to saveFeature function of Featureservice
     */
    @PostMapping("/addFeature")
    public ExtraFeature addFeature(@RequestBody ExtraFeature extraFeature){
        return Featureservice.saveFeature(extraFeature);
    }
    /**
     * This function gets all Extra Features with their ExtraFeature informations with GET request method
     * @return getFeatures function of Featureservice
     */
    @GetMapping("/getFeatures")
    public List<ExtraFeature> getFeatures(){
        return Featureservice.getFeatures();
    }
    /**
     * This function gets Extra Feature that has given id with their ExtraFeature informations with GET request method
     * @param id
     * @return id goes to getFeature function of Featureservice
     */
    @GetMapping("/getFeature/{id}")
    public ExtraFeature getFeature(@PathVariable int id){
        return Featureservice.getFeature(id);
    }
    /**
     * This function deletes Extra Feature that has given id with their ExtraFeature informations with GET request method
     * @param id
     * id goes to deleteFeature function of Featureservice
     */
    @DeleteMapping("/deleteFeature/{id}")
    public void deleteFeature(@PathVariable int id){
        Featureservice.deleteFeature(id);
    }
}
