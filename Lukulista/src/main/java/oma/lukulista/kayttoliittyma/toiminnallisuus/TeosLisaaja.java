/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import oma.lukulista.domain.Arvosana;
import oma.lukulista.domain.Kategoria;
import oma.lukulista.kayttoliittyma.paneelit.ListaPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 * Toiminnallisuus teosten lisäämiseen.
 */
public class TeosLisaaja implements ActionListener {

    private Ohjain ohjain;
    private JTextField nimiField;
    private JTextField tekijaField;
    private ListaPaneeli lista;
    private JComboBox kategoriat;
    private JComboBox arvosanat;

    /**
     *
     * @param ohjain Ohjain hoitaa itse lisäyksen logiikan.
     * @param nimiField Lisättävän teoksen nimi saadaan tästä kentästä.
     * @param tekijaField Lisättävän tekijän nimi saadaan tästä kentästä.
     * @param kategoriat Lisättävän teoksen kategoria saadaan tästä valikosta.
     * @param arvosanat Lisättävän teoksen arvosana saadaan tästä valikosta.
     * @param lista Tämä lista päivitetään lisäyksen tapahduttua.
     */
    public TeosLisaaja(Ohjain ohjain, JTextField nimiField, JTextField tekijaField, JComboBox kategoriat, JComboBox arvosanat, ListaPaneeli lista) {
        this.ohjain = ohjain;
        this.nimiField = nimiField;
        this.tekijaField = tekijaField;
        this.kategoriat = kategoriat;
        this.arvosanat = arvosanat;
        this.lista = lista;
    }

    /**
     * Luodaan uusi teos ja päivitetään graafinen lista. Jos nimiField tai
     * tekijaField ovat tyhjiä, ei tehdä mitään. Päivittää listan ja tallentaa
     * teoslistan tiedostoon.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String teoksenNimi = nimiField.getText();
        String tekijanNimi = tekijaField.getText();
        Kategoria kategoria = (Kategoria) kategoriat.getSelectedItem();
        Arvosana arvosana = (Arvosana) arvosanat.getSelectedItem();

        if (teoksenNimi.equals("") || tekijanNimi.equals("")) {
            return;
        }

        ohjain.lisaaUusiKirjaListalle(teoksenNimi, tekijanNimi, kategoria, arvosana);
        nimiField.setText("");
        tekijaField.setText("");
        kategoriat.setSelectedIndex(0);
        arvosanat.setSelectedIndex(0);

        lista.paivita();
        ohjain.tallennaTiedostoon();
    }

}
