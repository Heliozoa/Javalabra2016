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
import java.awt.Insets;
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
     * @see #lisaysPaneeli
     * @see #listaPaneeli
     * @see #tietoPaneeli
     */
    @Override
    public void run() {
        ohjain.lataaTiedostosta();

        frame = new JFrame("Lukulista");
        frame.setPreferredSize(new Dimension(800, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        /*
         * Oikea paneeli tarvitsee vasemman paneelin komponentteja, joten on
         * tärkeää, että vasen paneeli alustetaan ensin!
         */
        JPanel vasen = alustaVasenPaneeli();
        JPanel oikea = alustaOikeaPaneeli();

        c.gridx = 0;
        c.gridy = 0;
        lisaaVasenPaneeli(vasen, container, c);

        c.gridx = 1;
        lisaaOikeaPaneeli(oikea, container, c);
    }

    private void lisaaVasenPaneeli(JPanel vasen, Container container, GridBagConstraints c) {
        c.ipadx = 0;
        c.ipady = 0;
        c.insets = new Insets(8, 8, 8, 3);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        container.add(vasen, c);
    }

    private void lisaaOikeaPaneeli(JPanel oikea, Container container, GridBagConstraints c) {
        c.ipadx = 40;
        c.ipady = 30;
        c.insets = new Insets(8, 3, 8, 8);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;

        container.add(oikea, c);
    }

    private JPanel alustaVasenPaneeli() {
        JPanel vasen = new JPanel();
        vasen.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        listaPaneeli = new ListaPaneeli(ohjain);
        lisaysPaneeli = new LisaysPaneeli(ohjain, listaPaneeli);

        c.gridx = 0;
        c.gridy = 0;
        lisaaLisaysPaneeli(lisaysPaneeli, vasen, c);

        c.gridy = 1;
        lisaaListaPaneeli(listaPaneeli, vasen, c);

        return vasen;
    }

    private void lisaaLisaysPaneeli(LisaysPaneeli lisaysPaneeli, JPanel paneeli, GridBagConstraints c) {
        c.ipadx = 60;
        c.insets = new Insets(0, 0, 3, 0);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;

        paneeli.add(lisaysPaneeli, c);
    }

    private void lisaaListaPaneeli(ListaPaneeli listaPaneeli, JPanel paneeli, GridBagConstraints c) {
        c.ipadx = 0;
        c.insets = new Insets(3, 0, 0, 0);
        c.anchor = GridBagConstraints.PAGE_END;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;

        paneeli.add(listaPaneeli, c);
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
