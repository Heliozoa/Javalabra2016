/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class TeosTulostaja implements ActionListener {

    private Ohjain ohjain;

    public TeosTulostaja(Ohjain ohjain) {
        this.ohjain = ohjain;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(ohjain.getTeosKokoelma().getKokoelma().toString());
    }

}
