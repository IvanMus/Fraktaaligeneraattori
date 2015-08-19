/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;
import java.util.Random;

/**
 * Luokka alustaa fraktaalin piirtämiseen käytettävät värit väritaulukkoon.
 * Värit valitaan arpomalla.
 * @author Ivan
 */
public class RandomVarit extends Varit{
    
    public RandomVarit(int varienMaara) {
        super(varienMaara);       
    }
     
    /**
     * Metodi lisää väritaulukkoon värit.
     * @param varienMaara 
     */
    @Override
    protected final void alustaVarit(int varienMaara) {
        Random arpoja=new Random();
        for (int i = 0; i <= varienMaara; i++) {
            variTaulukko[i]=new Color(arpoja.nextInt(256), arpoja.nextInt(256), arpoja.nextInt(256), arpoja.nextInt(256));
        }
    }
    
    @Override
    public String toString() {
        return "Random Colours";
    }
}
