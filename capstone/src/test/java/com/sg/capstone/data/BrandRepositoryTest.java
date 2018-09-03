/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.data;

import com.sg.capstone.model.Brand;
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
public class BrandRepositoryTest {

    @Autowired
    private BrandRepository brandRepository;

    public BrandRepositoryTest() {

    }

    @Test
    public void testSomeMethod() {

        List<Brand> brands = brandRepository.findAll();
        assertTrue(brands.size() > 0);
    }

    @Test
    public void testFindNames() {
    }

   
}
