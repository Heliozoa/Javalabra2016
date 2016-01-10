/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka.listakasittely;

import java.util.List;
import oma.lukulista.domain.teos.Teos;

/**
 *
 * @author sasami-san
 */
public class Filtteroija {
    
    public void filtteroiLista(List<Teos> filtteroityTeosLista, List<Teos> teosLista, String filtteri) {
        filtteroityTeosLista.clear();

        if (filtteri.equals("")) {
            filtteroityTeosLista.addAll(teosLista);
            return;
        }

        for (Teos t : teosLista) {
            if (teosVastaaFiltteria(t, filtteri)) {
                filtteroityTeosLista.add(t);
            }
        }
    }

    private boolean teosVastaaFiltteria(Teos t, String filtteri) {
        filtteri = filtteri.toUpperCase();
        String nimi = t.getNimi().toUpperCase();
        String tekijanNimi = t.getTekija().getNimi().toUpperCase();

        return nimi.contains(filtteri) || tekijanNimi.contains(filtteri);
    }
}
