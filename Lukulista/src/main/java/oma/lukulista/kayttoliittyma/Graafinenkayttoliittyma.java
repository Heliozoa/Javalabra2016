/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

import oma.lukulista.kayttoliittyma.paneelit.LisaysPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TulostusPaneeli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class Graafinenkayttoliittyma implements Kayttoliittyma {

    private Ohjain ohjain;
    private JFrame frame;

    public Graafinenkayttoliittyma(Ohjain ohjain) {
        this.ohjain = ohjain;
    }

    @Override
    public void run() {
        frame = new JFrame("Lukulista");
        frame.setPreferredSize(new Dimension(400, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout topLayout = new GridLayout(0, 1);
        container.setLayout(topLayout);

        LisaysPaneeli lisaysPaneeli = new LisaysPaneeli(ohjain);
        TulostusPaneeli tulostusPaneeli = new TulostusPaneeli(ohjain);

        container.add(lisaysPaneeli);
        container.add(tulostusPaneeli);
    }

    public JFrame getFrame() {
        return frame;
    }

}
