/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.data;

import com.sg.capstone.model.Vehicles;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

/**
 *
 * @author blair
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VehiclesRepositoryTest {

    @Autowired
    private VehiclesRepository vehiclesRepository;

    public VehiclesRepositoryTest() {
    }

    @Test
    public void testSomeMethod() {
        List<Vehicles> vehicle = vehiclesRepository.findAll();
        assertTrue(vehicle.size() > 0);
    }

}
