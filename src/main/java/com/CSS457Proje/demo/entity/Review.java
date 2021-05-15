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

public class Review{
    @Column(name = "ReviewID", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id private int ReviewID;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product productFkey;
    private String Comment;
    private int rating;
    public void setReviewID(Product prodID) {
        this.productFkey = prodID;
    }
}
