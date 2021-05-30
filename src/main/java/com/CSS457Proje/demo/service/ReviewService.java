package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.entity.Review;
import com.CSS457Proje.demo.repository.reviewrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private reviewrepository repo;

    public Review saveReview(Review review){
        return repo.save(review);
    }

    public List<Review> getReviews(){
        return repo.findAll();
    }

    public Review getReview(int ReviewID){
        return repo.findById(ReviewID).orElse(null);
    }

    public void deleteReview(int ReviewID){ repo.deleteById(ReviewID); }

}