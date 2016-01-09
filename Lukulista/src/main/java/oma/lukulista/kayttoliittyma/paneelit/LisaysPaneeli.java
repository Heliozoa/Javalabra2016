/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import oma.lukulista.kayttoliittyma.komponentit.ArvosanaComboBox;
import oma.lukulista.kayttoliittyma.komponentit.KategoriaComboBox;
import oma.lukulista.kayttoliittyma.toiminnallisuus.TeosLisaaja;
import oma.lukulista.logiikka.Ohjain;

/**
 * Käyttöliittymän paneeli jolta voi lisätä uusia teoksia Lukulistalle.
 */
public class LisaysPaneeli extends JPanel {

    private Ohjain ohjain;
    private ListaPaneeli lista;
    private TeosLisaaja teosLisaaja;

    /**
     * Luo tarvittavat komponentit.
     *
     * @param ohjain Ohjain jonka kautta teokset lisätään.
     * @param listaPaneeli Käyttöliittymän ListaPaneeli joka annetaan
     * TeosLisaajalle parametrina, jotta se pystyy päivittämään listaa lisäyksen
     * jälkeen.
     * @see #teosLisaaja
     */
    public LisaysPaneeli(Ohjain ohjain, ListaPaneeli listaPaneeli) {
        super(new GridLayout(0, 2));

        this.ohjain = ohjain;
        this.lista = listaPaneeli;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JLabel nimiLabel = new JLabel("Nimi");
        JLabel tekijaLabel = new JLabel("Tekijä");
        JLabel kategoriaLabel = new JLabel("Kategoria");
        JLabel arvosanaLabel = new JLabel("Arvosana");

        JTextField nimiField = new JTextField();
        JTextField tekijaField = new JTextField();
        KategoriaComboBox kategoriat = new KategoriaComboBox();
        ArvosanaComboBox arvosanat = new ArvosanaComboBox();

        JButton lisaysButton = new JButton("Lisää");
        teosLisaaja = new TeosLisaaja(ohjain, nimiField, tekijaField, kategoriat, arvosanat, lista);
        lisaysButton.addActionListener(teosLisaaja);

        add(nimiLabel);
        add(nimiField);

        add(tekijaLabel);
        add(tekijaField);
        
        add(kategoriaLabel);
        add(kategoriat);
        
        add(arvosanaLabel);
        add(arvosanat);

        add(lisaysButton);
    }

}
