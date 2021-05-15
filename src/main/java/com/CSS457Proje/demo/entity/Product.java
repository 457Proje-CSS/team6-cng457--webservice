package com.CSS457Proje.demo.entity;
import java.util.*;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "product")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "productID")
    private Long productID;

    private String name;
    private int price;
    private String brand;
    private String model;
    private String ScreenSize;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productFkey")
    private List<Review> reviews = new ArrayList<Review>();

    public void addReviewToProduct(Review review) {
        review.setReviewID(this);
        this.reviews.add(review);
    }
    }
