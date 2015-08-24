/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ivan
 */
public class TallennusnapinListeneri implements ActionListener{
    
    private final FraktaalinPiirtoalusta alusta;
    
    public TallennusnapinListeneri(FraktaalinPiirtoalusta alusta) {
        this.alusta=alusta;
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.tallennaKuva();
    }
}
