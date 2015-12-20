/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

import java.util.ArrayList;
import java.util.List;
import oma.lukulista.teos.Teos;

/**
 *
 * @author authority
 */
public class TeosLista implements Lista<Teos>{
    
    private List<Teos> teokset;
    
    public TeosLista(){
        teokset = new ArrayList<>();
    }
    
    @Override
    public void lisaa(Teos t){
        teokset.add(t);
    }

    @Override
    public Teos haeNimella(String nimi) {
        for(Teos t : teokset){
            if(t.getNimi().equals(nimi)){
                return t;
            }
        }
        
        return null;
    }
    
}
