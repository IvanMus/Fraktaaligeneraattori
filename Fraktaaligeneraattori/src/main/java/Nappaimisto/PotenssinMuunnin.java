/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import ListeneritNappaimistolle.PotenssinListeneri;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Luokasta luodaan paneeli fraktaalin piirtämiseen käytettävän iteratiivisen
 * funktion potenssin säätämistä varten.
 *
 * @author Ivan
 */
public class PotenssinMuunnin extends JPanel {

    protected PotenssinMuunnin(FraktaalinPiirtoalusta alusta) {
        JSpinner potenssi = new JSpinner(new SpinnerNumberModel(2, -1000, 1000, 1));
        potenssi.addChangeListener(new PotenssinListeneri(alusta, potenssi));
        JLabel nimi = new JLabel("Power             ");
        super.add(nimi);
        nimi.setLabelFor(potenssi);
        super.add(potenssi);
    }
}
