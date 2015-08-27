/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;

/**
 * Luokka luo väritaulukon, josta poimitaan värejä fraktaalin piirtämiseen.
 *
 * @author Ivan
 */
public abstract class Varit {

    /**
     * Väritaulukko josta pikselin värittämiseen käytettävät värit poimitaan.
     */
    protected Color[] variTaulukko;
    /**
     * Totuuarvoinen muuttuja, joka muuttuu todeksi, kun RGB-väriasetuksia
     * säädetään.
     */
    protected boolean vaatiikoLineaarisetVaritAlustusta = false;
    /**
     * RGB-värimallin punaisen värin yläraja.
     */
    protected int punaisenVarinYlaraja = 256;
    /**
     * RGB-värimallin punaisen värin alaraja.
     */
    protected int punaisenVarinAlaraja = 0;
    /**
     * RGB-värimallin vihreän värin yläraja.
     */
    protected int vihreanVarinYlaraja = 256;
    /**
     * RGB-värimallin vihreän värin alaraja.
     */
    protected int vihreanVarinAlaraja = 0;
    /**
     * RGB-värimallin sinisen värin yläraja.
     */
    protected int sinisenVarinYlaraja = 256;
    /**
     * RGB-värimallin sinisen värin alaraja.
     */
    protected int sinisenVarinAlaraja = 0;

    protected Varit(int varienMaara) {
        variTaulukko = new Color[varienMaara + 1];
        alustaVarit(varienMaara);
    }

    /**
     * Metodi hakee parametrina annetun numeron mukaisen värin käytettävästä
     * väritaulukosta.
     *
     * @param varinPaikkanumero
     * @return
     */
    public int haeVari(int varinPaikkanumero) {
        return variTaulukko[varinPaikkanumero].getRGB();
    }

    /**
     * Metodi muuttaa väritaulukon kokoa parametrina annetulla numerolla, ja
     * lisää siihen uudet värit.
     *
     * @param uusiVarienMaara
     */
    public void muutaVarienMaara(int uusiVarienMaara) {
        variTaulukko = new Color[uusiVarienMaara + 1];
        alustaVarit(uusiVarienMaara);
    }

    /**
     * Metodi palauttaa väritaulukon värien määrän.
     *
     * @return
     */
    public int haeVarienMaara() {
        return variTaulukko.length;
    }

    /**
     * Metodi alustaa värien ylä- ja alarajat vanhasta väritaulukosta, kun
     * Fraktaalinpiirturin väritaulukkoa vaihdetaan.
     *
     * @param taulukko
     */
    public void alustaUuteenTaulukkoonVanhanRGBrajat(Varit taulukko) {
        taulukko.punaisenVarinAlaraja = this.punaisenVarinAlaraja;
        taulukko.punaisenVarinYlaraja = this.punaisenVarinYlaraja;
        taulukko.vihreanVarinAlaraja = this.vihreanVarinAlaraja;
        taulukko.vihreanVarinYlaraja = this.vihreanVarinYlaraja;
        taulukko.sinisenVarinAlaraja = this.sinisenVarinAlaraja;
        taulukko.sinisenVarinYlaraja = this.sinisenVarinYlaraja;
    }

    /**
     * Metodi muuttaa punaisen värin rajoja parametreina annetuilla rajoilla,
     * mikäli sallittua. Lisäksi asettaa LineaarisetVarit alustettaviksi.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaPunaisenVarinRajoja(int alaraja, int ylaraja) {
        if (ylaraja > alaraja) {
            punaisenVarinAlaraja = alaraja;
            punaisenVarinYlaraja = ylaraja - alaraja;
            vaatiikoLineaarisetVaritAlustusta = true;
        }
    }

    /**
     * Metodi muuttaa vihreän värin rajoja parametreina annetuilla rajoilla,
     * mikäli sallittua. Lisäksi asettaa LineaarisetVarit alustettaviksi.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaVihreanVarinRajoja(int alaraja, int ylaraja) {
        if (ylaraja > alaraja) {
            vihreanVarinAlaraja = alaraja;
            vihreanVarinYlaraja = ylaraja - alaraja;
            vaatiikoLineaarisetVaritAlustusta = true;
        }
    }

    /**
     * Metodi muuttaa sinisen värin rajoja parametreina annetuilla rajoilla,
     * mikäli sallittua. Lisäksi asettaa LineaarisetVarit alustettaviksi.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaSinisenVarinRajoja(int alaraja, int ylaraja) {
        if (ylaraja > alaraja) {
            sinisenVarinAlaraja = alaraja;
            sinisenVarinYlaraja = ylaraja - alaraja;
            vaatiikoLineaarisetVaritAlustusta = true;
        }
    }

    /**
     * Metodi tarkistaa, että Fraktaalinpiirturin nykyinen väritaulukko on
     * lähtöisin LineaarissetVarit-luokasta ja vaatiiko väritaulukko
     * alustamista. Mikäli näin on, väritaulukko alustetaan.
     */
    public void alustaJosLineaarisetVaritVaativat() {
        if (this.toString().equals("Linear Colours") && vaatiikoLineaarisetVaritAlustusta) {
            this.muutaVarienMaara(variTaulukko.length);
        }
    }

    protected abstract void alustaVarit(int varienMaara);
}
