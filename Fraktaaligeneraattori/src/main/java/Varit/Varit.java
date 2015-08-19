/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;

/**
 * Luokka luo väritaulukon, josta poimitaan värejä fraktaalin piirtämiseen.
 * @author Ivan
 */
public abstract class Varit {
    
   protected Color[] variTaulukko;
   
   protected Varit(int varienMaara) {
       variTaulukko=new Color[varienMaara+1];
       alustaVarit(varienMaara);
   }
   
   /**
    * Metodi hakee parametrina annetun numeron mukaisen värin käytettävästä
    * väritaulukosta.
    * @param varinPaikkanumero
    * @return 
    */
   public int haeVari(int varinPaikkanumero) {
       return variTaulukko[varinPaikkanumero].getRGB();
   }
   
   /**
    * Metodi muuttaa väritaulukon kokoa parametrina annetulla numerolla, ja 
    * lisää siihen uudet värit.
    * @param uusiVarienMaara 
    */
   public void muutaVarienMaara(int uusiVarienMaara) {
       variTaulukko=new Color[uusiVarienMaara+1];
       alustaVarit(uusiVarienMaara);
   }
   
   /**
    * Metodi palauttaa väritaulukon värien määrän.
    * @return 
    */
   public int haeVarienMaara() {
       return variTaulukko.length;
   }
   protected abstract void alustaVarit(int varienMaara);
}
