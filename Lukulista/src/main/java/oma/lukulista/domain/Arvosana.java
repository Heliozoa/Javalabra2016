/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain;

/**
 * Arvosana asteikolla 1-5, missä 0 merkitsee vielä arvostelematonta.
 */
public enum Arvosana {
    EI_ARVOSTELTU(0, "Ei arvosteltu"), HUONO(1, "Huono"), OK(2, "Ok"), HYVA(3, "Hyvä"), ERITTAIN_HYVA(4, "Erittäin hyvä"), ERINOMAINEN(5, "Erinomainen");

    private int arvosana;
    private String kuvaus;

    Arvosana(int arvosana, String kuvaus) {
        this.arvosana = arvosana;
        this.kuvaus = kuvaus;
    }

    public int getArvosana() {
        return arvosana;
    }

    @Override
    public String toString() {
        return arvosana + " (" + kuvaus + ")";
    }
}
