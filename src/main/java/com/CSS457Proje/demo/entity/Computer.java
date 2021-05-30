package com.CSS457Proje.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//Computer Class
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Computer")
public class Computer extends Product{
    private int storageCapacity;
    private int memory;
    private String processor;
    private String screenResolution;

}
