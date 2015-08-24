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

    protected Color[] variTaulukko;
    protected boolean vaatiikoLineaarisetVaritAlustusta = false;
    protected int punaisenVarinYlaraja = 256;
    protected int punaisenVarinAlaraja = 0;
    protected int vihreanVarinYlaraja = 256;
    protected int vihreanVarinAlaraja = 0;
    protected int sinisenVarinYlaraja = 256;
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

    public void alustaUuteenTaulukkoonVanhanRGBrajat(Varit taulukko) {
        taulukko.punaisenVarinAlaraja = this.punaisenVarinAlaraja;
        taulukko.punaisenVarinYlaraja = this.punaisenVarinYlaraja;
        taulukko.vihreanVarinAlaraja = this.vihreanVarinAlaraja;
        taulukko.vihreanVarinYlaraja = this.vihreanVarinYlaraja;
        taulukko.sinisenVarinAlaraja = this.sinisenVarinAlaraja;
        taulukko.sinisenVarinYlaraja = this.sinisenVarinYlaraja;
    }

    public void muutaPunaisenVarinRajoja(int alaraja, int ylaraja) {
        if (ylaraja > alaraja) {
            punaisenVarinAlaraja = alaraja;
            punaisenVarinYlaraja = ylaraja - alaraja;
            vaatiikoLineaarisetVaritAlustusta = true;
        }
    }

    public void muutaVihreanVarinRajoja(int alaraja, int ylaraja) {
        if (ylaraja > alaraja) {
            vihreanVarinAlaraja = alaraja;
            vihreanVarinYlaraja = ylaraja - alaraja;
            vaatiikoLineaarisetVaritAlustusta = true;
        }
    }

    public void muutaSinisenVarinRajoja(int alaraja, int ylaraja) {
        if (ylaraja > alaraja) {
            sinisenVarinAlaraja = alaraja;
            sinisenVarinYlaraja = ylaraja - alaraja;
            vaatiikoLineaarisetVaritAlustusta = true;
        }
    }

    public void alustaJosLineaarisetVaritVaativat() {
        if (this.toString().equals("Linear Colours") && vaatiikoLineaarisetVaritAlustusta) {
            this.muutaVarienMaara(variTaulukko.length);
        }
    }

    protected abstract void alustaVarit(int varienMaara);
}
