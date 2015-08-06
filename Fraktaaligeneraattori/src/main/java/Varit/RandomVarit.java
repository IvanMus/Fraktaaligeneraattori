/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Ivan
 */
public class RandomVarit extends Varit{
    
    public RandomVarit(int varienMaara) {
        super(varienMaara);
        alustaVarit(varienMaara);        
    }

    @Override
    protected final void alustaVarit(int varienMaara) {
        Random arpoja=new Random();
        for (int i = 0; i <= varienMaara; i++) {
            variTaulukko[i]=new Color(arpoja.nextInt(256), arpoja.nextInt(256), arpoja.nextInt(256), arpoja.nextInt(256));
        }
    }
}
