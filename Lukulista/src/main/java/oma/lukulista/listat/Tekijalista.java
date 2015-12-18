/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.tekija.Tekija;

/**
 *
 * @author sasami-san
 */
public class Tekijalista {

    private List<Tekija> tekijat;

    public Tekijalista() {
        tekijat = new ArrayList<>();
    }

    public void lisaaTekija(Tekija tekija) {
        Tekija hakutulos = haeTekija(tekija.getNimi());

        if (hakutulos == null) {
            tekijat.add(tekija);
        }
    }

    public Tekija haeTekija(String nimi) {
        for (Tekija t : tekijat) {
            if (t.getNimi().equals(nimi)) {
                return t;
            }
        }

        return null;
    }

    public int getKoko() {
        return tekijat.size();
    }

    @Override
    public String toString() {
        String tuloste = "Listalla olevat tekijät:\n";

        for (Tekija t : tekijat) {
            tuloste += "  " + t.toString() + "\n";
        }
        
        return tuloste;
    }

}
