/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import Nappaimisto.VaritaulukonValitsija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ivan
 */
public class VaritaulukkoValitsijanListeneri implements ActionListener{
    
    private FraktaalinPiirtoalusta alusta;
    private VaritaulukonValitsija valitsija;

   public VaritaulukkoValitsijanListeneri(FraktaalinPiirtoalusta alusta, VaritaulukonValitsija valitsija) {
        this.alusta = alusta;
        this.valitsija = valitsija;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.vaihdaVaritaulukko(valitsija.getItemAt(valitsija.getSelectedIndex()));
    }
    
}
