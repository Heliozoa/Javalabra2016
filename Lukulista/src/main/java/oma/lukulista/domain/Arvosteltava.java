/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.domain;

import oma.lukulista.domain.enumit.Arvosana;

/**
 * Arvosteltavalla luokalla on arvosana jota voi muuttaa.
 */
public interface Arvosteltava {

    public void setArvosana(Arvosana arvosana);

    public Arvosana getArvosana();
}
