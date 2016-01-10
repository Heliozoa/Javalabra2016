/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.main;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.kayttoliittyma.Graafinenkayttoliittyma;
import oma.lukulista.kayttoliittyma.Kayttoliittyma;
import oma.lukulista.logiikka.DefaultOhjain;
import oma.lukulista.logiikka.Ohjain;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class Main {

    /**
     * main!
     *
     * @param args ???
     */
    public static void main(String[] args) {
        graafinenkayttoliittyma();
    }

    /**
     * Luo ja avaa graafisen käyttöliittymän uusilla teos- ja tekijälistoilla.
     */
    public static void graafinenkayttoliittyma() {
        List<Teos> teosLista = new ArrayList<>();
        List<Tekija> tekijaLista = new ArrayList<>();

        Ohjain ohjain = new DefaultOhjain(teosLista, tekijaLista);

        Kayttoliittyma kl = new Graafinenkayttoliittyma(ohjain);

        kl.run();
    }
}
