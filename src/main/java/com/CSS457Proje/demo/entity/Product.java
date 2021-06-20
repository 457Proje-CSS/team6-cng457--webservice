package com.CSS457Proje.demo.entity;
import java.io.Serializable;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Product implements Serializable {
    @javax.persistence.Id
    @Column(name = "productID", unique = true, nullable = false)
    private int productID;

    private String name;
    private int price;
    private String brand;
    private String model;
    private String screenSize;


    public List<Review> getReviews() {
        return reviews;
    }

    public List<ExtraFeature> getFeatures() {
        return features;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "productFkey")
    @JsonIgnoreProperties("reviews")
    private List<Review> reviews = new ArrayList<Review>();

    @ManyToMany
    @JoinTable(
            name="Product_Features",
            joinColumns=@JoinColumn(name="Product_ID", referencedColumnName="productID"),
            inverseJoinColumns=@JoinColumn(name="Feature_ID", referencedColumnName="FeatureID"))
    @JsonIgnoreProperties("features")
    private List<ExtraFeature> features;
}
