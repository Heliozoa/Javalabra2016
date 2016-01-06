/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.teos;

import java.io.Serializable;
import java.util.List;
import oma.lukulista.domain.Arvosteltava;
import oma.lukulista.domain.Kategoria;
import oma.lukulista.domain.Nimellinen;
import oma.lukulista.domain.tekija.Tekija;

/**
 * Sisältää teoksen attribuutit
 */
public interface Teos extends Nimellinen, Arvosteltava, Serializable {

    void setTekija(Tekija tekija);

    Tekija getTekija();

    void setKategoria(Kategoria kategoria);

    Kategoria getKategoria();

    void lisaaTagi(String tagi);

    void poistaTagi(String tagi);

    List<String> getTagit();
}
