/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.toiminnallisuus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import oma.lukulista.domain.Arvosana;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.paneelit.ListaPaneeli;
import oma.lukulista.kayttoliittyma.paneelit.TietoPaneeli;
import oma.lukulista.logiikka.Ohjain;

/**
 * Toiminnallisuus teoksen tietojen päivittämistä varten.
 */
public class TeosPaivittaja implements ActionListener {

    private Ohjain ohjain;
    private ListaPaneeli lista;
    private TietoPaneeli tiedot;

    /**
     *
     * @param ohjain Ohjain hoitaa tallennuksen ja kirjailijan haun/luonnin.
     * @param lista Lista joka päivitetään muutosten tapahduttua.
     * @param tiedot TietoPaneeli, johon päivitettävät tiedot on muutettu.
     */
    public TeosPaivittaja(Ohjain ohjain, ListaPaneeli lista, TietoPaneeli tiedot) {
        this.ohjain = ohjain;
        this.lista = lista;
        this.tiedot = tiedot;
    }

    /**
     * Muutetaan valitun teoksen kaikki tiedot vastaamaan uusia tietoja. Tallentaa teoslistan tiedostoon.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Teos t = tiedot.getNykyinenValinta();

        t.setNimi(tiedot.getNimiField().getText());
        t.setTekija(ohjain.haeKirjailijaTaiLuoUusi(tiedot.getTekijaField().getText()));
        t.setKategoria(tiedot.getKategoriaField().getText());
        t.setArvosana((Arvosana) tiedot.getArvosanat().getSelectedItem());

        lista.paivita();
        ohjain.tallenna();
    }

}
