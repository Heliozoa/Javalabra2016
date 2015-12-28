/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.listat;

import java.util.ArrayList;

/**
 *
 * @author sasami-san
 * @param <N>
 */
public class Lista<N extends Nimellinen> extends Kokoelma<N> {

    public Lista() {
        kokoelma = new ArrayList<>();
    }
}
