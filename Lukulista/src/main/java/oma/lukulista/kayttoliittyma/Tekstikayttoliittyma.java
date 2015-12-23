/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

import java.util.Scanner;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class Tekstikayttoliittyma implements Kayttoliittyma{
    
    private Ohjain ohjain;
    private Scanner lukija;
    
    public Tekstikayttoliittyma(Ohjain ohjain, Scanner lukija){
        this.ohjain = ohjain;
        this.lukija = lukija;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
