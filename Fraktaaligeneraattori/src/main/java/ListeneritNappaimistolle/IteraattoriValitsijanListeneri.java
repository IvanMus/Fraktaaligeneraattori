/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import Nappaimisto.IteraattorinValitsija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka josta luotu listeneri tarkkailee iteraattorien vaihtumista.
 *
 * @see Nappaimisto.IteraattorinValitsija
 * @author Ivan
 */
public class IteraattoriValitsijanListeneri implements ActionListener {

    /**
     * FraktaalinPiirtoalusta jota kautta muutokset välitetään.
     */
    private FraktaalinPiirtoalusta alusta;
    /**
     * JComboBox josta iteraattori poimitaan.
     */
    private IteraattorinValitsija valitsija;

    public IteraattoriValitsijanListeneri(FraktaalinPiirtoalusta alusta, IteraattorinValitsija valitsija) {
        this.alusta = alusta;
        this.valitsija = valitsija;
    }

    /**
     * Metodi muuttaa Fraktaalinpiirturin iteraattoria.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.vaihdaIteraattori(valitsija.getItemAt(valitsija.getSelectedIndex()));
    }
}
