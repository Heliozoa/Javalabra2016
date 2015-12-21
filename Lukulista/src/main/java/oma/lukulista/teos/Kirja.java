/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.teos;

import java.util.Objects;
import oma.lukulista.listat.Kokoelma;
import oma.lukulista.listat.Lista;
import oma.lukulista.tekija.Tekija;

/**
 *
 * @author sasami-san
 */
public class Kirja implements Teos {

    String nimi;
    Tekija tekija;
    Kategoria kategoria;
    Kokoelma<Tagi> tagit;

    public Kirja(String nimi, Tekija tekija) {
        this.nimi = nimi;
        this.tekija = tekija;
        tagit = new Lista<>();
    }

    @Override
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public void setTekija(Tekija tekija) {
        this.tekija = tekija;
    }
    
    public void setKategoria(Kategoria kategoria){
        this.kategoria = kategoria;
    }
    
    public void lisaaTagi(Tagi tagi){
        tagit.lisaa(tagi);
    }

    @Override
    public String getNimi() {
        return nimi;
    }

    @Override
    public Tekija getTekija() {
        return tekija;
    }
    
    public Kategoria getKategoria(){
        return kategoria;
    }
    
    public Kokoelma<Tagi> getTagit(){
        return tagit;
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
        if (!Objects.equals(this.nimi, other.nimi)) {
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
