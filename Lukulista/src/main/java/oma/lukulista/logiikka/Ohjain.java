/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import oma.lukulista.listat.Kokoelma;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Teos;

/**
 *
 * @author sasami-san
 */
public interface Ohjain {

    public void lisaaUusiKirjaKokoelmalle(String teoksenNimi, String tekijanNimi);

    public Kokoelma<Teos> getTeosKokoelma();

    public Kokoelma<Tekija> getTekijaKokoelma();
}
