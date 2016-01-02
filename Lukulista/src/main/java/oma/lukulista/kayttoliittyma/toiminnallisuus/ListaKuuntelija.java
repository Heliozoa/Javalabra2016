/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.paneelit.ListaPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TietoPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author authority
 */
public class ListaKuuntelija implements ListSelectionListener {

    private Ohjain ohjain;
    private JList<Teos> teosJList;
    private TietoPaneeli tiedot;

    public ListaKuuntelija(Ohjain ohjain, TietoPaneeli tiedot) {
        this.ohjain = ohjain;
        this.tiedot = tiedot;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        JList<Teos> lista = (JList<Teos>) lse.getSource();

        if (lista.isSelectionEmpty()) {
            return;
        }

        Teos valittu = lista.getSelectedValue();

        if (valittu == null) {
            return;
        }

        tiedot.naytaTeos(valittu);
    }

}
