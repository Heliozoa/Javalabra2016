/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain;

/**
 * Kategoria liittyy teokseen ja merkitsee mihin ryhmään teos kuuluu. Voi olla
 * esim. genre kuten fantasia. Yksi kategoria voi liittyä moneen teokseen.
 */
public class Kategoria implements Nimellinen {

    private String nimi;

    public Kategoria(String nimi) {
        this.nimi = nimi;
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
        final Kategoria other = (Kategoria) obj;
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
