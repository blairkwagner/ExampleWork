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
public class Sales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicle;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private users user;
}
