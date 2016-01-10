/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.teos;

import oma.lukulista.domain.enumit.Arvosana;
import java.util.Objects;
import oma.lukulista.domain.enumit.Kategoria;
import oma.lukulista.domain.tekija.Tekija;

public class Kirja implements Teos {

    String nimi;
    Tekija tekija;
    Kategoria kategoria;
    Arvosana arvosana;

    public Kirja(String nimi, Tekija tekija) {
        this(nimi, tekija, Kategoria.TYHJA, Arvosana.EI_ARVOSTELTU);
    }

    public Kirja(String nimi, Tekija tekija, Kategoria kategoria, Arvosana arvosana) {
        this.nimi = nimi;
        this.tekija = tekija;
        this.kategoria = kategoria;
        this.arvosana = arvosana;
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
    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public Kategoria getKategoria() {
        return kategoria;
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
