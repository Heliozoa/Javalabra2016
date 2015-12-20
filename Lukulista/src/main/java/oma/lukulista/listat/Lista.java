/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

/**
 *
 * @author authority
 */
public interface Lista<T> {
    T haeNimella(String nimi);
    void lisaa(T t);
}
