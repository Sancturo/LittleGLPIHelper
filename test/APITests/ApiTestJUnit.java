/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APITests;

import apitest.APITest;
import apitest.ManageConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author korabel245
 */
public class ApiTestJUnit {
        String getTickets = "Ticket/?range=0-1000";
        String getComputers = "Computer/10?forcedisplay[0]=126&range=0-1000";
        String getComputerLog = "/Computer/10?with_networkports=true";
        String searchOpts = "/listSearchOptions/Computer/";
//        String test = "/Computer/10/?with_networkports=true";
        String test = "/search/Computer?forcedisplay[0]=126&range=0-1000";
    
    public ApiTestJUnit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void ApiTest(){
        APITest.makeRequest();
        
    }
    
    
    
}
