/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.komponentit;

import javax.swing.JComboBox;
import oma.lukulista.domain.Arvosana;

/**
 * Drop-down lista joka sisältää kaikki eri arvosanat.
 */
public class ArvosanaComboBox extends JComboBox<Arvosana> {

    public ArvosanaComboBox() {
        this.addItem(Arvosana.EI_ARVOSTELTU);
        this.addItem(Arvosana.HUONO);
        this.addItem(Arvosana.OK);
        this.addItem(Arvosana.HYVA);
        this.addItem(Arvosana.ERITTAIN_HYVA);
        this.addItem(Arvosana.ERINOMAINEN);
    }

}
