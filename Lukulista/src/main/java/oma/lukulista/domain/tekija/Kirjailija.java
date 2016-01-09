/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.tekija;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.domain.teos.Teos;

public class Kirjailija implements Tekija {

    private String nimi;
    private List<Teos> teokset;

    public Kirjailija(String nimi) {
        this.nimi = nimi;
        this.teokset = new ArrayList<>();
    }

    @Override
    public void lisaaTeos(Teos teos) {
        teokset.add(teos);
    }

    @Override
    public void poistaTeos(Teos teos) {
        teokset.remove(teos);
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
    public List<Teos> getTeokset() {
        return teokset;
    }

    @Override
    public int hashCode() {
        return nimi.hashCode();
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
        if (!this.nimi.equalsIgnoreCase(other.nimi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
