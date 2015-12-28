/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.paneelit;

import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author sasami-san
 */
public class TeosListaPaneeli extends JPanel {

    private Ohjain ohjain;
    private JList list;
    private DefaultListModel model;

    public TeosListaPaneeli(Ohjain ohjain) {
        super(new GridLayout(0, 1));

        this.ohjain = ohjain;
        luoKomponentit();
    }

    private void luoKomponentit() {
        model = new DefaultListModel();
        list = new JList(model);
        update();

        add(list);
    }
    
    public void update(){
        model.removeAllElements();
        for(Teos t : ohjain.getTeosKokoelma().getKokoelma()){
            model.addElement(t);
        }
    }

}
