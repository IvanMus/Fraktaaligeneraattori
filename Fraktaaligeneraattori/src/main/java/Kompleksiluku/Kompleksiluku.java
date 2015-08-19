/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kompleksiluku;

/**
 * Luokasta luodut oliot vastaavat tiettyä kompleksilukua, ja luokka tarjoaa
 * laskutoimituksia edustavia metodeja tämän kompleksiluvun muokkaamiseen.
 * @author Ivan
 */
public class Kompleksiluku {
    
    private double xKoordinaatti;
    private double yKoordinaatti;
    
    public Kompleksiluku(double xKoordinaatti, double yKoordinaatti) {
        this.xKoordinaatti=xKoordinaatti;
        this.yKoordinaatti=yKoordinaatti;
    }
    
    /**
     * Metodi summaa nykyiseen kompleksilukuun parametrina annetun kompleksiluvun
     * ja palauttaa tuloksen.
     * @param summattava
     * @return 
     */
    public Kompleksiluku summa(Kompleksiluku summattava) {
        return new Kompleksiluku(xKoordinaatti+summattava.xKoordinaatti,yKoordinaatti+summattava.yKoordinaatti);
    }
    
    /**
     * Metodi kertoo tämän kompleksiluvun parametrina annetulla kompleksiluvulla
     * ja palauttaa tuloksen.
     * @param kerrottava
     * @return 
     */
    
    public Kompleksiluku tulo(Kompleksiluku kerrottava) {
        return new Kompleksiluku(xKoordinaatti*kerrottava.xKoordinaatti-yKoordinaatti*kerrottava.yKoordinaatti,xKoordinaatti*kerrottava.yKoordinaatti+yKoordinaatti*kerrottava.xKoordinaatti);
    }
    
    /**
     * Metodi laskee tämän kompleksiluvun potenssin käyttäen annettua parametria.
     * Tämän jälkeen palautetaan tulos ja null, jos tulos määrittämätön.
     * @param potenssi
     * @return 
     */
    public Kompleksiluku potenssi(int potenssi) {
        if(potenssi==0) {
            return new Kompleksiluku(1,0);
        }
        else if(potenssi<0) {
            return negPotenssi(-potenssi);
        }
        return posPotenssi(potenssi);
    }
    
    /**
     * Metodi laskee tämän kompleksiluvun negatiivisen potenssin.
     * @param potenssi
     * @return 
     */
    private Kompleksiluku negPotenssi(int potenssi) {
        Kompleksiluku kaanteisluku=kaanteisluku();
        if(kaanteisluku==null) {
            return null;
        }
        Kompleksiluku palautettavaLuku=kaanteisluku;
        for (int i = 1; i < potenssi; i++) {
            palautettavaLuku=palautettavaLuku.tulo(kaanteisluku);
        }
        return palautettavaLuku;
    }
    
    /**
     * Metodi laskee tämän kompleksiluvun positiivisen potenssin.
     * @param potenssi
     * @return 
     */
    private Kompleksiluku posPotenssi(int potenssi) {
        Kompleksiluku palautettavaLuku=this;
        for (int i = 1; i < potenssi; i++) {
            palautettavaLuku=palautettavaLuku.tulo(this);
        }
        return palautettavaLuku;
    }
    
    /**
     * Metodi laskee tämän kompleksiluvun käänteisluvun ja palauttaa tuloksen tai
     * nullin, jos tulos määrittämätön.
     * @return 
     */
    
    public Kompleksiluku kaanteisluku() {
        if(xKoordinaatti==0 && yKoordinaatti==0) {
            return null;
        }
        double pituusToiseen=pituusToiseen();
        return new Kompleksiluku(xKoordinaatti/pituusToiseen,-yKoordinaatti/pituusToiseen);
    }
    
    /**
     * Metodi laskee tämän kompleksiluvun normin neliön, ja palauttaa tuloksen.
     * @return 
     */
    public double pituusToiseen() {
        return xKoordinaatti*xKoordinaatti+yKoordinaatti*yKoordinaatti;
    }
    
    /**
     * Metodi palauttaa kompleksiluvun, jonka koordinaatit ovat tämän kompleksiluvun
     * koordinaattien itseisarvot.
     * @return 
     */
    
    public Kompleksiluku itseisarvoitaKordinaatit() {
        return new Kompleksiluku(Math.abs(xKoordinaatti), Math.abs(yKoordinaatti));
    }
    
    public double getXKoordinaatti() {
        return xKoordinaatti;
    }
    
    public double getYKoordinaatti() {
        return yKoordinaatti;
    }
}
