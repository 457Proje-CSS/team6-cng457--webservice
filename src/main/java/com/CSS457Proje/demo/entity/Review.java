package com.CSS457Proje.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review")

public class Review {

    @Id
    @GeneratedValue
    @Column(name = "productID", unique = true, nullable = false)
    private int Product_ID;
    private String Comment;
    private int rating;

}
