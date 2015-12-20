package oma.lukulista.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import oma.lukulista.listat.Lista;
import oma.lukulista.listat.TekijaLista;
import oma.lukulista.listat.TeosLista;
import oma.lukulista.logiikka.Ohjain;
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
public class OhjainTest {

    private Lista<Teos> teosLista;
    private Lista<Tekija> tekijaLista;
    private Ohjain ohjain;

    public OhjainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        teosLista = new TeosLista();
        tekijaLista = new TekijaLista();
        ohjain = new Ohjain(teosLista, tekijaLista);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kirjanLisaysToimii() {
        Kirja saatio = new Kirja("Säätiö", new Kirjailija("Asimov, Isaac", new TeosLista()));
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac");

        boolean loytyiko = ohjain.getTeosLista().getLista().contains(saatio);

        assertTrue(loytyiko);
    }

    @Test
    public void useanKirjanLisaysToimii() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaListalle("I, Robot", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaListalle("Sinuhe", "Waltari, Mika");

        int koko = ohjain.getTeosLista().getKoko();

        assertEquals(3, koko);
    }

    @Test
    public void kirjailijanLisaysToimii() {
        Kirjailija asimov = new Kirjailija("Asimov, Isaac", new TeosLista());
        Kirja saatio = new Kirja("Säätiö", asimov);
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac");

        boolean loytyiko = ohjain.getTekijaLista().getLista().contains(asimov);

        assertTrue(loytyiko);
    }
    
    @Test
    public void useanKirjailijanLisaysToimii(){
        ohjain.lisaaUusiKirjaListalle("I, Robot", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaListalle("Sinuhe", "Waltari, Mika");

        int koko = ohjain.getTekijaLista().getKoko();

        assertEquals(2, koko);
        
    }

    @Test
    public void kahtaSamaaKirjaaEiLisata() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac");

        int koko = ohjain.getTeosLista().getKoko();

        assertEquals(1, koko);
    }

    @Test
    public void kahtaSamaaKirjailijaaEiLisata() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac");
        ohjain.lisaaUusiKirjaListalle("I, Robot", "Asimov, Isaac");

        int koko = ohjain.getTekijaLista().getKoko();

        assertEquals(1, koko);
    }
    
    @Test
    public void kirjaLisataanMyosTekijalle(){
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac");
        Tekija asimov = ohjain.getTekijaLista().haeNimella("Asimov, Isaac");
        boolean loytyiko = asimov.getTeokset().getLista().contains(new Kirja("Säätiö", asimov));
        
        assertTrue(loytyiko);
    }

}
