package oma.lukulista.teos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import oma.lukulista.listat.TeosLista;
import oma.lukulista.tekija.Kirjailija;
import oma.lukulista.tekija.Tekija;
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
public class KirjaTest {
    
    public KirjaTest() {
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
    public void equalsTunnistaaSamanTekijanSamannimisetSamaksi(){
        Tekija asimov = new Kirjailija("Asimov, Isaac", new TeosLista());
        
        Kirja k1 = new Kirja("Säätiö", asimov);
        Kirja k2 = new Kirja("Säätiö", asimov);
        
        assertEquals(k1, k2);
    }
    
    @Test
    public void equalsTunnistaaEriTekijanSamannimisetEriksi(){
        Tekija asimov = new Kirjailija("Asimov, Isaac", new TeosLista());
        Tekija joku = new Kirjailija("joku", new TeosLista());
        
        Kirja k1 = new Kirja("Säätiö", asimov);
        Kirja k2 = new Kirja("Säätiö", joku);
        
        assertNotEquals(k1, k2);
    }
    
    @Test
    public void equalsTunnistaaSamanTekijanErinimisetEriksi(){
        Tekija asimov = new Kirjailija("Asimov, Isaac", new TeosLista());
        
        Kirja k1 = new Kirja("Säätiö", asimov);
        Kirja k2 = new Kirja("I, Robot", asimov);
        
        assertNotEquals(k1, k2);
    }
    
    
}
