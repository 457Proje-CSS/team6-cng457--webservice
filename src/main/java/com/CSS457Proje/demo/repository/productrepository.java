package com.CSS457Proje.demo.repository;

import com.CSS457Proje.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productrepository extends JpaRepository<Product,Integer> {

}
