/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.teos;

import oma.lukulista.domain.Kategoria;
import oma.lukulista.domain.Tagi;
import oma.lukulista.domain.Arvosteltava;
import oma.lukulista.listat.Kokoelma;
import oma.lukulista.domain.Nimellinen;
import oma.lukulista.domain.tekija.Tekija;

/**
 *
 * @author sasami-san
 */
public interface Teos extends Nimellinen, Arvosteltava {

    void setTekija(Tekija tekija);

    Tekija getTekija();

    void setKategoria(Kategoria kategoria);

    Kategoria getKategoria();

    void lisaaTagi(Tagi tagi);

    void poistaTagi(Tagi tagi);

    Kokoelma<Tagi> getTagit();
}
