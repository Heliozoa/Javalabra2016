/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.domain.teos.Teos;
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
public class ListaTest {

    private Lista<Teos> lista;

    public ListaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lista = new Lista<>();
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
    public void lisaysTest() {
        Kirja k = new Kirja("Säätiö", new Kirjailija("Asimov", new Lista<Teos>()));
        lista.lisaa(k);
        boolean loytyiko = lista.getKokoelma().contains(k);

        assertTrue(loytyiko);
    }

    @Test
    public void poistoTest() {
        Kirja k = new Kirja("Säätiö", new Kirjailija("Asimov", new Lista<Teos>()));
        lista.lisaa(k);
        lista.poista(k);
        boolean loytyiko = lista.getKokoelma().contains(k);
        assertFalse(loytyiko);
    }

    @Test
    public void nimiHakuTest() {
        Kirja k = new Kirja("Säätiö", new Kirjailija("Asimov", new Lista<Teos>()));
        lista.lisaa(k);
        
        Teos hakutulos = lista.haeNimella("Säätiö");
        
        assertEquals(k, hakutulos);
    }
}
