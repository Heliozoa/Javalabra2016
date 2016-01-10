/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.enumit;

/**
 * Sisältää erilaiset järjestykset, joiden mukaan teoksia voi järjestää.
 */
public enum Jarjestys {
    NIMI("Nimi"), TEKIJAN_NIMI("Tekijän nimi"), ARVOSANA("Arvosana"), KATEGORIA("Kategoria");

    private String nimi;

    Jarjestys(String nimi) {
        this.nimi = nimi;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
