package com.CSS457Proje.demo.controller;


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
     * This function adds  Review with given Review  informations with POST request method
     * @param review with request body
     * @return  Review goes to saveReview function of Reviewservice
     */
    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return Reviewservice.saveReview(review);
    }
    /**
     * This function gets all  Reviews with their Review informations with GET request method
     * @return getReviews function of Reviewservice
     */
    @GetMapping("/getReviews")
    public List<Review> getReview(){
        return Reviewservice.getReviews();
    }
    /**
     * This function gets  Review that has given id with their Review informations with GET request method
     * @param id
     * @return id goes to getReview function of Reviewservice
     */
    @GetMapping("/getReview/{id}")
    public Review getReview(@PathVariable int id){
        return Reviewservice.getReview(id);
    }
    /**
     * This function deletes  Review that has given id with their Review informations with GET request method
     * @param id
     * id goes to deleteReview function of Reviewservice
     */
    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable int id){
        Reviewservice.deleteReview(id);
    }
}
