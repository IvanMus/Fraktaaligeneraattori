/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;

/**
 *
 * @author Ivan
 */
public abstract class Varit {
    
   protected Color[] variTaulukko;
   
   protected Varit(int varienMaara) {
       variTaulukko=new Color[varienMaara+1];
   }
   
   public int haeVari(int varinPaikkanumero) {
       return variTaulukko[varinPaikkanumero].getRGB();
   }
   
   public void muutaVarienMaara(int uusiVarienMaara) {
       variTaulukko=new Color[uusiVarienMaara+1];
       alustaVarit(uusiVarienMaara);
   }
   
   protected abstract void alustaVarit(int varienMaara);
}
