/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.teos;

import java.util.Objects;
import oma.lukulista.listat.Nimellinen;

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
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
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
