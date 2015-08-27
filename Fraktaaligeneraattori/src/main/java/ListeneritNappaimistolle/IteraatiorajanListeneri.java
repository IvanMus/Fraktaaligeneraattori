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
 * Luokasta luodaan listeneri, jolla tarkkaileen iteratiivisen funktion max.
 * iteraatioiden lukumäärää.
 *
 * @see Nappaimisto.IteraatiorajaMuunnin
 * @author Ivan
 */
public class IteraatiorajanListeneri implements ChangeListener {

    /**
     * FraktaalinPiirtoalusta jota kautta muutokset välitetään.
     */
    private FraktaalinPiirtoalusta alusta;
    /**
     * JSpinneri josta muutokset poimitaan.
     */
    private JSpinner iteraatioraja;

    public IteraatiorajanListeneri(FraktaalinPiirtoalusta alusta, JSpinner muunnin) {
        this.alusta = alusta;
        this.iteraatioraja = muunnin;
    }

    /**
     * Metodi muuttaa iteratiivisen funktion max. iteraatioiden lukumäärää.
     *
     * @param ce
     */
    @Override
    public void stateChanged(ChangeEvent ce) {
        alusta.asetaUusiIteraatioraja((int) iteraatioraja.getValue());
    }
}
