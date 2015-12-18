/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.tekija;

/**
 *
 * @author sasami-san
 */
public class Tekija {

    private String nimi;

    public Tekija(String nimi) {
        this.nimi = nimi;
    }
    
    public String getNimi(){
        return nimi;
    }

    @Override
    public String toString() {
        return nimi;
    }
}
