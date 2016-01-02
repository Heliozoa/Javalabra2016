package oma.lukulista.domain.tekija;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.domain.teos.Teos;
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
public class KirjailijaTest {

    private EqualsTest equalsTest;

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
        equalsTest = new EqualsTest();
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
    public void equalsTunnistaaSamannimisetSamaksi() {
        Kirjailija isaac = new Kirjailija("Asimov, Isaac");
        Kirjailija asimov = new Kirjailija("Asimov, Isaac");

        equalsTest.tunnistaaSamat(isaac, asimov);
    }

    @Test
    public void equalsTunnistaaErinimisetEriksi() {
        Kirjailija asimov = new Kirjailija("Asimov, Isaac");
        Kirjailija joku = new Kirjailija("Waltari, Mika");

        equalsTest.tunnistaaErit(asimov, joku);
    }

    @Test
    public void equalsNullillaEiTuotaOngelmia() {
        Tekija t1 = new Kirjailija("Asimov, Isaac");

        equalsTest.nullEiTuotaOngelmia(t1);
    }

    @Test
    public void equalsVaarallaLuokallaEiTuotaOngelmia() {
        Tekija t1 = new Kirjailija("Asimov, Isaac");
        Kirja k1 = new Kirja("Säätiö", t1);

        equalsTest.tunnistaaErit(t1, k1);
    }
}
