/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.teos;

/**
 *
 * @author sasami-san
 */
public enum Arvosana {
    EI_ARVOSTELTU(0), HUONO(1), OK(2), HYVA(3), ERINOMAINEN(4), PARAS(5);
    
    private int arvosana;
    
    Arvosana(int arvosana){
        this.arvosana = arvosana;
    }
    
    public int getArvosana(){
        return arvosana;
    }
    
    @Override
    public String toString(){
        return arvosana+"";
    }
}
