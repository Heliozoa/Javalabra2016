/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnot;

import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.paneelit.TeosListaPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TeosTietoPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author authority
 */
public class TeosListaKuuntelija implements ListSelectionListener{
    
    private Ohjain ohjain;
    private JList<Teos> teosJList;
    private TeosTietoPaneeli tiedot;
    
    public TeosListaKuuntelija(Ohjain ohjain, TeosTietoPaneeli tiedot){
        this.ohjain = ohjain;
        this.tiedot = tiedot;
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        JList<Teos> lista = (JList<Teos>)lse.getSource();
        
        if(lista.isSelectionEmpty()){
            return;
        }
        
        Teos valittu = lista.getSelectedValue();
        tiedot.naytaTeos(valittu);
    }
    
}
