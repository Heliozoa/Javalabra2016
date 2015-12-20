/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

import java.util.Collection;

/**
 *
 * @author authority
 */
public interface Lista<T> {
    void lisaa(T t);
    T haeNimella(String nimi);
    int getKoko();
    Collection getLista();
}
