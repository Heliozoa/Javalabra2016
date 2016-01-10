/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.komponentit;

import javax.swing.JComboBox;
import oma.lukulista.domain.enumit.Arvosana;

/**
 * Drop-down lista joka sisältää kaikki eri arvosanat.
 */
public class ArvosanaComboBox extends JComboBox {

    public ArvosanaComboBox() {
        for (Arvosana a : Arvosana.values()) {
            addItem(a);
        }
    }

}
