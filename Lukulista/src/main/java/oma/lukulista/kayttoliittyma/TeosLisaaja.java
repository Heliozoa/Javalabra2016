/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class TeosLisaaja implements ActionListener {

    private Ohjain ohjain;
    private JTextField nimiField;
    private JTextField tekijaField;

    public TeosLisaaja(Ohjain ohjain, JTextField nimiField, JTextField tekijaField) {
        this.ohjain = ohjain;
        this.nimiField = nimiField;
        this.tekijaField = tekijaField;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String teoksenNimi = nimiField.getText();
        String tekijanNimi = tekijaField.getText();

        if (teoksenNimi.equals("") || tekijanNimi.equals("")) {
            return;
        }

        ohjain.lisaaUusiKirjaKokoelmalle(teoksenNimi, tekijanNimi);
        nimiField.setText("");
        tekijaField.setText("");
    }

}
