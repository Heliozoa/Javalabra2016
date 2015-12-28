/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain.tekija;

import oma.lukulista.domain.Arvosteltava;
import oma.lukulista.listat.Lista;
import oma.lukulista.domain.Nimellinen;
import oma.lukulista.domain.teos.Teos;

/**
 *
 * @author authority
 */
public interface Tekija extends Nimellinen, Arvosteltava {

    void lisaaTeos(Teos teos);

    void poistaTeos(Teos teos);

    Lista<Teos> getTeokset();
}
