/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.teos;

import oma.lukulista.listat.Nimellinen;

/**
 *
 * @author authority
 */
public class Kategoria implements Nimellinen{
    private String nimi;
    
    public Kategoria(String nimi){
        this.nimi = nimi;
    }
    
    public void setNimi(String nimi){
        this.nimi = nimi;
    }
    @Override
    public String getNimi() {
        return nimi;
    }
    
}
