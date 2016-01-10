/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.paneelit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.komponentit.JarjestysComboBox;
import oma.lukulista.kayttoliittyma.toiminnallisuus.ListaFiltteroija;
import oma.lukulista.kayttoliittyma.toiminnallisuus.ListaJarjestaja;
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
        super(new GridBagLayout());

        this.ohjain = ohjain;
        luoKomponentit();
    }

    private void luoKomponentit() {
        GridBagConstraints c = new GridBagConstraints();

        alustaLista();
        paivita();

        c.insets = new Insets(0, 0, 4, 4);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 0;
        c.weightx = 0;

        c.gridx = 0;
        c.gridy = 0;
        lisaaJarjestysKomponentit(c);
        lisaaFiltteriKomponentit(c);

        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 4;
        c.weightx = 1;
        c.weighty = 1;
        add(scrollPane, c);
    }

    /**
     * Päivittää listan, tällä hetkellä aika brute-force tyylisesti, mutta
     * parempaa en tekohetkellä keksinyt.
     */
    public void paivita() {
        model.removeAllElements();
        for (Teos t : ohjain.getFiltteroityJaJarjestettyLista()) {
            model.addElement(t);
        }
    }

    private void lisaaJarjestysKomponentit(GridBagConstraints c) {

        JLabel jarjestysLabel = new JLabel("Järjestys");
        JarjestysComboBox jarjestykset = new JarjestysComboBox();
        jarjestykset.addActionListener(new ListaJarjestaja(ohjain, this, jarjestykset));

        add(jarjestysLabel, c);

        c.gridx++;
        add(jarjestykset, c);
    }

    private void lisaaFiltteriKomponentit(GridBagConstraints c) {

        JLabel filtteriLabel = new JLabel("Filtteri");
        JTextField filtteriField = new JTextField("");
        filtteriField.getDocument().addDocumentListener(new ListaFiltteroija(ohjain, this, filtteriField));

        c.gridx++;
        add(filtteriLabel, c);

        c.insets = new Insets(0, 0, 4, 0);
        c.gridx++;
        add(filtteriField, c);
    }

    private JList alustaLista() {
        model = new DefaultListModel();
        scrollPane = new JScrollPane();
        list = new JList(model);
        scrollPane.setViewportView(list);
        list.setVisibleRowCount(20);
        list.setFixedCellHeight(15);
        list.setFixedCellWidth(100);

        return list;
    }

    public JList<Teos> getTeosJList() {
        return list;
    }

}
