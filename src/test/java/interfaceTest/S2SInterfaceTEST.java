/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceTest;

import S2S.S2SDummyClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.json.simple.JSONObject;
import static org.junit.Assert.*;


/**
 *
 * @author nickl
 */
public class S2SInterfaceTEST {
    
    public S2SInterfaceTEST() {
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
    public void getJsonFromServer(){
        S2SDummyClass s2s = new S2SDummyClass();
        String from = "CPH Airport";
        String date = "someday";
        int tickets = 0;
        
        JSONObject json = s2s.getJsonFromServer(from, date, tickets);
        Object fromRet = json.get("from: ");
        Object dateRet = json.get("date: ");
        Object ticketsRet = json.get("tickets: ");
        
        assertEquals(from,fromRet);
        assertEquals(date,dateRet);
    }

}
