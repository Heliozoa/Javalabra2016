/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

import java.awt.BorderLayout;
import oma.lukulista.kayttoliittyma.paneelit.LisaysPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TulostusPaneeli;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import oma.lukulista.kayttoliittyma.paneelit.TeosListaPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TeosTietoPaneeli;
import oma.lukulista.kayttoliittyma.toiminnot.TeosListaKuuntelija;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class Graafinenkayttoliittyma implements Kayttoliittyma {

    private Ohjain ohjain;
    private JFrame frame;

    private TeosListaPaneeli teosListaPaneeli;
    
    public Graafinenkayttoliittyma(Ohjain ohjain) {
        this.ohjain = ohjain;
    }

    @Override
    public void run() {
        frame = new JFrame("Lukulista");
        frame.setPreferredSize(new Dimension(800, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout ylaLayout = new GridLayout(1,2);
        container.setLayout(ylaLayout);

        JPanel vasen = alustaVasenPaneeli();
        container.add(vasen);

        JPanel oikea = alustaOikeaPaneeli();
        container.add(oikea);
    }
    
    private JPanel alustaOikeaPaneeli(){
        JPanel oikea = new JPanel();
        oikea.setLayout(new BorderLayout());
        
        TeosTietoPaneeli teosTietoListaPaneeli = new TeosTietoPaneeli(ohjain);
        TeosListaKuuntelija teosListaKuuntelija = new TeosListaKuuntelija(ohjain, teosTietoListaPaneeli);
        teosListaPaneeli.getTeosJList().addListSelectionListener(teosListaKuuntelija);
        oikea.add(teosTietoListaPaneeli);
        
        return oikea;
    }
    
    private JPanel alustaVasenPaneeli(){
        JPanel vasen = new JPanel();
        vasen.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        TulostusPaneeli tulostusPaneeli = new TulostusPaneeli(ohjain);
        teosListaPaneeli = new TeosListaPaneeli(ohjain);
        LisaysPaneeli lisaysPaneeli = new LisaysPaneeli(ohjain, teosListaPaneeli);

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        vasen.add(lisaysPaneeli, c);
        c.gridy = 1;
        vasen.add(tulostusPaneeli, c);
        c.gridy = 2;
        c.ipady = 200;
        vasen.add(teosListaPaneeli, c);
        
        return vasen;
    }

    public JFrame getFrame() {
        return frame;
    }

}
