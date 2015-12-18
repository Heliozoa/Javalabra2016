/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.main;

import oma.lukulista.teos.Kirja;
import oma.lukulista.teos.Teos;
import oma.lukulista.listat.Teoslista;

/**
 *
 * @author sasami-san
 */
public class Main {
    
    public static void main(String[] args){
        Teoslista teoslista = new Teoslista();
        
        Teos uusi = new Kirja("Testikirja", "Testikirjailija");
        Teos uusi2 = new Kirja("Testikirja2", "Testikirjailija2");
        Teos uusi3 = new Kirja("Testikirja3", "Testikirjailija3");
        
        teoslista.lisaaTeos(uusi);
        teoslista.lisaaTeos(uusi2);
        teoslista.lisaaTeos(uusi3);
        
        System.out.println(teoslista);
        
        
    }
    
}
