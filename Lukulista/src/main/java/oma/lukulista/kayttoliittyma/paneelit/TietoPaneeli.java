/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.paneelit;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.komponentit.ArvosanaComboBox;
import oma.lukulista.kayttoliittyma.komponentit.KategoriaComboBox;
import oma.lukulista.kayttoliittyma.toiminnallisuus.TeosPaivittaja;
import oma.lukulista.kayttoliittyma.toiminnallisuus.TeosPoistaja;
import oma.lukulista.logiikka.Ohjain;

/**
 * Käyttöliittymän paneeli joka näyttää ListaPaneelissa valittuna olevan Teoksen
 * tiedot.
 */
public class TietoPaneeli extends JPanel {

    private Ohjain ohjain;
    private JLabel nimiLabel;
    private JTextField nimiField;
    private JLabel tekijaLabel;
    private JTextField tekijaField;
    private JLabel kategoriaLabel;
    private JComboBox kategoriat;
    private JLabel arvosanaLabel;
    private JComboBox arvosanat;
    private JButton paivitysButton;
    private JButton poistoButton;

    private ListaPaneeli lista;
    private Teos nykyinenValinta;

    /**
     * Luo tarvittavat komponentit, erityisesti MuutosKuuntelijat jotka
     * päivittävät tekstikenttiin muutetut tiedot oliohin.
     *
     * @param ohjain Ohjain välitetään kuuntelijoille jotka päivittävät sen
     * avulla Teos-oliot.
     * @see NimiMuutosKuuntelija
     * @see TekijaMuutosKuuntelija
     */
    public TietoPaneeli(Ohjain ohjain, ListaPaneeli lista) {
        super(new GridLayout(0, 2));

        this.ohjain = ohjain;
        this.lista = lista;
        luoKomponentit();
    }

    private void luoKomponentit() {
        nimiLabel = new JLabel("Nimi:");
        nimiField = new JTextField();
        tekijaLabel = new JLabel("Tekijä:");
        tekijaField = new JTextField();
        kategoriaLabel = new JLabel("Kategoria");
        kategoriat = new KategoriaComboBox();
        arvosanaLabel = new JLabel("Arvosana:");
        arvosanat = new ArvosanaComboBox();
        paivitysButton = new JButton("Päivitä");
        poistoButton = new JButton("Poista");

        paivitysButton.addActionListener(new TeosPaivittaja(ohjain, lista, this));
        poistoButton.addActionListener(new TeosPoistaja(ohjain, lista, this));

        add(nimiLabel);
        add(nimiField);
        add(tekijaLabel);
        add(tekijaField);
        add(kategoriaLabel);
        add(kategoriat);
        add(arvosanaLabel);
        add(arvosanat);
        add(paivitysButton);
        add(poistoButton);
    }

    /**
     * Näyttää paneelissa parametrina annetun teoksen tiedot.
     *
     * @param t Näytettävä teos.
     */
    public void naytaTeos(Teos t) {
        nykyinenValinta = t;
        nimiField.setText(t.getNimi());
        tekijaField.setText(t.getTekija().getNimi());
        kategoriat.setSelectedItem(t.getKategoria());
        arvosanat.setSelectedItem(t.getArvosana());
    }

    public Teos getNykyinenValinta() {
        return nykyinenValinta;
    }

    public JTextField getNimiField() {
        return nimiField;
    }

    public JTextField getTekijaField() {
        return tekijaField;
    }

    public JComboBox getKategoriat() {
        return kategoriat;
    }

    public JComboBox getArvosanat() {
        return arvosanat;
    }

}
