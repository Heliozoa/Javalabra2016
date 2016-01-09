/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain;

/**
 * Teoksen lukutilanne.
 */
public enum Kategoria {
    TYHJA("Ei kategoriaa"), BACKLOG("Backlog"), JATETTY_KESKEN("Jätetty kesken"), KESKEN("Kesken"), LUETTU("Luettu");

    private String kuvaus;

    Kategoria(String kuvaus) {
        this.kuvaus = kuvaus;
    }

    @Override
    public String toString() {
        return kuvaus;
    }
}
