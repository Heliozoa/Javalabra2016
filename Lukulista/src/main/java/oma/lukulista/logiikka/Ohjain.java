/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import java.util.List;
import oma.lukulista.domain.Arvosana;
import oma.lukulista.domain.Jarjestys;
import oma.lukulista.domain.Kategoria;
import oma.lukulista.domain.tekija.Tekija;
import oma.lukulista.domain.teos.Teos;

/**
 * Erottaa käyttöliittymän logiikasta, käyttöliittymä kutsuu ohjaimen metodeja
 * joka hoitaa varsinaiset toiminnat.
 */
public interface Ohjain {

    /**
     *
     * Luo uuden kirjan jos samannimisen tekijän samannimistä kirjaa ei ole jo
     * olemassa. Tarkistaa, onko samanniminen tekijä jo olemassa, jos ei niin
     * luodaan uusi. Tämän jälkeen tarkistetaan onko samannimistä kirjaa
     * olemassa kyseysellä tekijällä. Jos ei, luodaan uusi kirja joka lisätään
     * listalle.
     *
     * @param kirjanNimi Lisättävän kirjan nimi
     * @param tekijanNimi Lisättävän kirjan tekijän nimi
     * @param kategoria Lisättävän kategoria.
     * @param arvosana Lisättävän arvosana.
     */
    public void lisaaUusiKirjaListalle(String kirjanNimi, String tekijanNimi, Kategoria kategoria, Arvosana arvosana);

    /**
     * Etsii nimen perusteella kirjailijaa. Jos kyseistä kirjailijaa ei löydy,
     * niin metodi luo uuden.
     *
     * @param kirjailijanNimi Etsittävän kirjailijan nimi
     * @return Palauttaa joko löytyneen kirjailijan tai vastaluodun uuden
     * kirjailijan
     */
    public Tekija haeKirjailijaTaiLuoUusi(String kirjailijanNimi);

    /**
     * Tallentaa teoslistan tiedostoon Muistion avulla.
     */
    public void tallennaTiedostoon();

    /**
     * Lataa teoslistan tiedostosta Muistion avulla.
     */
    public void lataaTiedostosta();

    /**
     * Poistaa teoksen listalta. Jälkeenpäin tarkistaa, jääkö poistetun teoksen
     * tekijälle enää yhtään kirjaa. Jos ei, myös tekijä poistetaan turhana.
     *
     * @param poistettava Poistettava teos.
     */
    public void poistaTeosListalta(Teos poistettava);

    /**
     * Filtteröi koko teoslistan parametrin filtterillä. Filtteröidyn listan saa
 getFiltteroityJaJarjestettyLista() -metodilla.
     *
     * @param filtteri Jos teoksen tiedoista löytyy filtteri
     */
    public void setFiltteri(String filtteri);

    /**
     * Järjestää teoslistan parametrin määrittämän järjestyksen mukaisesti.
     *
     * @param jarjestys Järjestys, johon lista laitetaan.
     */
    public void setJarjestys(Jarjestys jarjestys);

    public List<Teos> getTeosLista();

    public List<Teos> getFiltteroityJaJarjestettyLista();

    public List<Tekija> getTekijaLista();

}
