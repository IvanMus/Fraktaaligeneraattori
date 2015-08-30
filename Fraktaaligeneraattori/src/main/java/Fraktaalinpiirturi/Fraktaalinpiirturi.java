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
 *
 * @author Ivan
 */
public class Fraktaalinpiirturi {

    /**
     * Muuttuja vastaa kuvitteellisen koordinaatiston x-koordinaattien ylärajaa.
     */
    private double koordinaatistonXylaraja = 2;
    /**
     * Muuttuja vastaa kuvitteellisen koordinaatiston x-koordinaattien alarajaa.
     */
    private double koordinaatistonXalaraja = -2;
    /**
     * Muuttuja vastaa kuvitteellisen koordinaatiston y-koordinaattien ylärajaa.
     */
    private double koordinaatistonYylaraja = 2;
    /**
     * Muuttuja vastaa kuvitteellisen koordinaatiston y-koordinaattien alarajaa.
     */
    private double koordinaatistonYalaraja = -2;
    /**
     * Muuttuja vastaa fraktaalin piirtämiseen käytettävän iteratiivisen
     * funktion potenssi-parametria.
     */
    private int potenssi = 2;
    /**
     * Muuttuja kertoo kuinka monta iteratiivisen funktion iteraatioita max.
     * tehdään.
     */
    private int iteraatioraja = 1000;
    /**
     * Iteratiivinen funktio jota käytetään fraktaalin piirtämiseen.
     */
    private Iteraattori iteraattori = new MandelbrotIteraattori();
    /**
     * Väritaulukko josta pikselin värittämiseen käytettävät värit poimitaan.
     */
    private Varit varitaulukko = new RandomVarit(1000);
    /**
     * Muuttuja jota käytetään tarkistamaan zoomauksen laillisuus, jotta ohjelma
     * ei kaatuisi.
     *
     * @see ListeneritFraktaalinPiirtoalustalle.Zoomaaja
     */
    private int zoomausKerroin = 0;

    /**
     * Metodi hoitaa tarvittavat alustukset ennen fraktaalinpiirtoa, kuten
     * varitaulukon alustuksen, jos käyttäjä muuttanut värirajoja, ja ulkoistaa
     * fraktaalin piirron toiselle metodille. Tämän jälkeen palautetaan valmis
     * kuva.
     *
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti
     * @return
     */
    public BufferedImage palautaFraktaali(int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        BufferedImage palautettavaKuva = new BufferedImage(pikseleitaHorisontaalisesti, pikseleitaVertikaalisti, 2);
        varitaulukko.alustaJosLineaarisetVaritVaativat();
        double piirtovaliVaakasunnassa = (koordinaatistonXylaraja - koordinaatistonXalaraja) / pikseleitaHorisontaalisesti;
        double piirtovaliPystysuunnassa = (koordinaatistonYylaraja - koordinaatistonYalaraja) / pikseleitaVertikaalisti;
        piirraFraktaali(piirtovaliVaakasunnassa, piirtovaliPystysuunnassa, palautettavaKuva);
        return palautettavaKuva;
    }

    /**
     * Metodi piirtaa fraktaalin välitettyyn BufferedImageen. Piirtovalit taas
     * siirtavat kompleksilukua eteenpäin kuvitteellisessa koordinaatistossa.
     *
     * @param piirtovaliVaakasuunnassa
     * @param piirtovaliPystysuunnassa
     * @param piirrettavaKuva
     */
    private void piirraFraktaali(double piirtovaliVaakasuunnassa, double piirtovaliPystysuunnassa, BufferedImage piirrettavaKuva) {
        int varitettavaXkoordinaatti = 0;
        int varitettavaYkoordinaatti;
        int vari;
        for (double i = koordinaatistonXalaraja + piirtovaliVaakasuunnassa / 2; i <= koordinaatistonXylaraja; i += piirtovaliVaakasuunnassa) {
            varitettavaYkoordinaatti = 0;
            for (double j = koordinaatistonYalaraja + piirtovaliPystysuunnassa / 2; j <= koordinaatistonYylaraja; j += piirtovaliPystysuunnassa) {
                vari = varitaulukko.haeVari(iteraattori.iteroi(new Kompleksiluku(i, j), iteraatioraja, potenssi));
                piirrettavaKuva.setRGB(varitettavaXkoordinaatti, varitettavaYkoordinaatti, vari);
                varitettavaYkoordinaatti++;
            }
            varitettavaXkoordinaatti++;
        }
    }

