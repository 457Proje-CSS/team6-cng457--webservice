package com.CSS457Proje.demo.repository;

import com.CSS457Proje.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface phonerepository extends JpaRepository<Phone,Integer> {
    @Query("SELECT c from Phone c WHERE c.brand LIKE %?1%")
    public List<Phone> getPhonebyBrand(String brand);

    @Query("SELECT c from Phone c WHERE c.internalMemory = ?1")
    public List<Phone> getPhonebyInternalmemory(int internalmemory);

    @Query("SELECT c from Phone c WHERE c.name LIKE %?1%")
    public List<Phone> getPhonebyName(String name);

    @Query("SELECT c from Phone c WHERE c.price = ?1")
    public List<Phone> getPhonebyPrice(int price);

    @Query("SELECT c from Phone c WHERE c.model LIKE %?1%")
    public List<Phone> getPhonebyModel(String model);

    @Query("SELECT c from Phone c WHERE c.screenSize LIKE %?1%")
    public List<Phone> getPhonebyScreenSize(String screenSize);
}
