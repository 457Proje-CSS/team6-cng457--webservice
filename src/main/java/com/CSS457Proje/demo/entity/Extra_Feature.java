package com.CSS457Proje.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Extra_Feature")
public class Extra_Feature {
    @Id
    @GeneratedValue
    @Column(name = "productID", unique = true, nullable = false)
    private int Product_ID;
    private boolean touch_screen;
    private boolean face_recognition;
    private boolean fingerprint_reader;
    private boolean extra_long_battery_life;
    private boolean all_day_battery_life;


}
