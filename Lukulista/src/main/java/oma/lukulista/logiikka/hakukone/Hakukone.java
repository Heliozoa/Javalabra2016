/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka.hakukone;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.domain.Nimellinen;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Teos;

/**
 * Hakukoneen tarkoitus on hakea teos- ja tekijälistoilta haluttuja olioita.
 */
public class Hakukone {

    /**
     * Hakee listalta tekijän, jonka nimi on sama kuin hakusana. Isoilla ja
     * pienillä kirjaimilla ei ole merkitystä.
     *
     * @param lista Lista, jolta tekijöitä etsitään.
     * @param hakusana Hakusana, johon listalla olevien tekijöiden nimeä
     * verrataan.
     * @return Haluttu tekijä jos sellainen löytyy, tai null jos sellaista ei
     * löydy.
     */
    public Tekija haeTekijaNimella(List<Tekija> lista, String hakusana) {
        return (Tekija) haeNimella(lista, hakusana);
    }

    /**
     * Hakee listalta teokset, joiden nimi on sama kuin hakusana. Isoilla ja
     * pienillä kirjaimilla ei ole merkitystä.
     *
     * @param lista Lista, jolta teoksia etsitään.
     * @param hakusana Hakusana, johon listalla olevien teosten nimeä verrataan.
     * @return Löydetyt teokset, tai null jos sellaisia ei löydy.
     */
    public List<Teos> haeTeoksetNimella(List<Teos> lista, String hakusana) {
        List<Teos> teokset = new ArrayList<>();

        List<Nimellinen> tulokset = haeMontaNimella(lista, hakusana);

        for (Nimellinen n : tulokset) {
            teokset.add((Teos) n);
        }

        return teokset;
    }

    private Nimellinen haeNimella(List<? extends Nimellinen> lista, String hakusana) {

        List<Nimellinen> tulokset = haeMontaNimella(lista, hakusana);

        if (tulokset.isEmpty()) {
            return null;
        } else {
            return tulokset.get(0);
        }

    }

    private List<Nimellinen> haeMontaNimella(List<? extends Nimellinen> lista, String hakusana) {
        List<Nimellinen> tulokset = new ArrayList<>();

        for (Nimellinen n : lista) {
            if (n.getNimi().equalsIgnoreCase(hakusana)) {
                tulokset.add(n);
            }
        }

        return tulokset;
    }
}
