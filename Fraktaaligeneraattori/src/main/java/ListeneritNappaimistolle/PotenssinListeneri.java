/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Luokasta luodaan listeneri, jolla tarkkaillaan iteratiivisen funktion
 * potenssin muunnoksia.
 *
 * @see Nappaimisto.PotenssinMuunnin
 * @author Ivan
 */
public class PotenssinListeneri implements ChangeListener {

    /**
     * FraktaalinPiirtoalusta jota kautta muutokset välitetään.
     */
    private FraktaalinPiirtoalusta alusta;
    /**
     * JSpinneri josta muutokset poimitaan.
     */
    private JSpinner potenssiMuunnin;

    public PotenssinListeneri(FraktaalinPiirtoalusta alusta, JSpinner muunnin) {
        this.alusta = alusta;
        potenssiMuunnin = muunnin;
    }

    /**
     * Metodi muuttaa iteratiivisen funktion potenssia.
     *
     * @param ce
     */
    @Override
    public void stateChanged(ChangeEvent ce) {
        alusta.asetaUusiPotenssi((int) potenssiMuunnin.getValue());
    }
}
