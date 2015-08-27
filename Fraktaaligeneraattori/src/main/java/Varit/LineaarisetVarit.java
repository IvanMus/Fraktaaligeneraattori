/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;

/**
 * Luokka alustaa fraktaalin piirtämiseen käytettävät värit väritaulukkoon.
 *
 * @author Ivan
 */
public class LineaarisetVarit extends Varit {

    public LineaarisetVarit(int varienMaara) {
        super(varienMaara);
    }

    /**
     * Metodi lisää väritaulukkoon värit, ja asettaa yläluokan oliomuuttujan
     * vaatiikoLineaarisetVaritAlustusta falseksi, alustamisen juuri
     * tapahduttua.
     *
     * @param varienMaara
     */
    @Override
    protected final void alustaVarit(int varienMaara) {
        for (int i = 0; i <= varienMaara; i++) {
            variTaulukko[i] = new Color(i % punaisenVarinYlaraja + punaisenVarinAlaraja, i % vihreanVarinYlaraja + vihreanVarinAlaraja, i % sinisenVarinYlaraja + sinisenVarinAlaraja);
        }
        vaatiikoLineaarisetVaritAlustusta = false;
    }

    @Override
    public String toString() {
        return "Linear Colours";
    }
}
