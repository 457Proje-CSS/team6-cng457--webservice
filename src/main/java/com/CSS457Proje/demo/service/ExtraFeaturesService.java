package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.repository.extrafeaturerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import java.util.List;

@Service
public class ExtraFeaturesService {
    @Autowired
    private extrafeaturerepository repo;

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public ExtraFeature saveFeature(ExtraFeature extraFeature){
        return repo.save(extraFeature);
    }

    public List<ExtraFeature> getFeatures(){
        return repo.findAll();
    }

    public ExtraFeature getFeature(int FeatureID){
        return repo.findById(FeatureID).orElse(null);
    }

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void deleteFeature(int FeatureID){ repo.deleteById(FeatureID); }
}