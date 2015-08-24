/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import ListeneritNappaimistolle.TallennusnapinListeneri;
import javax.swing.JButton;

/**
 *
 * @author Ivan
 */
public class TallennusNappi extends JButton {
    
    public TallennusNappi(FraktaalinPiirtoalusta alusta) {
        super("Save Image");
        super.addActionListener(new TallennusnapinListeneri(alusta));
    }
}
