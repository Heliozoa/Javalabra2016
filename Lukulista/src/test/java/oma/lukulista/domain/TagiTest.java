/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain;

import oma.lukulista.domain.Tagi;
import oma.lukulista.testiapurit.EqualsTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sasami-san
 */
public class TagiTest {
    
    EqualsTest equalsTest;
    
    public TagiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        equalsTest = new EqualsTest();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void equalsTunnistaaSamannimisetSamaksi(){
        Tagi t1 = new Tagi("tagi");
        Tagi t2 = new Tagi("tagi");
        
        equalsTest.tunnistaaSamat(t1, t2);
    }
    
    @Test
    public void equalsTunnistaaErinimisetEriksi(){
        Tagi t1 = new Tagi("tagi");
        Tagi t2 = new Tagi("igat");
        
        equalsTest.tunnistaaErit(t1, t2);
    }
    
    @Test
    public void equalsNullillaEiTuotaOngelmia(){
        Tagi t1 = new Tagi("tagi");
        
        equalsTest.nullEiTuotaOngelmia(t1);
    }
}
