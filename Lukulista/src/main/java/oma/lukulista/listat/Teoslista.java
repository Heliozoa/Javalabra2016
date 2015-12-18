/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class Teoslista {

    private List<Teos> teokset;

    public Teoslista() {
        teokset = new ArrayList<>();
    }

    public void lisaaTeos(Teos teos) {
        Teos hakutulos = haeTeos(teos.getNimi());

        if (hakutulos == null) {
            teokset.add(teos);
        }
    }

    public Teos haeTeos(String nimi) {
        for (Teos t : teokset) {
            if (t.getNimi().equals(nimi)) {
                return t;
            }
        }

        return null;
    }
    
    public int getKoko(){
        return teokset.size();
    }

    @Override
    public String toString() {
        String tuloste = "Listalla olevat teokset:\n";

        for (Teos t : teokset) {
            tuloste += "  " + t.toString() + "\n";
        }

        return tuloste;
    }

}
