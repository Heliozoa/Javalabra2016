package oma.lukulista.teoslista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import oma.lukulista.listat.Teoslista;
import oma.lukulista.teos.Kirja;
import oma.lukulista.teos.Teos;
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
public class TeoslistaTest {

    Teoslista teoslista;

    public TeoslistaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        teoslista = new Teoslista();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void lisaysEiTuotaVirheita() {
        Teos uusi = new Kirja("Testinimi", "Testikirjailija");
        teoslista.lisaaTeos(uusi);
    }

    @Test
    public void kahtaSamanNimistaEiLisata() {
        Teos uusi = new Kirja("Testinimi", "Testikirjailija");
        Teos sama = new Kirja("Testinimi", "Testikirjailija");
        
        teoslista.lisaaTeos(uusi);
        teoslista.lisaaTeos(sama);
        
        assertEquals(1, teoslista.getKoko());
    }

    @Test
    public void lisaysJaHakuToimii() {
        Teos uusi = new Kirja("Testikirja", "Testikirjailija");
        teoslista.lisaaTeos(uusi);

        Teos etsinnanTulos = teoslista.haeTeos("Testikirja");

        assertEquals(uusi, etsinnanTulos);
    }
}
