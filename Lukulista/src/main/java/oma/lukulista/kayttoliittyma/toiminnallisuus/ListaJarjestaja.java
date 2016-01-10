/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oma.lukulista.domain.enumit.Jarjestys;
import oma.lukulista.kayttoliittyma.komponentit.JarjestysComboBox;
import oma.lukulista.kayttoliittyma.paneelit.ListaPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 * Muuttaa listan järjestystä.
 *
 */
public class ListaJarjestaja implements ActionListener {

    private Ohjain ohjain;
    private ListaPaneeli listaPaneeli;
    private JarjestysComboBox jarjestykset;

    /**
     *
     * @param ohjain Ohjain hoitaa järjestämisen.
     * @param listaPaneeli ListaPaneeli tarvitaan sen päivitystä varten.
     * @param jarjestykset Tästä saadaan käyttöliittymässä valittu järjestys.
     */
    public ListaJarjestaja(Ohjain ohjain, ListaPaneeli listaPaneeli, JarjestysComboBox jarjestykset) {
        this.ohjain = ohjain;
        this.listaPaneeli = listaPaneeli;
        this.jarjestykset = jarjestykset;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Jarjestys jarjestys = (Jarjestys) jarjestykset.getSelectedItem();
        ohjain.setJarjestys(jarjestys);
        listaPaneeli.paivita();
    }

}
