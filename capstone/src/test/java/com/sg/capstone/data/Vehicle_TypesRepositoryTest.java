/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.data;

import com.sg.capstone.model.vehicle_types;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author blair
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Vehicle_TypesRepositoryTest {

    @Autowired
    private Vehicle_TypesRepository vehicle_TypesRepository;

    public Vehicle_TypesRepositoryTest() {
    }

    @Test
    public void testSomeMethod() {

        List<vehicle_types> vehicle_type = vehicle_TypesRepository.findAll();
        assertTrue(vehicle_type.size() > 0);
    }

}
