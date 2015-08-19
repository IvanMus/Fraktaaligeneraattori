/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import Listenerit.PaivitysnapinListeneri;
import javax.swing.JButton;

/**
 *
 * @author Ivan
 */
public class PaivitaNappi extends JButton{
    
    public PaivitaNappi(Nappaimisto nappaimisto) {
        super("Update");
        this.addActionListener(new PaivitysnapinListeneri(nappaimisto));
    }
    
}
