package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.repository.extrafeaturerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraFeaturesService {
    @Autowired
    private extrafeaturerepository repo;

}