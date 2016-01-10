/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oma.lukulista.kayttoliittyma.paneelit.ListaPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TietoPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 * Toiminnallisuus teoksen listalta poistamista varten.
 */
public class TeosPoistaja implements ActionListener {

    private Ohjain ohjain;
    private ListaPaneeli lista;
    private TietoPaneeli tiedot;

    /**
     *
     * @param ohjain Ohjain hoitaa poistamisen logiikan.
     * @param lista Lista joka päivitetään.
     * @param tiedot TietoPaneelista saadaan valittu teos joka halutaan poistaa.
     */
    public TeosPoistaja(Ohjain ohjain, ListaPaneeli lista, TietoPaneeli tiedot) {
        this.ohjain = ohjain;
        this.lista = lista;
        this.tiedot = tiedot;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int valinta = lista.getTeosJList().getSelectedIndex();
        ohjain.poistaTeosListalta(tiedot.getNykyinenValinta());
        lista.paivita();

        if (valinta < 0) {
            valinta = 1;
        }
        lista.getTeosJList().setSelectedIndex(valinta - 1);
    }

}
