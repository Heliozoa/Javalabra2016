/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import oma.lukulista.listat.Lista;
import oma.lukulista.listat.TeosLista;
import oma.lukulista.tekija.Kirjailija;
import oma.lukulista.tekija.Tekija;
import oma.lukulista.teos.Kirja;
import oma.lukulista.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class Ohjain {

    private Lista<Teos> teosLista;
    private Lista<Tekija> tekijaLista;

    public Ohjain(Lista<Teos> teosLista, Lista<Tekija> tekijaLista) {
        this.teosLista = teosLista;
        this.tekijaLista = tekijaLista;
    }

    public void lisaaUusiKirjaListalle(String teoksenNimi, String tekijanNimi) {
        Teos teos = teosLista.haeNimella(teoksenNimi);
        Tekija tekija = tekijaLista.haeNimella(tekijanNimi);

        if (tekija == null) {
            tekija = luoUusiKirjailija(tekijanNimi);
        }

        if (teos == null) {
            teos = luoUusiKirja(teoksenNimi, tekija);
            tekija.lisaaTeos(teos);
        }
    }
    
    public Lista<Teos> getTeosLista(){
        return teosLista;
    }
    
    public Lista<Tekija> getTekijaLista(){
        return tekijaLista;
    }

    private Kirja luoUusiKirja(String nimi, Tekija tekija) {
        Kirja uusi = new Kirja(nimi, tekija);
        teosLista.lisaa(uusi);
        return uusi;
    }

    private Kirjailija luoUusiKirjailija(String nimi) {
        Kirjailija uusi = new Kirjailija(nimi, new TeosLista());
        tekijaLista.lisaa(uusi);
        return uusi;
    }

//    public void tulostaTeos(String teoksenNimi) {
//        Teos teos = teosLista.haeNimella(teoksenNimi);
//
//        if (teos == null) {
//            System.out.println("Ei löytynyt!");
//        } else {
//            System.out.println(teos);
//        }
//    }
//
//    public void tulostaTekija(String tekijanNimi) {
//        Tekija tekija = tekijaLista.haeNimella(tekijanNimi);
//
//        if (tekija == null) {
//            System.out.println("Ei löytynyt!");
//        } else {
//            System.out.println(tekija);
//        }
//    }
}
