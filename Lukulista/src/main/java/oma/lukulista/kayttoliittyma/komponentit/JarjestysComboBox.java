/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.komponentit;

import javax.swing.JComboBox;
import oma.lukulista.domain.enumit.Jarjestys;

/**
 * Drop-down lista joka sisältää kaikki eri järjestykset.
 */
public class JarjestysComboBox extends JComboBox {

    public JarjestysComboBox() {
        for (Jarjestys j : Jarjestys.values()) {
            addItem(j);
        }
    }
}
