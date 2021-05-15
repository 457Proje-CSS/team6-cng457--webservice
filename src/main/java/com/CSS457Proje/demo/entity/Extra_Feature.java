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
public class Extra_Feature {
    @Id
    @GeneratedValue
    @Column(name = "Product_ID", unique = true, nullable = false)
    private int Product_ID;
    private boolean touch_screen;
    private boolean face_recognition;
    private boolean fingerprint_reader;
    private boolean extra_long_battery_life;
    private boolean all_day_battery_life;

    @OneToMany(mappedBy = "ext_feature")
    private List<Product> products;
}
