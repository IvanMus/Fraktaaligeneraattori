/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Iteraattorit;

import Kompleksiluku.Kompleksiluku;

/**
 * Luokasta luodut oliot vastaavat "Burning Ship"-fraktaalin piirtämiseen
 * käytettävää iteroitavaa funktiota.
 * @author Ivan
 */
public class BurningShipIteraattori implements Iteraattori{

    
     /**
     * Metodi määrää iteroitavan funktion, jota käytetään fraktaalin piirtämiseen.
     * Parametreina annetaan iteroitava kompleksiluku, tehtävien iteraatioiden
     * maks. määrän, sekä tässä funktiossa käytettävä potenssi. Metodi palauttaa
     * tehtyjen iteraatioiden määrän, silloin kun funktio ylittää ensimmäisen
     * kerran kynnysarvon neljä.
     * @param iteroitavaLuku
     * @param iteraatioRaja
     * @param potenssi
     * @return 
     */
    
    @Override
    public int iteroi(Kompleksiluku iteroitavaLuku, int iteraatioRaja, int potenssi) {
        Kompleksiluku tarkasteltavaJono = iteroitavaLuku;
        for (int i = 1; i < iteraatioRaja; i++) {
            if(tarkasteltavaJono.pituusToiseen() > 4) {
                return i;
            }
            tarkasteltavaJono = tarkasteltavaJono.itseisarvoitaKordinaatit();
            tarkasteltavaJono=tarkasteltavaJono.potenssi(potenssi);
            if(tarkasteltavaJono == null) {
                return i;
            }
            tarkasteltavaJono=tarkasteltavaJono.summa(iteroitavaLuku);
        }
        return iteraatioRaja;
    }
    
    @Override
    public String toString() {
        return "Burning Ship";
    }
    
}
