/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain;

import oma.lukulista.domain.Kategoria;
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
public class KategoriaTest {
    
    EqualsTest equalsTest;
    
    public KategoriaTest() {
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
        Kategoria k1 = new Kategoria("Sci-Fi");
        Kategoria k2 = new Kategoria("Sci-Fi");
        
        equalsTest.tunnistaaSamat(k1, k2);
    }
    
    @Test
    public void equalsTunnistaaErinimisetEriksi(){
        Kategoria k1 = new Kategoria("Sci-Fi");
        Kategoria k2 = new Kategoria("Fantasia");
        
        equalsTest.tunnistaaErit(k1, k2);
    }
    
    @Test
    public void equalsNullillaEiTuotaOngelmia(){
        Kategoria k1 = new Kategoria("Sci-Fi");
        
        equalsTest.nullEiTuotaOngelmia(k1);
    }
}
