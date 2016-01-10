/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import oma.lukulista.kayttoliittyma.paneelit.ListaPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 * Filtteröi listaa automaattisesti sitä mukaa, kun olioon johon
 * ListaFiltteröijä on kiinnitetty sisällössä tapahtuu muutoksia.
 */
public class ListaFiltteroija implements DocumentListener {

    private Ohjain ohjain;
    private ListaPaneeli listaPaneeli;
    private JTextField filtteriField;

    /**
     * @param ohjain Ohjain hoitaa filtteröinnin logiikan.
     * @param listaPaneeli ListaPaneelia tarvitsee listan päivittämiseen.
     * @param filtteriField Tekstikenttä, johon ListaFiltteröijä on kiinnitetty.
     * Tästä saadaan filtteri.
     */
    public ListaFiltteroija(Ohjain ohjain, ListaPaneeli listaPaneeli, JTextField filtteriField) {
        this.ohjain = ohjain;
        this.listaPaneeli = listaPaneeli;
        this.filtteriField = filtteriField;
    }

    /**
     * @see #changedUpdate(javax.swing.event.DocumentEvent)
     * @param de Tällä parametrilla ei tehdä mitään.
     */
    @Override
    public void insertUpdate(DocumentEvent de) {
        filtteroiLista();
    }

    /**
     * @see #changedUpdate(javax.swing.event.DocumentEvent)
     * @param de Tällä parametrilla ei tehdä mitään.
     */
    @Override
    public void removeUpdate(DocumentEvent de) {
        filtteroiLista();
    }

    /**
     * Asettaa ohjaimeen filtterin ja päivittää listan.
     *
     * @param de Tällä parametrilla ei tehdä mitään.
     */
    @Override
    public void changedUpdate(DocumentEvent de) {
        filtteroiLista();
    }

    private void filtteroiLista() {
        String filtteri = filtteriField.getText();
        ohjain.setFiltteri(filtteri);
        listaPaneeli.paivita();
    }

}
