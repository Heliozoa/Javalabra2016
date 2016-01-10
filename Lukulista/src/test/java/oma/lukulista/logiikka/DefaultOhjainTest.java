package oma.lukulista.logiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import oma.lukulista.domain.enumit.Arvosana;
import oma.lukulista.domain.enumit.Jarjestys;
import oma.lukulista.domain.enumit.Kategoria;
import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.logiikka.listakasittely.Hakukone;
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

    private List<Teos> teosLista;
    private List<Tekija> tekijaLista;
    private DefaultOhjain ohjain;
    private Hakukone hakukone;

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
        teosLista = new ArrayList<>();
        tekijaLista = new ArrayList<>();
        ohjain = new DefaultOhjain(teosLista, tekijaLista);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kirjanLisaysToimii() {
        Kirja saatio = new Kirja("Säätiö", new Kirjailija("Asimov, Isaac"));
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);

        boolean loytyiko = ohjain.getTeosLista().contains(saatio);

        assertTrue(loytyiko);
    }

    @Test
    public void useanKirjanLisaysToimii() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
        ohjain.lisaaUusiKirjaListalle("I, Robot", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
        ohjain.lisaaUusiKirjaListalle("Sinuhe", "Waltari, Mika", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);

        int koko = ohjain.getTeosLista().size();

        assertEquals(3, koko);
    }

    @Test
    public void kirjailijanLisaysToimii() {
        Kirjailija asimov = new Kirjailija("Asimov, Isaac");
        Kirja saatio = new Kirja("Säätiö", asimov);
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);

        boolean loytyiko = ohjain.getTekijaLista().contains(asimov);

        assertTrue(loytyiko);
    }

    @Test
    public void useanKirjailijanLisaysToimii() {
        ohjain.lisaaUusiKirjaListalle("I, Robot", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
        ohjain.lisaaUusiKirjaListalle("Sinuhe", "Waltari, Mika", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);

        int koko = ohjain.getTekijaLista().size();

        assertEquals(2, koko);

    }

    @Test
    public void kahtaSamaaKirjaaEiLisata() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);

        int koko = ohjain.getTeosLista().size();

        assertEquals(1, koko);
    }

    @Test
    public void kahtaSamaaKirjailijaaEiLisata() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
        ohjain.lisaaUusiKirjaListalle("I, Robot", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);

        int koko = ohjain.getTekijaLista().size();

        assertEquals(1, koko);
    }

    @Test
    public void kirjaLisataanMyosTekijalle() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
        Tekija asimov = ohjain.haeKirjailijaTaiLuoUusi("Asimov, Isaac");
        boolean loytyiko = asimov.getTeokset().contains(new Kirja("Säätiö", asimov));

        assertTrue(loytyiko);
    }

    @Test
    public void haeKirjailijaTaiLuoUusiLuoUuden() {
        ohjain.haeKirjailijaTaiLuoUusi("Muumipappa");
        assertTrue(ohjain.getTekijaLista().contains(new Kirjailija("Muumipappa")));
    }

    @Test
    public void haeKirjailijaTaiLuoUusiHakeeKirjailijan() {
        Tekija uusi = ohjain.haeKirjailijaTaiLuoUusi("Muumipappa");
        assertSame(uusi, ohjain.haeKirjailijaTaiLuoUusi("Muumipappa"));
    }

    @Test
    public void teoksenPoistoOnnistuu() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
        ohjain.poistaTeosListalta(new Kirja("Säätiö", ohjain.haeKirjailijaTaiLuoUusi("Asimov, Isaac")));

        assertTrue(ohjain.getTeosLista().isEmpty());
    }

    @Test
    public void olemattomanTeoksenPoistoEiAieheutaOngelmia() {
        ohjain.poistaTeosListalta(new Kirja("Säätiö", new Kirjailija("Asimov, Isaac")));
    }

    @Test
    public void tekijaJolleEiJaaYhtaanTeostaPoistonJalkeenPoistetaanMyos() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.HUONO);
        ohjain.poistaTeosListalta(new Kirja("Säätiö", ohjain.haeKirjailijaTaiLuoUusi("Asimov, Isaac")));

        assertTrue(ohjain.getTekijaLista().isEmpty());
    }

    @Test
    public void tekijaJolleJaaTeoksiaPoistonJalkeenEiPoisteta() {
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.HUONO);
        ohjain.lisaaUusiKirjaListalle("I, Robot", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.HUONO);
        ohjain.poistaTeosListalta(new Kirja("Säätiö", ohjain.haeKirjailijaTaiLuoUusi("Asimov, Isaac")));

        assertTrue(ohjain.getTekijaLista().size() == 1);
    }

    @Test
    public void filtteroityListaLuodaanOikein() {
        ohjain.lisaaUusiKirjaListalle("Muumipappa ja meri", "Jansson, Tove", Kategoria.TYHJA, Arvosana.HUONO);
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Muumipappa", Kategoria.TYHJA, Arvosana.HUONO);
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.HUONO);

        ohjain.setFiltteri("muumi");

        List<Teos> filtteroity = ohjain.getFiltteroityJaJarjestettyLista();

        assertEquals("Muumipappa ja meri", filtteroity.get(0).getNimi());
        assertEquals("Muumipappa", filtteroity.get(1).getTekija().getNimi());
        assertEquals(2, filtteroity.size());
    }

    @Test
    public void jarjestettyListaLuodaanOikeinAinakinArvosanalla() {
        ohjain.lisaaUusiKirjaListalle("Muumipappa ja meri", "Jansson, Tove", Kategoria.TYHJA, Arvosana.OK);
        ohjain.lisaaUusiKirjaListalle("Muistelmat", "Muumipappa", Kategoria.TYHJA, Arvosana.ERINOMAINEN);
        ohjain.lisaaUusiKirjaListalle("Säätiö", "Asimov, Isaac", Kategoria.TYHJA, Arvosana.HUONO);

        ohjain.setJarjestys(Jarjestys.ARVOSANA);

        List<Teos> jarjestetty = ohjain.getFiltteroityJaJarjestettyLista();

        assertEquals("Muistelmat", jarjestetty.get(0).getNimi());
        assertEquals("Muumipappa ja meri", jarjestetty.get(1).getNimi());
        assertEquals("Säätiö", jarjestetty.get(2).getNimi());
    }

}
