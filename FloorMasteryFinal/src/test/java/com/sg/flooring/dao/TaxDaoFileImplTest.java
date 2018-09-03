/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooring.dao;

import com.sg.flooring.dao.TaxDaoFileImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.sg.flooring.dao.FlooringTaxDao;

/**
 *
 * @author blair
 */
public class TaxDaoFileImplTest {
    
    FlooringTaxDao dao = new TaxDaoFileImpl();
    
    @Test
    public void testGetAllTaxInfo() throws Exception {
        assertTrue(dao.getAllTaxInfo().size() > 0);
    }
    
}
