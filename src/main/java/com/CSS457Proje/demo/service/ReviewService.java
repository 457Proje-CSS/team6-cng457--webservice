package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.entity.Review;
import com.CSS457Proje.demo.repository.reviewrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private reviewrepository repo;

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Review saveReview(Review review){
        return repo.save(review);
    }

    public List<Review> getReviews(){
        return repo.findAll();
    }

    public Review getReview(int ReviewID){
        return repo.findById(ReviewID).orElse(null);
    }

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void deleteReview(int ReviewID){ repo.deleteById(ReviewID); }

}