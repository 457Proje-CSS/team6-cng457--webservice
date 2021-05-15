package com.CSS457Proje.demo.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="review")

public class Review implements Serializable{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "productFkey", referencedColumnName = "productID",foreignKey = @ForeignKey(name = "TestKey"))
    @javax.persistence.Id
    private Product productFkey;

    private String Comment;
    private int rating;
    public void setReviewID(Product prodID) {
        this.productFkey = prodID;
    }
}
