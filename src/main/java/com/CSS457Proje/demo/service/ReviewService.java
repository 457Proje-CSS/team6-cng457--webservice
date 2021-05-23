package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.repository.reviewrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private reviewrepository repo;


}