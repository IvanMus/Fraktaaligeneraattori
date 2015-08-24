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
 *
 * @author Ivan
 */
public class IteraatiorajanListeneri implements ChangeListener {
    
    private FraktaalinPiirtoalusta alusta;
    private JSpinner iteraatioraja;
    
    public IteraatiorajanListeneri(FraktaalinPiirtoalusta alusta, JSpinner muunnin) {
        this.alusta = alusta;
        this.iteraatioraja = muunnin;
    }
    
    @Override
    public void stateChanged(ChangeEvent ce) {
        alusta.asetaUusiIteraatioraja((int) iteraatioraja.getValue());
    }
}
