package com.CSS457Proje.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Extra_Feature")
public class ExtraFeature {
    @Id
    @Column(name = "FeatureID", unique = true, nullable = false)
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private int FeatureID;
    private String feature;

    @ManyToMany(mappedBy = "features")
    private List<Product> products;
}
