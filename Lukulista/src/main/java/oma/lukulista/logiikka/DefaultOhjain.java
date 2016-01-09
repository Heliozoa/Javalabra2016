/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import java.util.List;
import oma.lukulista.domain.Arvosana;
import oma.lukulista.domain.Kategoria;
import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.logiikka.hakukone.Hakukone;
import oma.lukulista.logiikka.muistio.Muistio;

/**
 * Perustoteutus Ohjain-rajapinnasta.
 */
public class DefaultOhjain implements Ohjain {

    private List<Teos> teosLista;
    private List<Tekija> tekijaLista;
    private Hakukone hakukone;
    private Muistio muistio;

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
        this.muistio = new Muistio();
    }

    @Override
    public void lisaaUusiKirjaListalle(String kirjanNimi, String tekijanNimi) {
        lisaaUusiKirjaListalle(kirjanNimi, tekijanNimi, Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
    }

    /**
     * !!WIP!! Ei toimi oikein erityistilanteessa jossa on useampi samanniminen
     * kirja. Metodi tarkistaa vain ensimmäisen löydetyn kirjan ja vertaa
     * lisättävää siihen.
     */
    @Override
    public void lisaaUusiKirjaListalle(String kirjanNimi, String tekijanNimi, Kategoria kategoria, Arvosana arvosana) {
        Teos teos = hakukone.haeTeosNimella(teosLista, kirjanNimi);
        Tekija tekija = haeKirjailijaTaiLuoUusi(tekijanNimi);

        if (teos == null || !teos.getTekija().equals(tekija)) {
            luoUusiKirja(kirjanNimi, tekija, kategoria, arvosana);
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

    private void luoUusiKirja(String nimi, Tekija tekija, Kategoria kategoria, Arvosana arvosana) {
        Kirja uusi = new Kirja(nimi, tekija);
        uusi.setKategoria(kategoria);
        uusi.setArvosana(arvosana);

        tekija.lisaaTeos(uusi);
        teosLista.add(uusi);
        tallenna();
    }

    private Kirjailija luoUusiKirjailija(String nimi) {
        Kirjailija uusi = new Kirjailija(nimi);
        tekijaLista.add(uusi);
        return uusi;
    }

    @Override
    public void poistaTeosListalta(Teos poistettava) {
        teosLista.remove(poistettava);

        Tekija t = poistettava.getTekija();

        if (t.getTeokset().isEmpty()) {
            tekijaLista.remove(t);
        }

        tallenna();
    }

    @Override
    public void tallenna() {
        muistio.tallenna(teosLista);
    }

    @Override
    public void lataa() {
        List<Teos> lista = muistio.lataa();

        if (lista != null) {
            teosLista = lista;
        }

        for (Teos t : teosLista) {
            if (!tekijaLista.contains(t.getTekija())) {
                tekijaLista.add(t.getTekija());
            }
        }
    }
}
