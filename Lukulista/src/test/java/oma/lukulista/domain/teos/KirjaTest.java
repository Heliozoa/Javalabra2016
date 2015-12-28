package oma.lukulista.domain.teos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.listat.Lista;
import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.testiapurit.EqualsTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sasami-san
 */
public class KirjaTest {
    
    EqualsTest equalsTest;
    
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
        equalsTest = new EqualsTest();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void equalsTunnistaaSamanTekijanSamannimisetSamaksi(){
        Tekija asimov = new Kirjailija("Asimov, Isaac", new Lista<>());
        
        Kirja k1 = new Kirja("Säätiö", asimov);
        Kirja k2 = new Kirja("Säätiö", asimov);
        
        equalsTest.tunnistaaSamat(k1, k2);
    }
    
    @Test
    public void equalsTunnistaaEriTekijanSamannimisetEriksi(){
        Tekija asimov = new Kirjailija("Asimov, Isaac", new Lista<>());
        Tekija joku = new Kirjailija("joku", new Lista<>());
        
        Kirja k1 = new Kirja("Säätiö", asimov);
        Kirja k2 = new Kirja("Säätiö", joku);
        
        equalsTest.tunnistaaErit(k1, k2);
    }
    
    @Test
    public void equalsTunnistaaSamanTekijanErinimisetEriksi(){
        Tekija asimov = new Kirjailija("Asimov, Isaac", new Lista<>());
        
        Kirja k1 = new Kirja("Säätiö", asimov);
        Kirja k2 = new Kirja("I, Robot", asimov);
        
        equalsTest.tunnistaaErit(k1, k2);
    }
    
    @Test
    public void equalsNullillaEiTuotaOngelmia(){
        Kirja k1 = new Kirja("Säätiö", new Kirjailija("Asimov, Isaac", new Lista<>()));
        
        equalsTest.nullEiTuotaOngelmia(k1);
    }
    
    @Test
    public void equalsVaarallaLuokallaEiTuotaOngelmia(){
        Tekija t1 = new Kirjailija("Asimov, Isaac", new Lista<>());
        Kirja k1 = new Kirja("Säätiö", t1);
        
        equalsTest.tunnistaaErit(k1, t1);
    }
    
    
}
