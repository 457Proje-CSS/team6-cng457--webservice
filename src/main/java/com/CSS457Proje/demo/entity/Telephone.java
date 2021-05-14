package com.CSS457Proje.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Telephone")
public class Telephone extends Product{
    private int internalMemory;
    @ManyToOne(targetEntity = TelephoneInventory.class, cascade= CascadeType.ALL)

}