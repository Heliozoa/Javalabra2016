/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import oma.lukulista.listat.Kokoelma;
import oma.lukulista.listat.Lista;
import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.domain.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class DefaultOhjain implements Ohjain {

    private Kokoelma<Teos> teosKokoelma;
    private Kokoelma<Tekija> tekijaKokoelma;

    public DefaultOhjain(Kokoelma<Teos> teosKokoelma, Kokoelma<Tekija> tekijaKokoelma) {
        this.teosKokoelma = teosKokoelma;
        this.tekijaKokoelma = tekijaKokoelma;
    }

    @Override
    public void lisaaUusiKirjaKokoelmalle(String teoksenNimi, String tekijanNimi) {
        Teos teos = teosKokoelma.haeNimella(teoksenNimi);
        Tekija tekija = tekijaKokoelma.haeNimella(tekijanNimi);

        if (tekija == null) {
            tekija = luoUusiKirjailija(tekijanNimi);
        }

        if (teos == null || !teos.getTekija().equals(tekija)) {
            teos = luoUusiKirja(teoksenNimi, tekija);
            tekija.lisaaTeos(teos);
        }
    }

    @Override
    public Kokoelma<Teos> getTeosKokoelma() {
        return teosKokoelma;
    }

    @Override
    public Kokoelma<Tekija> getTekijaKokoelma() {
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
}
