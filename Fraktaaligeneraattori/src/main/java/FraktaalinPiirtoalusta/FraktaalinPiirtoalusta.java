/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FraktaalinPiirtoalusta;

import Fraktaalinpiirturi.Fraktaalinpiirturi;
import Iteraattorit.Iteraattori;
import KuvanTallentaja.KuvanTallentaja;
import ListeneritFraktaalinPiirtoalustalle.KuvanSiirtaja;
import ListeneritFraktaalinPiirtoalustalle.Zoomaaja;
import Varit.Varit;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Luokka edustaa paneelia johon piirretty kuva asetetaan.
 *
 * @author Ivan
 */
public class FraktaalinPiirtoalusta extends JPanel {

    /**
     * Olio joka piirtää fraktaalin.
     */
    private Fraktaalinpiirturi fraktaalinpiirturi = new Fraktaalinpiirturi();

    public FraktaalinPiirtoalusta() {
        this.addMouseWheelListener(new Zoomaaja(this));
        this.addMouseListener(new KuvanSiirtaja(this));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(fraktaalinpiirturi.piirraFraktaali(this.getWidth(), this.getHeight()), 0, 0, null);
    }

    /**
     * Metodi muuttaa koordinaatiston rajoja (pienentää niitä), johon fraktaali
     * piirretään. Koordinaatiston keskipisteeksi valitaan
     * (xKeskipiste,yKeskipiste).
     *
     * @param xKeskipiste
     * @param yKeskipiste
     */
    public void lisaaZoom(int xKeskipiste, int yKeskipiste) {
        fraktaalinpiirturi.lisaaZoom(xKeskipiste, yKeskipiste, this.getWidth(), this.getHeight());
        this.repaint();
    }

    /**
     * Metodi muuttaa koordinaatiston rajoja (laajeentaen niitä), ottaen
     * keskipisteeksi (xKeskipiste,yKeskipiste).
     *
     * @param xKeskipiste
     * @param yKeskipiste
     */
    public void vahennaZoom(int xKeskipiste, int yKeskipiste) {
        fraktaalinpiirturi.vahennaZoom(xKeskipiste, yKeskipiste, this.getWidth(), this.getHeight());
        this.repaint();
    }

    /**
     * Metodi muutta koordinaatiston keskipistettä, pitäen välipituuden samana.
     * Keskipisteeksi otetaan (xKeskipiste,yKeskipiste).
     *
     * @param xKeskipiste
     * @param yKeskipiste
     */
    public void vaihdaKeskipiste(int xKeskipiste, int yKeskipiste) {
        fraktaalinpiirturi.vaihdaKeskipiste(xKeskipiste, yKeskipiste, this.getWidth(), this.getHeight());
        this.repaint();
    }

    /**
     * Metodi piirtää uuden kuvan sen hetkisten parametrien mukaan (esim.
     * potenssi muuttunut, jolloin kuvakin muuttunut).
     */
    public void paivitaKuva() {
        this.repaint();
    }

    /**
     * Fraktaali piirretään tietyn iteratiivisen funktion mukaan, ja metodi
     * muuttaa tässä funktiossa käytettävää potenssia.
     *
     * @param potenssi
     */
    public void asetaUusiPotenssi(int potenssi) {
        fraktaalinpiirturi.asetaUusiPotenssi(potenssi);
    }

    /**
     * Metodi muuttaa iteraatiorajaa, jota käytetään kuvan tarkkuuden
     * määrittämisessä (eli kuinka monta funktion iteraatiota makx. tehdään).
     *
     * @param raja
     */
    public void asetaUusiIteraatioraja(int raja) {
        fraktaalinpiirturi.asetaUusiIteraatioraja(raja);
    }

    /**
     * Metodi korvaa käytettyä iteraattoria parametrina annetulla
     * iteraattorilla. Iteraattori eli iteroitava funktio määrää piirrettävän
     * kuvan.
     *
     * @param iteraattori
     */
    public void vaihdaIteraattori(Iteraattori iteraattori) {
        fraktaalinpiirturi.vaihdaIteraattori(iteraattori);
    }

    /**
     * Metodi vaihtaa fraktaalin piirtämisessä käytettyä väritaulukkoa, josta
     * piirrettävät värit otetaan.
     *
     * @param varitaulukko
     */
    public void vaihdaVaritaulukko(Varit varitaulukko) {
        fraktaalinpiirturi.vaihdaVaritaulukko(varitaulukko);
    }

    /**
     * Metodi muuttaa punaisen värin rajoja parametreina annetuilla rajoilla.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaPunaisenVarinRajoja(int alaraja, int ylaraja) {
        fraktaalinpiirturi.muutaPunaisenVarinRajoja(alaraja, ylaraja);
    }

    /**
     * Metodi muuttaa vihreän värin rajoja parametreina annetuilla rajoilla.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaVihreanVarinRajoja(int alaraja, int ylaraja) {
        fraktaalinpiirturi.muutaVihreanVarinRajoja(alaraja, ylaraja);
    }

    /**
     * Metodi muuttaa sinisen värin rajoja parametreina annetuilla rajoilla.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaSinisenVarinRajoja(int alaraja, int ylaraja) {
        fraktaalinpiirturi.muutaSinisenVarinRajoja(alaraja, ylaraja);
    }

    /**
     * Metodi tallentaa kuvan fraktaalista.
     */
    public void tallennaKuva() {
        KuvanTallentaja tallentaja = new KuvanTallentaja();
        tallentaja.tallennaKuva(fraktaalinpiirturi);
    }

    /**
     * Metodi palauttaa Fraktaalinpiirturin oliomuuttujan zoomauskerroin.
     *
     * @see Fraktaalinpiirturi.Fraktaalinpiirturi
     * @return
     */
    public int getZoomauskerroin() {
        return fraktaalinpiirturi.getZoomauskerroin();
    }
}
