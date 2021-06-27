package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Review;
import com.CSS457Proje.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * This Controller does database connection with webservice in terms of Review entity
 */
@RestController
public class ReviewController {
    @Autowired
    private ReviewService Reviewservice;

    /**
     * This function adds Computer with given Computer informations with POST request method
     * @param review with request body
     * @return Extra feature goes to saveFeature function of Featureservice
     */
    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return Reviewservice.saveReview(review);
    }
    /**
     * This function gets all Extra Features with their ExtraFeature informations with GET request method
     * @param
     * @return getFeatures function of Featureservice
     */
    @GetMapping("/getReviews")
    public List<Review> getReview(){
        return Reviewservice.getReviews();
    }
    /**
     * This function gets Extra Feature that has given id with their ExtraFeature informations with GET request method
     * @param id
     * @return id goes to getFeature function of Featureservice
     */
    @GetMapping("/getReview/{id}")
    public Review getReview(@PathVariable int id){
        return Reviewservice.getReview(id);
    }
    /**
     * This function deletes Extra Feature that has given id with their ExtraFeature informations with GET request method
     * @param id
     * @return id goes to deleteFeature function of Featureservice
     */
    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable int id){
        Reviewservice.deleteReview(id);
    }
}
