/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dao.ProductDaoFileImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.sg.flooring.dao.FlooringProductDao;

/**
 *
 * @author blair
 */
public class ProductDaoFileImplTest {
    
    FlooringProductDao dao = new ProductDaoFileImpl();
    
    @Test
    public void testGetAllProducts() throws Exception {
        assertTrue(dao.getAllProducts().size() > 0);
    }
    
}
