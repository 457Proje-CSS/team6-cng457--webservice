package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.repository.phonerepository;
import com.CSS457Proje.demo.repository.productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private phonerepository phonerepository;

    public Phone savePhone(Phone phone){
        return phonerepository.save(phone);
    }

    public List<Phone> getPhones(){
        return phonerepository.findAll();
    }

    public Phone getPhone(int id){
        return phonerepository.findById(id).orElse(null);
    }

    public void deletePhone(int id){ phonerepository.deleteById(id); }

    public List<Phone> getPhonebyBrand(String brand){return  phonerepository.getPhonebyBrand(brand); }

    public List<Phone> getPhonebyInternalmemory(int internalmemory){return  phonerepository.getPhonebyInternalmemory(internalmemory); }

    public List<Phone> getPhonebyName(String name){return  phonerepository.getPhonebyName(name); }

    public List<Phone> getPhonebyPrice(int price){return  phonerepository.getPhonebyPrice(price); }

    public List<Phone> getPhonebyModel(String model){return  phonerepository.getPhonebyModel(model); }

    public List<Phone> getPhonebyScreenSize(String screenSize){return  phonerepository.getPhonebyScreenSize(screenSize); }
}
