/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Iteraattorit;

import Kompleksiluku.Kompleksiluku;

/**
 *
 * @author Ivan
 */
public class MandelbrotIteraattori implements Iteraattori{
    

    @Override
    public int iteroi(Kompleksiluku iteroitavaLuku, int iteraatioRaja, int potenssi) {
        Kompleksiluku tarkasteltavaJono = iteroitavaLuku;
        for (int i = 1; i < iteraatioRaja; i++) {
            if(tarkasteltavaJono.pituusToiseen() > 4) {
                return i;
            }
            tarkasteltavaJono=tarkasteltavaJono.potenssi(potenssi);
            if(tarkasteltavaJono == null) {
                return i;
            }
            tarkasteltavaJono=tarkasteltavaJono.summa(iteroitavaLuku);
        }
        return iteraatioRaja;
    }    
}
