/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.logiikka;

import java.util.List;
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
     */
    public void lisaaUusiKirjaListalle(String kirjanNimi, String tekijanNimi);

    /**
     * Etsii nimen perusteella kirjailijaa. Jos kyseistä kirjailijaa ei löydy,
     * niin metodi luo uuden.
     *
     * @param kirjailijanNimi Etsittävän kirjailijan nimi
     * @return Palauttaa joko löytyneen kirjailijan tai vastaluodun uuden
     * kirjailijan
     */
    public Tekija haeKirjailijaTaiLuoUusi(String kirjailijanNimi);

    public List<Teos> getTeosLista();

    public List<Tekija> getTekijaLista();
}
