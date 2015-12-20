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
public class TekstiKayttoliittyma implements Kayttoliittyma{

    private Scanner lukija;
    private Ohjain ohjain;

    public TekstiKayttoliittyma(Scanner lukija, Ohjain ohjain) {
        this.lukija = lukija;
        this.ohjain = ohjain;
    }

    @Override
    public void run() {
    }
}
