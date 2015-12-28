/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.tekija;

import java.util.Objects;
import oma.lukulista.listat.Lista;
import oma.lukulista.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class Kirjailija implements Tekija {

    private String nimi;
    private Lista teokset;

    public Kirjailija(String nimi, Lista teokset) {
        this.nimi = nimi;
        this.teokset = teokset;
    }

    @Override
    public void lisaaTeos(Teos teos) {
        teokset.lisaa(teos);
    }
    
    @Override
    public void poistaTeos(Teos teos){
        teokset.poista(teos);
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public Lista<Teos> getTeokset() {
        return teokset;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kirjailija other = (Kirjailija) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
