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
public class Tekstikayttoliittyma {

    private Scanner lukija;
    private Ohjain ohjaus;

    public Tekstikayttoliittyma(Scanner lukija, Ohjain ohjaus) {
        this.lukija = lukija;
        this.ohjaus = ohjaus;
    }

    public void run() {

        while (true) {
            String komento = lukija.nextLine();

            if (komento.equals("1")) {
                lisaaUusiTeosListalle();
            } else if (komento.equals("2")) {
                tulostaTeosListalta();
            } else {
                tulostaOhjeet();
            }
        }
    }
    
    public void lisaaUusiTeosListalle(){
        System.out.print("Anna nimi: ");
        String nimi = lukija.nextLine();
        System.out.print("Anna tekijä: ");
        String tekija = lukija.nextLine();
        
        ohjaus.lisaaUusiKirjaListalle(nimi, tekija);
    }
    
    public void tulostaTeosListalta(){
        System.out.print("Haettavan teoksen nimi: ");
        String teoksenNimi = lukija.nextLine();
        
        ohjaus.tulostaTeos(teoksenNimi);
    }

    public void tulostaOhjeet() {
        System.out.println(""
                + "Lukulista\n"
                + " Komennot:\n"
                + "  1: Lisää uusi teos listalle\n"
                + "  2: Tulosta teos listalta");
    }
}
