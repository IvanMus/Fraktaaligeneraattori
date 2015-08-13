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
public class LineaarisetVarit extends Varit{
    
    public LineaarisetVarit(int varienMaara) {
        super(varienMaara);
        alustaVarit(varienMaara);        
    }

    @Override
    protected final void alustaVarit(int varienMaara) {
        for (int i = 0; i <= varienMaara; i++) {
            variTaulukko[i]=new Color((i+50)%256,(i+50)%256 ,(i+100)%256);
        }
    }
}
