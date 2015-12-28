/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class TulostusPaneeli extends JPanel {

    private Ohjain ohjain;

    public TulostusPaneeli(Ohjain ohjain) {
        super(new GridLayout(0, 2));

        this.ohjain = ohjain;
        luoKomponentit();
    }

    private void luoKomponentit() {
        JButton teosTulostusButton = new JButton("Tulosta teokset");
        TeosTulostaja teosTulostaja = new TeosTulostaja(ohjain);
        teosTulostusButton.addActionListener(teosTulostaja);

        JButton tekijaTulostusButton = new JButton("Tulosta tekijät");
        TekijaTulostaja tekijaTulostaja = new TekijaTulostaja(ohjain);
        tekijaTulostusButton.addActionListener(tekijaTulostaja);

        add(teosTulostusButton);
        add(tekijaTulostusButton);
    }
}
