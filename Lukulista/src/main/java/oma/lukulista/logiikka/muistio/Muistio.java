/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka.muistio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oma.lukulista.domain.teos.Teos;

/**
 * Tallentaa teoslistan tiedostoon ja lataa ne siitä pääohjelman käyttöön.
 */
public class Muistio {

    private String tiedostoPolku;

    public Muistio() {
        this.tiedostoPolku = "tallennus/tallennus";
    }

    /**
     * Tallentaa parametrina annetun teoslistan Muistion konstruktorissa
     * annetussa polussa olevaan tiedostoon.
     *
     * @param teokset Tallennettava teoslista.
     */
    public void tallenna(List<Teos> teokset) {
        try {
            File tiedosto = new File(tiedostoPolku);
            tiedosto.createNewFile();

            FileOutputStream tallennusTiedosto = new FileOutputStream(tiedosto);
            ObjectOutputStream tallentaja = new ObjectOutputStream(tallennusTiedosto);

            tallentaja.writeObject(teokset);

        } catch (IOException ex) {
            Logger.getLogger(Muistio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lataa Muistion konstruktorissa annetussa polussa olevasta tiedostosta
     * teoslistan ja palauttaa sen.
     *
     * @return Palauttaa ladatun teoslistan tai null, jos tiedostoon ei ole
     * tallennettu vielä mitään.
     */
    public List<Teos> lataa() {
        try {
            File tiedosto = new File(tiedostoPolku);
            tiedosto.createNewFile();

            FileInputStream latausTiedosto = new FileInputStream(tiedosto);

            if (latausTiedosto.available() > 0) {

                ObjectInputStream lataaja = new ObjectInputStream(latausTiedosto);

                Object o = lataaja.readObject();

                if (o != null) {
                    return (List<Teos>) o;
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Muistio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
