/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import Nappaimisto.IteraattorinValitsija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ivan
 */
public class IteraattoriValitsijanListeneri implements ActionListener {

    private FraktaalinPiirtoalusta alusta;
    private IteraattorinValitsija valitsija;

    public IteraattoriValitsijanListeneri(FraktaalinPiirtoalusta alusta, IteraattorinValitsija valitsija) {
        this.alusta = alusta;
        this.valitsija = valitsija;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.vaihdaIteraattori(valitsija.getItemAt(valitsija.getSelectedIndex()));
    }
}
