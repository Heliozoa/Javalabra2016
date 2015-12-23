/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

import java.util.Collection;

/**
 *
 * @author sasami-san
 * @param <N>
 */
public abstract class Kokoelma<N extends Nimellinen> {

    protected Collection<N> kokoelma;

    public void lisaa(N n) {
        kokoelma.add(n);
    }

    public N haeNimella(String nimi) {
        for (N n : kokoelma) {
            if (n.getNimi().equals(nimi)) {
                return n;
            }
        }

        return null;
    }
    
    public abstract Kokoelma<N> haku(String hakusana);

    public int getKoko() {
        return kokoelma.size();
    }

    public Collection getKokoelma() {
        return kokoelma;
    }
}
