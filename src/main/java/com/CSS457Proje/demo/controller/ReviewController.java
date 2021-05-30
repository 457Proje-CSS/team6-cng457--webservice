package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Review;
import com.CSS457Proje.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService Reviewservice;


    @PostMapping("/addReview")
    public Review addReview(@RequestBody Review review){
        return Reviewservice.saveReview(review);
    }

    @GetMapping("/getReviews")
    public List<Review> getReview(){
        return Reviewservice.getReviews();
    }

    @GetMapping("/getReview/{id}")
    public Review getReview(@PathVariable int id){
        return Reviewservice.getReview(id);
    }

    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable int id){
        Reviewservice.deleteReview(id);
    }
}
