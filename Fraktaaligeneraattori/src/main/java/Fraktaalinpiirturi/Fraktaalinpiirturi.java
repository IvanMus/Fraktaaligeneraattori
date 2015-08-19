/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fraktaalinpiirturi;

import Iteraattorit.Iteraattori;
import Iteraattorit.MandelbrotIteraattori;
import Kompleksiluku.Kompleksiluku;
import Varit.RandomVarit;
import Varit.Varit;
import java.awt.image.BufferedImage;

/**
 * Luokka vastaa fraktaalin piirtämisestä ja tarjoaa sitä monipuolistavia 
 * metodeja.
 * @author Ivan
 */
public class Fraktaalinpiirturi {
    
    private double koordinaatistonXylaraja = 2;
    private double koordinaatistonXalaraja = -2;
    private double koordinaatistonYylaraja = 2;
    private double koordinaatistonYalaraja = -2;
    private int potenssi = 2;
    private int iteraatioraja = 1000;
    private Iteraattori iteraattori = new MandelbrotIteraattori();
    private Varit varitaulukko = new RandomVarit(1000);
    private int zoomausKerroin = 0;
    
    /**
     * Metodi piirtää kuvan fraktaalista, jonka leveys ja korkeus määräytyvät
     * annetuista parametreista.
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti
     * @return 
     */
    
    public BufferedImage piirraFraktaali(int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        BufferedImage palautettavaKuva = new BufferedImage(pikseleitaHorisontaalisesti, pikseleitaVertikaalisti, 2);
        int varitettavaXkoordinaatti = 0;
        int varitettavaYkoordinaatti;
        double piirtovaliVaakasunnassa = (koordinaatistonXylaraja - koordinaatistonXalaraja)/pikseleitaHorisontaalisesti;
        double piirtovaliPystysuunnassa = (koordinaatistonYylaraja - koordinaatistonYalaraja)/pikseleitaVertikaalisti;
        for (double i = koordinaatistonXalaraja + piirtovaliVaakasunnassa/2; i <= koordinaatistonXylaraja; i+=piirtovaliVaakasunnassa) {
            varitettavaYkoordinaatti = 0;
            for (double j = koordinaatistonYalaraja + piirtovaliPystysuunnassa/2; j <= koordinaatistonYylaraja; j+=piirtovaliPystysuunnassa) {
                palautettavaKuva.setRGB(varitettavaXkoordinaatti, varitettavaYkoordinaatti, varitaulukko.haeVari(iteraattori.iteroi(new Kompleksiluku(i,j), iteraatioraja, potenssi)));
                varitettavaYkoordinaatti++;
            }
            varitettavaXkoordinaatti++;
        }
        return palautettavaKuva;
    }
    
