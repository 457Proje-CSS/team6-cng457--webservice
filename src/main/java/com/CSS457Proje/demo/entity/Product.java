package com.CSS457Proje.demo.entity;
import java.io.Serializable;
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
public abstract class Product implements Serializable {
    @javax.persistence.Id
    @Column(name = "productID", unique = true, nullable = false)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private int productID;

    private String name;
    private int price;
    private String brand;
    private String model;
    private String screenSize;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productFkey")
    private List<Review> reviews = new ArrayList<Review>();

    @ManyToMany
    @JoinTable(
            name="Product_Features",
            joinColumns=@JoinColumn(name="Product_ID", referencedColumnName="productID"),
            inverseJoinColumns=@JoinColumn(name="Feature_ID", referencedColumnName="FeatureID"))
    private List<ExtraFeature> features;

    public void addReviewToProduct(Review review) {
        review.setReviewID(this);
        this.reviews.add(review);
    }
}
