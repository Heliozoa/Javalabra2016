/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import java.util.List;
import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.logiikka.hakukone.Hakukone;

/**
 * Perustoteutus Ohjain-rajapinnasta.
 */
public class DefaultOhjain implements Ohjain {

    private List<Teos> teosLista;
    private List<Tekija> tekijaLista;
    private Hakukone hakukone;

    /**
     *
     * @param teosLista Ohjaimelle syötetään lista-olio, jolle kaikki teokset
     * lisätään
     * @param tekijaLista Ohjaimelle syötetään lista-olio, jolle kaikki tekijät
     * lisätään
     */
    public DefaultOhjain(List<Teos> teosLista, List<Tekija> tekijaLista) {
        this.teosLista = teosLista;
        this.tekijaLista = tekijaLista;
        this.hakukone = new Hakukone();
    }

    @Override
    public void lisaaUusiKirjaListalle(String kirjanNimi, String tekijanNimi) {
        Teos teos = hakukone.haeTeosNimella(teosLista, kirjanNimi);
        Tekija tekija = haeKirjailijaTaiLuoUusi(tekijanNimi);

        if (teos == null || !teos.getTekija().equals(tekija)) {
            luoUusiKirja(kirjanNimi, tekija);
        }
    }

    @Override
    public Tekija haeKirjailijaTaiLuoUusi(String kirjailijanNimi) {
        Tekija t = hakukone.haeTekijaNimella(tekijaLista, kirjailijanNimi);
        if (t == null) {
            t = luoUusiKirjailija(kirjailijanNimi);
        }

        return t;
    }

    @Override
    public List<Teos> getTeosLista() {
        return teosLista;
    }

    @Override
    public List<Tekija> getTekijaLista() {
        return tekijaLista;
    }

    private void luoUusiKirja(String nimi, Tekija tekija) {
        Kirja uusi = new Kirja(nimi, tekija);
        tekija.lisaaTeos(uusi);
        teosLista.add(uusi);
    }

    private Kirjailija luoUusiKirjailija(String nimi) {
        Kirjailija uusi = new Kirjailija(nimi);
        tekijaLista.add(uusi);
        return uusi;
    }
}
