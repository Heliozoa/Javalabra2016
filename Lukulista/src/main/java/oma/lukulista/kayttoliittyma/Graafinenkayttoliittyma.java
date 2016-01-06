/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import oma.lukulista.kayttoliittyma.paneelit.LisaysPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.ListaPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TietoPaneeli;
import oma.lukulista.kayttoliittyma.toiminnallisuus.ListaKuuntelija;
import oma.lukulista.logiikka.Ohjain;

/**
 * Graafinen käyttöliittymä Lukulistalle.
 */
public class Graafinenkayttoliittyma implements Kayttoliittyma {

    private Ohjain ohjain;
    private JFrame frame;

    private LisaysPaneeli lisaysPaneeli;
    private ListaPaneeli listaPaneeli;
    private TietoPaneeli tietoPaneeli;

    /**
     *
     * @param ohjain Kaikki käyttöliittymään liittymätön toiminnallisuus
     * tapahtuu ohjaimen kautta. Käyttöliittymä ei siis luo itse Teoksia jne.
     */
    public Graafinenkayttoliittyma(Ohjain ohjain) {
        this.ohjain = ohjain;
    }

    /**
     * Avaa graafisen käyttöliittymän. Lataa aluksi teoslistan tiedostosta. Luo
     * tarvittavat komponentit ja näyttää lopputuloksen. Lisää LisaysPaneelin
     * teosten lisäämiseen, ListaPaneelin lisättyjen teosten näyttämiseen ja
     * TietoPaneelin ListaPaneelissa valitun teoksen tietojen näyttämistä ja
     * muokkaamista varten.
     *
     * @see LisaysPaneeli
     * @see ListaPaneeli
     * @see TietoPaneeli
     */
    @Override
    public void run() {
        ohjain.lataa();

        frame = new JFrame("Lukulista");
        frame.setPreferredSize(new Dimension(800, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout ylaLayout = new GridLayout(1, 2);
        container.setLayout(ylaLayout);

        JPanel vasen = alustaVasenPaneeli();
        container.add(vasen);

        JPanel oikea = alustaOikeaPaneeli();
        container.add(oikea);
    }

    private JPanel alustaVasenPaneeli() {
        JPanel vasen = new JPanel();
        vasen.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        listaPaneeli = new ListaPaneeli(ohjain);
        lisaysPaneeli = new LisaysPaneeli(ohjain, listaPaneeli);

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        vasen.add(lisaysPaneeli, c);

        c.gridy = 1;
        c.ipady = 200;
        c.ipadx = 300;
        vasen.add(listaPaneeli, c);

        return vasen;
    }

    private JPanel alustaOikeaPaneeli() {
        JPanel oikea = new JPanel();
        oikea.setLayout(new BorderLayout());

        tietoPaneeli = new TietoPaneeli(ohjain, listaPaneeli);

        listaPaneeli.getTeosJList().addListSelectionListener(new ListaKuuntelija(tietoPaneeli));

        oikea.add(tietoPaneeli);

        return oikea;
    }

    public JFrame getFrame() {
        return frame;
    }

}
