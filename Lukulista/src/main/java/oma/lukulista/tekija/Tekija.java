/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.tekija;

import oma.lukulista.listat.Lista;
import oma.lukulista.teos.Teos;

/**
 *
 * @author authority
 */
public interface Tekija {
    void setNimi(String nimi);
    String getNimi();
    void lisaaTeos(Teos teos);
    Lista<Teos> getTeokset();
}
