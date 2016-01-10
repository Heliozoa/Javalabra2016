/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.enumit;

/**
 * Teoksen lukutilanne. Tunnusluku on järjestämistä varten, joka tapahtuu
 * suurimmasta pienimpään.
 */
public enum Kategoria implements Comparable<Kategoria> {
    TYHJA(0, "Ei kategoriaa"), BACKLOG(3, "Backlog"), JATETTY_KESKEN(1, "Jätetty kesken"), KESKEN(4, "Kesken"), LUETTU(2, "Luettu");

    private int tunnus;
    private String kuvaus;

    Kategoria(int tunnus, String kuvaus) {
        this.tunnus = tunnus;
        this.kuvaus = kuvaus;
    }

    public int getTunnus() {
        return tunnus;
    }

    @Override
    public String toString() {
        return kuvaus;
    }
}
