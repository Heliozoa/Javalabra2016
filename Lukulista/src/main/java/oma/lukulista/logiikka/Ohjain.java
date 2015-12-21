/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import oma.lukulista.listat.Kokoelma;
import oma.lukulista.listat.Lista;
import oma.lukulista.tekija.Kirjailija;
import oma.lukulista.tekija.Tekija;
import oma.lukulista.teos.Kirja;
import oma.lukulista.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class Ohjain {

    private Kokoelma<Teos> teosKokoelma;
    private Kokoelma<Tekija> tekijaKokoelma;

    public Ohjain(Kokoelma<Teos> teosKokoelma, Kokoelma<Tekija> tekijaKokoelma) {
        this.teosKokoelma = teosKokoelma;
        this.tekijaKokoelma = tekijaKokoelma;
    }

    public void lisaaUusiKirjaKokoelmalle(String teoksenNimi, String tekijanNimi) {
        Teos teos = teosKokoelma.haeNimella(teoksenNimi);
        Tekija tekija = tekijaKokoelma.haeNimella(tekijanNimi);

        if (tekija == null) {
            tekija = luoUusiKirjailija(tekijanNimi);
        }

        if (teos == null) {
            teos = luoUusiKirja(teoksenNimi, tekija);
            tekija.lisaaTeos(teos);
        }
    }
    
    public Kokoelma<Teos> getTeosKokoelma(){
        return teosKokoelma;
    }
    
    public Kokoelma<Tekija> getTekijaKokoelma(){
        return tekijaKokoelma;
    }

    private Kirja luoUusiKirja(String nimi, Tekija tekija) {
        Kirja uusi = new Kirja(nimi, tekija);
        teosKokoelma.lisaa(uusi);
        return uusi;
    }

    private Kirjailija luoUusiKirjailija(String nimi) {
        Kirjailija uusi = new Kirjailija(nimi, new Lista());
        tekijaKokoelma.lisaa(uusi);
        return uusi;
    }

//    public void tulostaTeos(String teoksenNimi) {
//        Teos teos = teosKokoelma.haeNimella(teoksenNimi);
//
//        if (teos == null) {
//            System.out.println("Ei löytynyt!");
//        } else {
//            System.out.println(teos);
//        }
//    }
//
//    public void tulostaTekija(String tekijanNimi) {
//        Tekija tekija = tekijaKokoelma.haeNimella(tekijanNimi);
//
//        if (tekija == null) {
//            System.out.println("Ei löytynyt!");
//        } else {
//            System.out.println(tekija);
//        }
//    }
}
