/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fraktaalinpiirturi;

import Iteraattorit.Iteraattori;
import Iteraattorit.MandelbrotIteraattori;
import Kompleksiluku.Kompleksiluku;
import Varit.LineaarisetVarit;
import Varit.RandomVarit;
import Varit.Varit;
import java.awt.image.BufferedImage;

/**
 *
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
    private Varit varitaulukko = new LineaarisetVarit(1000);
    private int zoomausKerroin = 0;
    
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
    
    public void lisaaZoom(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
          double koordinaatistonValinPituus = (koordinaatistonXylaraja - koordinaatistonXalaraja)/5;
          double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
          double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
          muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinPituus);
          zoomausKerroin++;
    }
    
    public void vahennaZoom(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        double koordinaatistonValinPituus = ((koordinaatistonXylaraja - koordinaatistonXalaraja)*5)/4;
        double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
        double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
        muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinPituus);
        zoomausKerroin--;
    }
    
    private double skaalattuXkoordinaatti(int skaalattavaX, int pikseleidenMaara) {
        return koordinaatistonXalaraja + (koordinaatistonXylaraja - koordinaatistonXalaraja)/pikseleidenMaara*skaalattavaX;
    }
    
    private double skaalattuYkoordinaatti(int skaalattavaY, int pikseleidenMaara) {
        return koordinaatistonYalaraja + (koordinaatistonYylaraja - koordinaatistonYalaraja)/pikseleidenMaara*skaalattavaY;
    }
    
    private void muutaKoordinaatistonRajat(double xKeskipiste, double yKeskipiste, double valinPituus) {
        koordinaatistonXalaraja = xKeskipiste - valinPituus;
        koordinaatistonXylaraja = xKeskipiste + valinPituus;
        koordinaatistonYalaraja = yKeskipiste - valinPituus;
        koordinaatistonYylaraja = yKeskipiste + valinPituus;
    }

    
    public int getZoomauskerroin() {
        return zoomausKerroin;
    }
} 
