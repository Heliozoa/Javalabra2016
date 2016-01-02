/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.paneelit;

import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.logiikka.Ohjain;

/**
 * Käyttöliittymän paneeli joka näyttää JList listana kaikki ohjaimen
 * teoslistalla olevat teokset.
 */
public class ListaPaneeli extends JPanel {

    private Ohjain ohjain;
    private JList list;
    private JScrollPane scrollPane;
    private DefaultListModel model;

    /**
     * Luo tarvittavat komponentit. Tuloksena on valkoinen laatikko jonne
     * lisätään tavaraa ylhäältä alas. Kun listalle tulee tarpeeksi tavaraa, se
     * saa scrollbarin.
     *
     * @param ohjain Paneeli saa teoslistan ohjaimen kautta.
     */
    public ListaPaneeli(Ohjain ohjain) {
        super(new GridLayout(0, 1));

        this.ohjain = ohjain;
        luoKomponentit();
    }

    private void luoKomponentit() {
        model = new DefaultListModel();
        scrollPane = new JScrollPane();
        list = new JList(model);
        scrollPane.setViewportView(list);
        list.setVisibleRowCount(20);
        list.setFixedCellHeight(15);
        list.setFixedCellWidth(100);
        paivita();

        add(scrollPane);
    }

    public JList<Teos> getTeosJList() {
        return list;
    }

    /**
     * Päivittää listan, tällä hetkellä aika brute-force tyylisesti, mutta
     * parempaa en tekohetkellä keksinyt.
     */
    public void paivita() {
        model.removeAllElements();
        for (Teos t : ohjain.getTeosLista()) {
            model.addElement(t);
        }
    }

}
