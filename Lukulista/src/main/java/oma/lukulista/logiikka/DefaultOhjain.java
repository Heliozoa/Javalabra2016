/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import oma.lukulista.domain.enumit.*;
import oma.lukulista.domain.tekija.Kirjailija;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Kirja;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.logiikka.listakasittely.Filtteroija;
import oma.lukulista.logiikka.listakasittely.Hakukone;
import oma.lukulista.logiikka.muistio.Muistio;
import oma.lukulista.logiikka.teosvertailijat.*;

/**
 * Perustoteutus Ohjain-rajapinnasta.
 */
public class DefaultOhjain implements Ohjain {

    private List<Teos> teosLista;
    private List<Teos> filtteroityTeosLista;
    private List<Tekija> tekijaLista;
    private Hakukone hakukone;
    private Muistio muistio;
    private Filtteroija filtteroija;

    private Jarjestys jarjestys;
    private String filtteri;

    /**
     *
     * @param teosLista Ohjaimelle syötetään lista-olio, jolle kaikki teokset
     * lisätään
     * @param tekijaLista Ohjaimelle syötetään lista-olio, jolle kaikki tekijät
     * lisätään
     */
    public DefaultOhjain(List<Teos> teosLista, List<Tekija> tekijaLista) {
        this.teosLista = teosLista;
        this.filtteroityTeosLista = new ArrayList<>();
        this.tekijaLista = tekijaLista;
        this.hakukone = new Hakukone();
        this.muistio = new Muistio();
        this.filtteroija = new Filtteroija();

        filtteri = "";
        jarjestys = Jarjestys.NIMI;
    }

    public DefaultOhjain() {
        this(new ArrayList<Teos>(), new ArrayList<Tekija>());
    }

    @Override
    public void lisaaUusiKirjaListalle(String kirjanNimi, String tekijanNimi, Kategoria kategoria, Arvosana arvosana) {
        Tekija tekija = haeKirjailijaTaiLuoUusi(tekijanNimi);
        if (!teosOnJoOlemassa(kirjanNimi, tekija)) {
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
    public void poistaTeosListalta(Teos poistettava) {
        if (poistettava == null) {
            return;
        }

        Tekija t = poistettava.getTekija();

        teosLista.remove(poistettava);

        t.poistaTeos(poistettava);

        if (t.getTeokset().isEmpty()) {
            tekijaLista.remove(t);
        }

        tallennaTiedostoon();
    }

    @Override
    public void tallennaTiedostoon() {
        muistio.tallennaTiedostoon(teosLista);
    }

    @Override
    public void lataaTiedostosta() {
        List<Teos> lista = muistio.lataaTiedostosta();

        if (lista == null) {
            return;
        }

        teosLista = lista;

        for (Teos t : teosLista) {
            if (!tekijaLista.contains(t.getTekija())) {
                tekijaLista.add(t.getTekija());
            }
        }
    }

    @Override
    public void setJarjestys(Jarjestys jarjestys) {
        this.jarjestys = jarjestys;
    }

    @Override
    public List<Teos> getTeosLista() {
        return teosLista;
    }

    @Override
    public List<Tekija> getTekijaLista() {
        return tekijaLista;
    }

    @Override
    public void setFiltteri(String filtteri) {
        this.filtteri = filtteri;
    }

    @Override
    public List<Teos> getFiltteroityJaJarjestettyLista() {
        jarjestaLista();
        filtteroija.filtteroiLista(filtteroityTeosLista, teosLista, filtteri);
        return filtteroityTeosLista;
    }

    private void luoUusiKirja(String nimi, Tekija tekija, Kategoria kategoria, Arvosana arvosana) {
        Kirja uusi = new Kirja(nimi, tekija, kategoria, arvosana);

        tekija.lisaaTeos(uusi);
        teosLista.add(uusi);
        tallennaTiedostoon();
    }

    private Kirjailija luoUusiKirjailija(String nimi) {
        Kirjailija uusi = new Kirjailija(nimi);
        tekijaLista.add(uusi);
        return uusi;
    }

    private boolean teosOnJoOlemassa(String kirjanNimi, Tekija tekija) {
        List<Teos> samannimisetTeokset = hakukone.haeTeoksetNimella(teosLista, kirjanNimi);

        for (Teos teos : samannimisetTeokset) {
            if (teos.getTekija().equals(tekija)) {
                return true;
            }
        }
        return false;
    }

    private void jarjestaLista() {
        switch (jarjestys) {
            case NIMI:
                Collections.sort(teosLista, new TeosNimiComparator());
                break;

            case TEKIJAN_NIMI:
                Collections.sort(teosLista, new TeosTekijanNimiComparator());
                break;

            case ARVOSANA:
                Collections.sort(teosLista, new TeosArvosanaComparator());
                break;

            case KATEGORIA:
                Collections.sort(teosLista, new TeosKategoriaComparator());
                break;
        }
    }
}
