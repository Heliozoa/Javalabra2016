/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

/**
 * Käyttöliittymärajapinta, jos tulee tarve erilaisille käyttöliittymille.
 */
public interface Kayttoliittyma extends Runnable {

    @Override
    void run();
}
