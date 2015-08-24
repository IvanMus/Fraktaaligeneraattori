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
public class PotenssinListeneri implements ChangeListener {
    
    private FraktaalinPiirtoalusta alusta;
    private JSpinner potenssiMuunnin;
    
    public PotenssinListeneri(FraktaalinPiirtoalusta alusta, JSpinner muunnin) {
        this.alusta=alusta;
        potenssiMuunnin=muunnin;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        alusta.asetaUusiPotenssi((int) potenssiMuunnin.getValue());
    }
    
}
