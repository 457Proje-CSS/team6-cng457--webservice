package com.CSS457Proje.demo.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Id private int ReviewID;
    @ManyToOne
    @JsonBackReference
    private Product productFkey;
    private String Comment;
    private int rating;
}
