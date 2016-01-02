/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka.hakukone;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.domain.Nimellinen;
import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.tekija.Tekija;
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
public class HakukoneTest {

    private Hakukone hakukone;

    public HakukoneTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        hakukone = new Hakukone();
    }

    @After
    public void tearDown() {
    }

    @Test

    public void haeTekijaNimellaToimii() {
        List<Tekija> list = new ArrayList<>();
        Tekija asimov = new Kirjailija("Asimov, Isaac");
        Tekija muumi = new Kirjailija("Muumipappa");
        list.add(asimov);
        list.add(muumi);
        assertEquals(asimov, hakukone.haeTekijaNimella(list, "asimov, isaac"));
    }

    @Test
    public void haeTeosNimellaToimii() {
        List<Teos> list = new ArrayList<>();
        Tekija asimov = new Kirjailija("Asimov, Isaac");
        Tekija muumi = new Kirjailija("Muumipappa");

        Teos saatio = new Kirja("Säätiö", asimov);
        Teos urotyot = new Kirja("Muumipapan urotyöt", muumi);

        list.add(saatio);
        list.add(urotyot);

        assertEquals(urotyot, hakukone.haeTeosNimella(list, "muumipapan urotyöt"));
    }
}
