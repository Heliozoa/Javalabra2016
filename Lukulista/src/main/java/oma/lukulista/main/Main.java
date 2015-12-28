/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.main;

import java.util.Scanner;
import oma.lukulista.kayttoliittyma.Graafinenkayttoliittyma;
import oma.lukulista.kayttoliittyma.Kayttoliittyma;
import oma.lukulista.kayttoliittyma.Tekstikayttoliittyma;
import oma.lukulista.listat.Kokoelma;
import oma.lukulista.listat.Lista;
import oma.lukulista.logiikka.DefaultOhjain;
import oma.lukulista.logiikka.Ohjain;
import oma.lukulista.tekija.Tekija;
import oma.lukulista.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class Main {

    public static void main(String[] args) {
        //tekstikayttoliittyma();
        graafinenkayttoliittyma();
    }

    public static void graafinenkayttoliittyma() {
        Kokoelma<Teos> teosLista = new Lista<>();
        Kokoelma<Tekija> tekijaLista = new Lista<>();

        Ohjain ohjain = new DefaultOhjain(teosLista, tekijaLista);
        
        Kayttoliittyma kl = new Graafinenkayttoliittyma(ohjain);
        
        kl.run();
    }

    public static void tekstikayttoliittyma() {
        Kokoelma<Teos> teosLista = new Lista<>();
        Kokoelma<Tekija> tekijaLista = new Lista<>();

        Ohjain ohjain = new DefaultOhjain(teosLista, tekijaLista);
        Scanner lukija = new Scanner(System.in);

        Kayttoliittyma kl = new Tekstikayttoliittyma(ohjain, lukija);

        kl.run();
    }

}
