/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka.teosvertailijat;

import java.util.Comparator;
import oma.lukulista.domain.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class TeosNimiComparator implements Comparator<Teos> {

    @Override
    public int compare(Teos t, Teos t1) {
        return t.getNimi().toUpperCase().compareTo(t1.getNimi().toUpperCase());
    }
    
}