    /**
     * Metodi muuttaa koordinaatiston rajoja (pienentäen niitä), johon fraktaali
     * piirretään. Annetut keskipisteparametrit ovat skaalaamattomia parametreja,
     * jotka ilmaisevat niitä pikseleitä johon keskipiste tulee muodostumaan.
     * Loput parametrit ovat piirrettävän alustan leveys ja korkeus.
     * @param xKeskipiste
     * @param yKeskipiste
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti 
     */
    public void lisaaZoom(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
          double koordinaatistonValinPituus = (koordinaatistonXylaraja - koordinaatistonXalaraja)/5;
          double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
          double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
          muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinPituus);
          zoomausKerroin++;
    }
    
    /**
     * Metodi muuttaa koordinaatiston rajoja (laajentaen niitä), johon fraktaali
     * piirretään. Annetut keskipisteparametrit ovat skaalaamattomia parametreja,
     * jotka ilmaisevat niitä pikseleitä johon keskipiste tulee muodostumaan.
     * Loput parametrit ovat piirrettävän alustan leveys ja korkeus.
     * @param xKeskipiste
     * @param yKeskipiste
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti 
     */
    
    public void vahennaZoom(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        double koordinaatistonValinPituus = ((koordinaatistonXylaraja - koordinaatistonXalaraja)*5)/4;
        double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
        double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
        muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinPituus);
        zoomausKerroin--;
    }
    
    /**
     * Metodi skaalaa parametrina annetun pikselin koordinaatin koordinaatiston
     * x-koordinaatiksi.
     * @param skaalattavaX
     * @param pikseleidenMaara
     * @return 
     */
    private double skaalattuXkoordinaatti(int skaalattavaX, int pikseleidenMaara) {
        return koordinaatistonXalaraja + (koordinaatistonXylaraja - koordinaatistonXalaraja)/pikseleidenMaara*skaalattavaX;
    }
    
    /**
     * Metodi skaalaa parametrina annetun pikselin koordinaatin koordinaatiston
     * y-koordinaatiksi.
     * @param skaalattavaY
     * @param pikseleidenMaara
     * @return 
     */
    
    private double skaalattuYkoordinaatti(int skaalattavaY, int pikseleidenMaara) {
        return koordinaatistonYalaraja + (koordinaatistonYylaraja - koordinaatistonYalaraja)/pikseleidenMaara*skaalattavaY;
    }
    
    /**
     * Metodi asettaa koordinaatistolle uudet rajat.
     * @param xKeskipiste
     * @param yKeskipiste
     * @param valinPituus 
     */
    
    private void muutaKoordinaatistonRajat(double xKeskipiste, double yKeskipiste, double valinPituus) {
        koordinaatistonXalaraja = xKeskipiste - valinPituus;
        koordinaatistonXylaraja = xKeskipiste + valinPituus;
        koordinaatistonYalaraja = yKeskipiste - valinPituus;
        koordinaatistonYylaraja = yKeskipiste + valinPituus;
    }
    
   /**
     * Metodi muuttaa koordinaatiston keskipisteen, säilyttäen kordinaatiston
     * välien pituudet. Annetut keskipisteparametrit ovat skaalaamattomia 
     * parametreja, jotka ilmaisevat niitä pikseleitä johon keskipiste tulee 
     * muodostumaan. Loput parametrit ovat piirrettävän alustan leveys ja korkeus.
     * @param xKeskipiste
     * @param yKeskipiste
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti 
     */
    
    public void vaihdaKeskipiste(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        double koordinaatistonValinpituus = (koordinaatistonXylaraja - koordinaatistonXalaraja)/2;
        double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
        double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
        muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinpituus);
    }
    
    /**
     * Fraktaali piirretään tietyn iteratiivisen funktion mukaan, ja metodi
     * muuttaa tässä funktiossa käytettävää potenssia.
     * @param potenssi 
     */
    
    public void asetaUusiPotenssi(int potenssi) {
        if(this.potenssi != potenssi) {
        this.resetoiKoordinaatistonRajat();
        this.potenssi = potenssi;
        }
    }
    
    /**
     * Metodi muuttaa iteraatiorajaa, jota käytetään kuvan tarkkuuden
     * määrittämisessä (eli kuinka monta funktion iteraatiota makx. tehdään).
     * @param raja 
     */
    
    public void asetaUusiIteraatioraja(int raja) {
        if(iteraatioraja != raja) {
        this.iteraatioraja = raja;
        if(raja > varitaulukko.haeVarienMaara()) {
        varitaulukko.muutaVarienMaara(raja);
         }
        }
    }
    
    /**
     * Metodi korvaa käytettyä iteraattoria parametrina annetulla iteraattorilla.
     * Iteraattori eli iteroitava funktio määrää piirrettävän kuvan.
     * @param iteraattori 
     */
    
    public void vaihdaIteraattori(Iteraattori iteraattori) {
        if(!this.iteraattori.equals(iteraattori)) {
        this.resetoiKoordinaatistonRajat();
        this.iteraattori = iteraattori;
        }
    }
    
    /**
     * Metodi vaihtaa fraktaalin piirtämisessä käytettyä väritaulukkoa, josta
     * piirrettävät värit otetaan.
     * @param varitaulukko 
     */

    public void vaihdaVaritaulukko(Varit varitaulukko) {
        if(!this.varitaulukko.toString().equals(varitaulukko.toString())) {
        this.varitaulukko = varitaulukko;
        this.varitaulukko.muutaVarienMaara(iteraatioraja);
        }
    }
    
    /**
     * Metodi resetoi koordinaatiston rajat sellaisiksi, mitkä ne olivat
     * ohjelmaa käynnistettäessä.
     */
    
    private void resetoiKoordinaatistonRajat() {
        zoomausKerroin = 0;
        koordinaatistonXalaraja = -2;
        koordinaatistonXylaraja = 2;
        koordinaatistonYalaraja = -2;
        koordinaatistonYylaraja = 2;
    }
    
    public int getZoomauskerroin() {
        return zoomausKerroin;
    }
    
} 
