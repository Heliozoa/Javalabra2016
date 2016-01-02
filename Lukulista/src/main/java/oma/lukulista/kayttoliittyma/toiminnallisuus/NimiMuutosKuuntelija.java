/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import javax.swing.JTextField;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.paneelit.TietoPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class NimiMuutosKuuntelija extends JTextFieldMuutosKuuntelija {

    public NimiMuutosKuuntelija(Ohjain ohjain, JTextField textField, TietoPaneeli tietoPaneeli) {
        super(ohjain, textField, tietoPaneeli);
    }

    @Override
    protected void muutaArvoa(Teos t, String uusiArvo) {
        t.setNimi(uusiArvo);
    }
}
