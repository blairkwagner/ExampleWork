/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.data;

import com.sg.capstone.model.Models;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author blair
 */
public interface ModelsRepository extends JpaRepository <Models, Integer>{
    
}
