/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import ListeneritNappaimistolle.VaritaulukkoValitsijanListeneri;
import Varit.LineaarisetVarit;
import Varit.RandomVarit;
import Varit.Varit;
import javax.swing.JComboBox;

/**
 * Luokka tarjoaa mahdollisuuden lisätä graafiseen käyttölittymään erilaisia
 * väritaulukkoja.
 * @author Ivan
 */
public class VaritaulukonValitsija extends JComboBox<Varit> {
    
    public VaritaulukonValitsija(FraktaalinPiirtoalusta alusta) {
        super.addItem(new RandomVarit(-1));
        super.addItem(new LineaarisetVarit(-1));
        super.addActionListener(new VaritaulukkoValitsijanListeneri(alusta, this));
    }
}
