package com.CSS457Proje.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Review")

public class Review {

    @Id
    @GeneratedValue
    private int Product_ID;
    private String Comment;
    private int rating;

}
