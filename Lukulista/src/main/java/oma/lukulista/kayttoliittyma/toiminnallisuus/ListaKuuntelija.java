/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.paneelit.TietoPaneeli;

/**
 * Päivittää TietoPaneelin automaattisesti kun listalla (johon ListaKuuntelija
 * kiinnitetään) valitaan jotain.
 */
public class ListaKuuntelija implements ListSelectionListener {

    private TietoPaneeli tiedot;

    /**
     *
     * @param tiedot TietoPaneeli jolla valitun teoksen tiedot halutaan näyttää.
     */
    public ListaKuuntelija(TietoPaneeli tiedot) {
        this.tiedot = tiedot;
    }

    /**
     * Näyttää TietoPaneelissa valitun teoksen tiedot kun valinta muuttuu.
     *
     * @param lse
     */
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
