/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import Nappaimisto.VaritaulukonValitsija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka josta luotu listeneri tarkkailee väritaulukon vaihtumisia.
 *
 * @see Nappaimisto.VaritaulukonValitsija
 * @author Ivan
 */
public class VaritaulukkoValitsijanListeneri implements ActionListener {
    /**
     * FraktaalinPiirtoalusta jonka kautta muutokset välitetään.
     */
    private FraktaalinPiirtoalusta alusta;
    /**
     * JComboBox josta väritaulukot poimitaan.
     */
    private VaritaulukonValitsija valitsija;

    public VaritaulukkoValitsijanListeneri(FraktaalinPiirtoalusta alusta, VaritaulukonValitsija valitsija) {
        this.alusta = alusta;
        this.valitsija = valitsija;
    }
    /**
     * Metodi vaihtaa Fraktaalinpiirturin väritaulukkoa.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.vaihdaVaritaulukko(valitsija.getItemAt(valitsija.getSelectedIndex()));
    }
}
