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
import oma.lukulista.kayttoliittyma.toiminnallisuus.TeosLisaaja;
import oma.lukulista.logiikka.Ohjain;

/**
 * Käyttöliittymän paneeli jolta voi lisätä uusia teoksia Lukulistalle.
 */
public class LisaysPaneeli extends JPanel {

    private Ohjain ohjain;
    private ListaPaneeli lista;

    /**
     * Luo tarvittavat komponentit.
     *
     * @param ohjain Ohjain jonka kautta teokset lisätään.
     * @param listaPaneeli Käyttöliittymän ListaPaneeli joka annetaan
     * TeosLisaajalle parametrina, jotta se pystyy päivittämään listaa lisäyksen
     * jälkeen.
     * @see TeosLisaaja
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

        JTextField nimiField = new JTextField();
        JTextField tekijaField = new JTextField();

        JButton lisaysButton = new JButton("Lisää");
        TeosLisaaja teosLisaaja = new TeosLisaaja(ohjain, nimiField, tekijaField, lista);
        lisaysButton.addActionListener(teosLisaaja);

        add(nimiLabel);
        add(nimiField);

        add(tekijaLabel);
        add(tekijaField);

        add(lisaysButton);
    }

}
