/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.teos;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.domain.Arvosana;
import java.util.Objects;
import oma.lukulista.domain.tekija.Tekija;

public class Kirja implements Teos {

    String nimi;
    Tekija tekija;
    String kategoria;
    List<String> tagit;
    Arvosana arvosana;

    public Kirja(String nimi, Tekija tekija) {
        this.nimi = nimi;
        this.tekija = tekija;
        kategoria = "";
        tagit = new ArrayList<>();
        arvosana = Arvosana.EI_ARVOSTELTU;
    }

    @Override
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public void setTekija(Tekija tekija) {
        this.tekija = tekija;
    }

    @Override
    public Tekija getTekija() {
        return tekija;
    }

    @Override
    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String getKategoria() {
        return kategoria;
    }

    @Override
    public void lisaaTagi(String tagi) {
        tagit.add(tagi);
    }

    @Override
    public void poistaTagi(String tagi) {
        tagit.remove(tagi);
    }

    @Override
    public List<String> getTagit() {
        return tagit;
    }

    @Override
    public void setArvosana(Arvosana arvosana) {
        this.arvosana = arvosana;
    }

    @Override
    public Arvosana getArvosana() {
        return arvosana;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nimi);
        hash = 29 * hash + Objects.hashCode(this.tekija);
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
        final Kirja other = (Kirja) obj;
        if (!this.nimi.equalsIgnoreCase(other.nimi)) {
            return false;
        }
        if (!Objects.equals(this.tekija, other.tekija)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nimi + " (" + tekija + ")";
    }
}
