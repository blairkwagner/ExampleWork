/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.UI;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author blair
 */
public interface UserIO {
    void print(String msg);

    int readInt(String prompt);
    
    int readInt(String prompt, int min, int max);
    
    String readString(String prompt);
    
    BigDecimal readBigDecimal(String prompt);
    
    BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max);
    
    LocalDate readLocalDate(String prompt);
}
