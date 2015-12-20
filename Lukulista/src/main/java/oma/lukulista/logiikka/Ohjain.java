/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import oma.lukulista.listat.Lista;
import oma.lukulista.listat.TekijaLista;
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

    public Ohjain() {
        teosLista = new TeosLista();
        tekijaLista = new TekijaLista();
    }

    public void lisaaUusiKirjaListalle(String teoksenNimi, String tekijanNimi) {
        Teos teos = teosLista.haeNimella(teoksenNimi);
        Tekija tekija = tekijaLista.haeNimella(tekijanNimi);
        
        if(tekija == null){
            tekija = new Kirjailija(tekijanNimi, new TeosLista());
            tekijaLista.lisaa(tekija);
        }
        
        if(teos == null){
            teos = new Kirja(teoksenNimi, tekija);
            teosLista.lisaa(teos);
        }
    }
    
    public void tulostaTeos(String teoksenNimi){
        Teos teos = teosLista.haeNimella(teoksenNimi);
        
        if(teos == null){
            System.out.println("Ei löytynyt!");
        }else{
            System.out.println(teos);
        }
    }
}
