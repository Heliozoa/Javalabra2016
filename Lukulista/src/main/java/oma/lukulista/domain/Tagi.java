/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain;

import java.util.Objects;
import oma.lukulista.domain.Nimellinen;

/**
 *
 * @author authority
 */
public class Tagi implements Nimellinen{
    private String nimi;
    
    public Tagi(String nimi){
        this.nimi = nimi;
    }
    
    @Override
    public void setNimi(String nimi){
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
        final Tagi other = (Tagi) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){
        return nimi;
    }
    
}
