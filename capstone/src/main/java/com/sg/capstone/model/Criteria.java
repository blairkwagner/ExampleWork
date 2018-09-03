/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 *
 * @author blair
 */
@Data
public class Criteria implements Serializable {

    private String search;
 
    private BigDecimal priceMin;
    private BigDecimal priceMax;
    private int yearMax;
    private int yearMin;

   
}
