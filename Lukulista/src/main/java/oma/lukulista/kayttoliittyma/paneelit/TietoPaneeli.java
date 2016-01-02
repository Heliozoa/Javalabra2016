/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oma.lukulista.kayttoliittyma.paneelit;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import oma.lukulista.domain.teos.Teos;
import oma.lukulista.kayttoliittyma.toiminnallisuus.NimiMuutosKuuntelija;
import oma.lukulista.kayttoliittyma.toiminnallisuus.TekijaMuutosKuuntelija;
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
    private JTextField kategoriaField;
    private JLabel arvosanaLabel;
    private JTextField arvosanaField;
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
    public TietoPaneeli(Ohjain ohjain) {
        super(new GridLayout(0, 2));

        this.ohjain = ohjain;
        luoKomponentit();
    }

    private void luoKomponentit() {
        nimiLabel = new JLabel("Nimi:");
        nimiField = new JTextField();
        tekijaLabel = new JLabel("Tekijä:");
        tekijaField = new JTextField();
        kategoriaLabel = new JLabel("Kategoria");
        kategoriaField = new JTextField();
        arvosanaLabel = new JLabel("Arvosana:");
        arvosanaField = new JTextField();

        nimiField.getDocument().addDocumentListener(new NimiMuutosKuuntelija(ohjain, nimiField, this));
        tekijaField.getDocument().addDocumentListener(new TekijaMuutosKuuntelija(ohjain, tekijaField, this));

        add(nimiLabel);
        add(nimiField);
        add(tekijaLabel);
        add(tekijaField);
        add(kategoriaLabel);
        add(kategoriaField);
        add(arvosanaLabel);
        add(arvosanaField);
    }

    public void naytaTeos(Teos t) {
        nykyinenValinta = t;
        nimiField.setText(t.getNimi());
        tekijaField.setText(t.getTekija().getNimi());
        kategoriaField.setText(t.getKategoria().toString());
        arvosanaField.setText(t.getArvosana().toString());
    }

    public Teos getNykyinenValinta() {
        return nykyinenValinta;
    }

}
