package oma.lukulista.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import oma.lukulista.listat.Lista;
import oma.lukulista.tekija.Kirjailija;
import oma.lukulista.tekija.Tekija;
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
public class DefaultOhjainTest {

    private Lista<Teos> teosLista;
    private Lista<Tekija> tekijaLista;
    private DefaultOhjain ohjain;

    public DefaultOhjainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        teosLista = new Lista<>();
        tekijaLista = new Lista<>();
        ohjain = new DefaultOhjain(teosLista, tekijaLista);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kirjanLisaysToimii() {
        Kirja saatio = new Kirja("Säätiö", new Kirjailija("Asimov, Isaac", new Lista<>()));
        ohjain.lisaaUusiKirjaKokoelmalle("Säätiö", "Asimov, Isaac");

        boolean loytyiko = ohjain.getTeosKokoelma().getKokoelma().contains(saatio);

        assertTrue(loytyiko);
    }

    @Test
    public void useanKirjanLisaysToimii() {
        ohjain.lisaaUusiKirjaKokoelmalle("Säätiö", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaKokoelmalle("I, Robot", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaKokoelmalle("Sinuhe", "Waltari, Mika");

        int koko = ohjain.getTeosKokoelma().getKoko();

        assertEquals(3, koko);
    }

    @Test
    public void kirjailijanLisaysToimii() {
        Kirjailija asimov = new Kirjailija("Asimov, Isaac", new Lista<>());
        Kirja saatio = new Kirja("Säätiö", asimov);
        ohjain.lisaaUusiKirjaKokoelmalle("Säätiö", "Asimov, Isaac");

        boolean loytyiko = ohjain.getTekijaKokoelma().getKokoelma().contains(asimov);

        assertTrue(loytyiko);
    }
    
    @Test
    public void useanKirjailijanLisaysToimii(){
        ohjain.lisaaUusiKirjaKokoelmalle("I, Robot", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaKokoelmalle("Sinuhe", "Waltari, Mika");

        int koko = ohjain.getTekijaKokoelma().getKoko();

        assertEquals(2, koko);
        
    }

    @Test
    public void kahtaSamaaKirjaaEiLisata() {
        ohjain.lisaaUusiKirjaKokoelmalle("Säätiö", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaKokoelmalle("Säätiö", "Asimov, Isaac");

        int koko = ohjain.getTeosKokoelma().getKoko();

        assertEquals(1, koko);
    }

    @Test
    public void kahtaSamaaKirjailijaaEiLisata() {
        ohjain.lisaaUusiKirjaKokoelmalle("Säätiö", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaKokoelmalle("I, Robot", "Asimov, Isaac");

        int koko = ohjain.getTekijaKokoelma().getKoko();

        assertEquals(1, koko);
    }
    
    @Test
    public void kirjaLisataanMyosTekijalle(){
        ohjain.lisaaUusiKirjaKokoelmalle("Säätiö", "Asimov, Isaac");
        Tekija asimov = ohjain.getTekijaKokoelma().haeNimella("Asimov, Isaac");
        boolean loytyiko = asimov.getTeokset().getKokoelma().contains(new Kirja("Säätiö", asimov));
        
        assertTrue(loytyiko);
    }

}
