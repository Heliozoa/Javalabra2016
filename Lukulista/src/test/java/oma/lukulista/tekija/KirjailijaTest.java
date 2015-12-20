package oma.lukulista.tekija;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import oma.lukulista.listat.TeosLista;
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
public class KirjailijaTest {
    
    public KirjailijaTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void equalsTunnistaaSamannimisetSamaksi(){
        Kirjailija isaac = new Kirjailija("Asimov, Isaac", new TeosLista());
        Kirjailija asimov = new Kirjailija("Asimov, Isaac", new TeosLista());
        
        assertEquals(isaac, asimov);
    }
    
    @Test
    public void equalsTunnistaaErinimisetEriksi(){
        Kirjailija asimov = new Kirjailija("Asimov, Isaac", new TeosLista());
        Kirjailija joku = new Kirjailija("Waltari, Mika", new TeosLista());
        
        assertNotEquals(asimov, joku);
    }
}
