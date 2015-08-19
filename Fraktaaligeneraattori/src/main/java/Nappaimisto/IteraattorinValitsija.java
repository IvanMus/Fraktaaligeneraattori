/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import Iteraattorit.BurningShipIteraattori;
import Iteraattorit.Iteraattori;
import Iteraattorit.MandelbrotIteraattori;
import javax.swing.JComboBox;

/**
 * Luokka tarjoaa mahdollisuuden lisätä graafisen käyttöliittymän valikkoon
 * erilaisia iteraattoireita.
 * @author Ivan
 */
public class IteraattorinValitsija extends JComboBox<Iteraattori> {
    
    public IteraattorinValitsija() {
        super.addItem(new MandelbrotIteraattori());
        super.addItem(new BurningShipIteraattori());
    } 
   
}
