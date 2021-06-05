package com.CSS457Proje.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private int featureID;
    private String feature;

    @ManyToMany(mappedBy = "features")
    @JsonBackReference
    private List<Product> products;
}
