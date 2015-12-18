/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.teos;

import oma.lukulista.tekija.Tekija;

/**
 *
 * @author sasami-san
 */
public class Kirja implements Teos {

    String nimi;
    Tekija tekija;

    public Kirja(String nimi, String kirjailija) {
        this.nimi = nimi;
        this.tekija = new Tekija(kirjailija);
    }
    
    @Override
    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    
    @Override
    public void setTekija(Tekija tekija){
        this.tekija = tekija;
    }

    @Override
    public String getNimi() {
        return nimi;
    }
    
    @Override
    public Tekija getTekija(){
        return tekija;
    }

    @Override
    public String toString() {
        return nimi +" ("+ tekija +")";
    }
}
