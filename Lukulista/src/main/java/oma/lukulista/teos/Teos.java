/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.teos;

import oma.lukulista.tekija.Tekija;

/**
 *
 * @author sasami-san
 */
public interface Teos {
    void setNimi(String nimi);
    void setTekija(Tekija tekija);
    String getNimi();
    Tekija getTekija();
}
