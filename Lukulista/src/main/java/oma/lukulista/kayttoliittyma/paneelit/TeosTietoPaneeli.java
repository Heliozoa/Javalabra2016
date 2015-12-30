/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.paneelit;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.toiminnot.TeosListaKuuntelija;
import oma.lukulista.logiikka.Ohjain;

/**
 *
 * @author authority
 */
public class TeosTietoPaneeli extends JPanel{
    
    private Ohjain ohjain;
    private JLabel nimiLabel;
    private JTextField nimiField;
    private JLabel tekijaLabel;
    private JTextField tekijaField;
    
    public TeosTietoPaneeli(Ohjain ohjain){
        super(new GridLayout(0,2));
        
        this.ohjain = ohjain;
        luoKomponentit();
    }
    
    private void luoKomponentit(){
        nimiLabel = new JLabel("Nimi:");
        nimiField = new JTextField();
        tekijaLabel = new JLabel("Tekijä:");
        tekijaField = new JTextField();
        
        add(nimiLabel);
        add(nimiField);
        add(tekijaLabel);
        add(tekijaField);
    }
    
    public void naytaTeos(Teos t){
        nimiField.setText(t.getNimi());
        tekijaField.setText(t.getTekija().getNimi());
    }
    
}
