/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;

/**
 * Luokka alustaa fraktaalin piirtämiseen käytettävät värit väritaulukkoon.
 * @author Ivan
 */
public class LineaarisetVarit extends Varit{
    
    public LineaarisetVarit(int varienMaara) {
        super(varienMaara);        
    }

    /**
     * Metodi lisää väritaulukkoon värit.
     * @param varienMaara 
     */
    @Override
    protected final void alustaVarit(int varienMaara) {
        for (int i = 0; i <= varienMaara; i++) {
            variTaulukko[i]=new Color((i+80)%256,(i+30)%256 ,i%90);
        }
    }
    
    @Override
    public String toString() {
        return "Linear Colours"; 
    }
}
