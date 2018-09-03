/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;


/**
 *
 * @author blair
 */
@Data
@Entity
public class Vehicles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String color;
    private String interiorColor;
    private int year;
    private String transmissionType;
    private int mileage;
    private BigDecimal msrp;
    private boolean isNew;
    private String vinNumber;
    private BigDecimal salePrice;
    private String description;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Models models;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private vehicle_types type;

    
}
