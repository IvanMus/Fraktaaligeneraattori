/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import Iteraattorit.BurningShipIteraattori;
import Iteraattorit.Iteraattori;
import Iteraattorit.MandelbrotIteraattori;
import ListeneritNappaimistolle.IteraattoriValitsijanListeneri;
import javax.swing.JComboBox;

/**
 * Luokka tarjoaa mahdollisuuden lisätä graafisen käyttöliittymän valikkoon
 * erilaisia iteraattoreita.
 * @author Ivan
 */
public class IteraattorinValitsija extends JComboBox<Iteraattori> {
    
    protected IteraattorinValitsija(FraktaalinPiirtoalusta alusta) {
        super.addItem(new MandelbrotIteraattori());
        super.addItem(new BurningShipIteraattori());
        super.addActionListener(new IteraattoriValitsijanListeneri(alusta, this));
    } 
   
}
