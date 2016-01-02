/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka.hakukone;

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
     * Hakee listalta teoksen, jonka nimi on sama kuin hakusana. Isoilla ja
     * pienillä kirjaimilla ei ole merkitystä.
     *
     * @param lista Lista, jolta teoksia etsitään.
     * @param hakusana Hakusana, johon listalla olevien teosten nimeä verrataan.
     * @return Haluttu teos jos sellainen löytyy, tai null jos sellaista ei
     * löydy.
     */
    public Teos haeTeosNimella(List<Teos> lista, String hakusana) {
        return (Teos) haeNimella(lista, hakusana);
    }

    private Nimellinen haeNimella(List<? extends Nimellinen> lista, String hakusana) {

        for (Nimellinen n : lista) {
            if (n.getNimi().equalsIgnoreCase(hakusana)) {
                return n;
            }
        }

        return null;

    }
}
