/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.data;

import com.sg.capstone.model.Models;
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
public class ModelsRepositoryTest {
    
    @Autowired
    private ModelsRepository modelsRepository;
    
    public ModelsRepositoryTest() {
    }

    @Test
    public void testSomeMethod() {
         List<Models> model = modelsRepository.findAll();
        assertTrue(model.size() > 0);
    }
    
}
