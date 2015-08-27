/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import ListeneritNappaimistolle.PaivitysnapinListeneri;
import javax.swing.JButton;

/**
 * Luokasta luodaan nappi, jolla kuvaa päivitetään.
 * @author Ivan
 */
public class PaivitaNappi extends JButton{
    
    protected PaivitaNappi(FraktaalinPiirtoalusta alusta) {
        super("Update");
        this.addActionListener(new PaivitysnapinListeneri(alusta));
    }
    
}
