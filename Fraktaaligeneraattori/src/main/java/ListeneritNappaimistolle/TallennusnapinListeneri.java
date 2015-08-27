/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka josta luotu listeneri tarkkailee Päivitysnapin painalluksia.
 *
 * @see Nappaimisto.PaivitaNappi
 * @author Ivan
 */
public class TallennusnapinListeneri implements ActionListener {

    /**
     * FraktaalinPiirtoalusta jota kautta muutokset välitetään.
     */
    private final FraktaalinPiirtoalusta alusta;

    public TallennusnapinListeneri(FraktaalinPiirtoalusta alusta) {
        this.alusta = alusta;
    }

    /**
     * Metodi päivitää fraktaalia.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.tallennaKuva();
    }
}
