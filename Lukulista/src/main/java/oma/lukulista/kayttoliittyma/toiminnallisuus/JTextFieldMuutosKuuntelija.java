/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.paneelit.TietoPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public abstract class JTextFieldMuutosKuuntelija implements DocumentListener {

    protected Ohjain ohjain;
    protected JTextField textField;
    protected TietoPaneeli tietoPaneeli;

    public JTextFieldMuutosKuuntelija(Ohjain ohjain, JTextField textField, TietoPaneeli tietoPaneeli) {
        this.ohjain = ohjain;
        this.textField = textField;
        this.tietoPaneeli = tietoPaneeli;
    }

    @Override
    public void insertUpdate(DocumentEvent de) {
        paivita();
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        paivita();
    }

    @Override
    public void changedUpdate(DocumentEvent de) {
        paivita();
    }

    public void paivita() {
        Teos t = tietoPaneeli.getNykyinenValinta();

        if (t != null) {
            muutaArvoa(t, textField.getText());
        }
    }

    protected abstract void muutaArvoa(Teos t, String uusiArvo);

}