    /**
     * Metodi muuttaa koordinaatiston rajoja (pienentäen niitä), johon fraktaali
     * piirretään. Annetut keskipisteparametrit ovat skaalaamattomia
     * parametreja, jotka ilmaisevat niitä pikseleitä johon keskipiste tulee
     * muodostumaan. Loput parametrit ovat piirrettävän alustan leveys ja
     * korkeus.
     *
     * @param xKeskipiste
     * @param yKeskipiste
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti
     */
    public void lisaaZoom(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        double koordinaatistonValinPituus = (koordinaatistonXylaraja - koordinaatistonXalaraja) / 5;
        double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
        double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
        muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinPituus);
        zoomausKerroin++;
    }

    /**
     * Metodi muuttaa koordinaatiston rajoja (laajentaen niitä), johon fraktaali
     * piirretään. Annetut keskipisteparametrit ovat skaalaamattomia
     * parametreja, jotka ilmaisevat niitä pikseleitä johon keskipiste tulee
     * muodostumaan. Loput parametrit ovat piirrettävän alustan leveys ja
     * korkeus.
     *
     * @param xKeskipiste
     * @param yKeskipiste
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti
     */
    public void vahennaZoom(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        double koordinaatistonValinPituus = ((koordinaatistonXylaraja - koordinaatistonXalaraja) * 5) / 4;
        double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
        double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
        muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinPituus);
        zoomausKerroin--;
    }

    /**
     * Metodi skaalaa parametrina annetun pikselin koordinaatin koordinaatiston
     * x-koordinaatiksi.
     *
     * @param skaalattavaX
     * @param pikseleidenMaara
     * @return
     */
    private double skaalattuXkoordinaatti(int skaalattavaX, int pikseleidenMaara) {
        return koordinaatistonXalaraja + (koordinaatistonXylaraja - koordinaatistonXalaraja) / pikseleidenMaara * skaalattavaX;
    }

    /**
     * Metodi skaalaa parametrina annetun pikselin koordinaatin koordinaatiston
     * y-koordinaatiksi.
     *
     * @param skaalattavaY
     * @param pikseleidenMaara
     * @return
     */
    private double skaalattuYkoordinaatti(int skaalattavaY, int pikseleidenMaara) {
        return koordinaatistonYalaraja + (koordinaatistonYylaraja - koordinaatistonYalaraja) / pikseleidenMaara * skaalattavaY;
    }

    /**
     * Metodi asettaa koordinaatistolle uudet rajat.
     *
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
     * muodostumaan. Loput parametrit ovat piirrettävän alustan leveys ja
     * korkeus.
     *
     * @param xKeskipiste
     * @param yKeskipiste
     * @param pikseleitaHorisontaalisesti
     * @param pikseleitaVertikaalisti
     */
    public void vaihdaKeskipiste(int xKeskipiste, int yKeskipiste, int pikseleitaHorisontaalisesti, int pikseleitaVertikaalisti) {
        double koordinaatistonValinpituus = (koordinaatistonXylaraja - koordinaatistonXalaraja) / 2;
        double skaalattuXkeskipiste = skaalattuXkoordinaatti(xKeskipiste, pikseleitaHorisontaalisesti);
        double skaalattuYkeskipiste = skaalattuYkoordinaatti(yKeskipiste, pikseleitaVertikaalisti);
        muutaKoordinaatistonRajat(skaalattuXkeskipiste, skaalattuYkeskipiste, koordinaatistonValinpituus);
    }

    /**
     * Fraktaali piirretään tietyn iteratiivisen funktion mukaan, ja metodi
     * muuttaa tässä funktiossa käytettävää potenssia.
     *
     * @param potenssi
     */
    public void asetaUusiPotenssi(int potenssi) {
        this.resetoiKoordinaatistonRajat();
        this.potenssi = potenssi;
    }

    /**
     * Metodi muuttaa iteraatiorajaa, jota käytetään kuvan tarkkuuden
     * määrittämisessä (eli kuinka monta funktion iteraatiota makx. tehdään).
     *
     * @param raja
     */
    public void asetaUusiIteraatioraja(int raja) {
        this.iteraatioraja = raja;
        if (raja > varitaulukko.haeVarienMaara()) {
            varitaulukko.muutaVarienMaara(raja);
        }
    }

    /**
     * Metodi korvaa käytettyä iteraattoria parametrina annetulla
     * iteraattorilla. Iteraattori eli iteroitava funktio määrää piirrettävän
     * kuvan.
     *
     * @param iteraattori
     */
    public void vaihdaIteraattori(Iteraattori iteraattori) {
        if (!this.iteraattori.equals(iteraattori)) {
            this.resetoiKoordinaatistonRajat();
            this.iteraattori = iteraattori;
        }
    }

    /**
     * Metodi vaihtaa fraktaalin piirtämisessä käytettyä väritaulukkoa, josta
     * piirrettävät värit otetaan.
     *
     * @param varitaulukko
     */
    public void vaihdaVaritaulukko(Varit varitaulukko) {
        if (!this.varitaulukko.toString().equals(varitaulukko.toString())) {
            this.varitaulukko.alustaUuteenTaulukkoonVanhanRGBrajat(varitaulukko);
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

    /**
     * Metodi muuttaa punaisen värin rajoja parametreina annetuilla rajoilla.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaPunaisenVarinRajoja(int alaraja, int ylaraja) {
        varitaulukko.muutaPunaisenVarinRajoja(alaraja, ylaraja);
    }

    /**
     * Metodi muuttaa vihreän värin rajoja parametreina annetuilla rajoilla.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaVihreanVarinRajoja(int alaraja, int ylaraja) {
        varitaulukko.muutaVihreanVarinRajoja(alaraja, ylaraja);
    }

    /**
     * Metodi muuttaa sinisen värin rajoja parametreina annetuilla rajoilla.
     *
     * @param alaraja
     * @param ylaraja
     */
    public void muutaSinisenVarinRajoja(int alaraja, int ylaraja) {
        varitaulukko.muutaSinisenVarinRajoja(alaraja, ylaraja);
    }

    public int getZoomauskerroin() {
        return zoomausKerroin;
    }
}
