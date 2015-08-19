/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Luokka luo graafisen käyttöliittymän näppäimistön.
 * @author Ivan
 */
public class Nappaimisto extends JPanel{
    
    private final FraktaalinPiirtoalusta alusta;
    private final JSpinner potenssinMuuntaja = new JSpinner(new SpinnerNumberModel(2, -1000, 1000, 1));
    private final JSpinner iteraatiorajanMuuntaja= new JSpinner(new SpinnerNumberModel(1000, 0, 50000, 100));
    private final IteraattorinValitsija iteraattorinValitsija = new IteraattorinValitsija();
    private final VaritaulukonValitsija varitaulukonValitsija = new VaritaulukonValitsija();
    
    public Nappaimisto(FraktaalinPiirtoalusta alusta) {
        super.setPreferredSize(new Dimension(170, 730));   
        this.alusta = alusta;
        super.setLayout(new GridLayout(5, 1));  
        super.add(alustaMuuntaja(potenssinMuuntaja, "Power             "));
        super.add(alustaMuuntaja(iteraatiorajanMuuntaja, "Iteration Count"));
        super.add(iteraattorinValitsija);
        super.add(varitaulukonValitsija);
        super.add(new PaivitaNappi(this));
    }
    
    /**
     * Metodi käy läpi eri graafisen käyttöliittymän komponentit, tarkastaen
     * niistä eri parametreja piirrettävään frakaaliin littyen. Esimerkiksi
     * päivittynyt potenssi päivitetään myös iteroitavaan funktioon.
     * Lopuksi metodi piirtää uuden kuvan.
     */
    public void paivitaKuva() {
        paivitaIteraatioraja();
        paivitaPotenssi();
        vaihdaVaritaulukko();
        vaihdaIteraattori();
        alusta.paivitaKuva();
    }
    
    /**
     * Metodi muuttaa iteroitavassa funktiossa käytettävää potenssa.
     */
    
    private void paivitaPotenssi() {
        alusta.asetaUusiPotenssi((int)potenssinMuuntaja.getValue());
    }
    
    /**
     * Metodi muuttaa fraktaali piirtämiseen käytettävää iteraattoria eli 
     * iteroitavaa funktiota.
     */
    
    private void vaihdaIteraattori() {
        alusta.vaihdaIteraattori(iteraattorinValitsija.getItemAt(iteraattorinValitsija.getSelectedIndex()));
    }
    
    /**
     * Metodi vaihtaa fraktaalin piirtämiseen käytettävää väritaulukkoa.
     */
    
    private void vaihdaVaritaulukko() {
        alusta.vaihdaVaritaulukko(varitaulukonValitsija.getItemAt(varitaulukonValitsija.getSelectedIndex()));
    }
    
    /**
     * Metodi muuttaa iteroitavan funktion iteraatioiden maks. määrän.
     */
    
    private void paivitaIteraatioraja() {
        alusta.asetaUusiIteraatioraja((int) iteraatiorajanMuuntaja.getValue());
    }
    
    /**
     * Metodi luo uuden paneelin johon alustetaan parametrina annettu JSpinneri
     * ja siihen liittyvä teksti. Lopuksi metodi palauttaa tämän paneelin.
     * @param spinneri
     * @param nimi
     * @return 
     */
    private JPanel alustaMuuntaja(JSpinner spinneri, String nimi) {
        JPanel muuntaja = new JPanel();
        JLabel muuntajanNimi = new JLabel(nimi);
        muuntaja.add(muuntajanNimi);
        muuntajanNimi.setLabelFor(spinneri);
        muuntaja.add(spinneri);
        return muuntaja;
    }
}