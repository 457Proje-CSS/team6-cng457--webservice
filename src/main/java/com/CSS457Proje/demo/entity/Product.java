package com.CSS457Proje.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

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

    

    @ManyToMany(targetEntity = Extra_Feature.class, cascade= CascadeType.ALL)
    @JoinColumn(name="product_id",referencedColumnName = "productID")
    List<Extra_Feature> ExtraFeatures;
  
    @OneToMany(targetEntity = Review.class, cascade= CascadeType.ALL)
    @JoinColumn(name="Product_ID", referencedColumnName = "productID")
    List<Review> Reviews;



}
