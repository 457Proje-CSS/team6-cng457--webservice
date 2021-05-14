package com.CSS457Proje.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {
    @Id
    private int productID;

    private String name;
    private int price;
    private String brand;
    private String model;
    private String ScreenSize;

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @javax.persistence.Id
    public int getProductID() {
        return productID;
    }

    @OneToMany(targetEntity = Review.class, cascade= CascadeType.ALL)
    @ManyToMany(targetEntity = ExtraFeature.class, cascade= CascadeType.ALL)
    //List<Review> Reviews;

}
