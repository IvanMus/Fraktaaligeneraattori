/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import ListeneritNappaimistolle.IteraatiorajanListeneri;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 * Luokasta luodaan paneeli, jolla säädetään fraktaalin piirtämiseen käytettävän
 * iteratiivisen funktion max. iteraatioiden lukumäärää.
 *
 * @author Ivan
 */
public class IteraatiorajaMuunnin extends JPanel {

    protected IteraatiorajaMuunnin(FraktaalinPiirtoalusta alusta) {
        JSpinner iteraatioraja = new JSpinner(new SpinnerNumberModel(1000, 0, 50000, 100));
        iteraatioraja.addChangeListener(new IteraatiorajanListeneri(alusta, iteraatioraja));
        JLabel nimi = new JLabel("Iteration count");
        super.add(nimi);
        nimi.setLabelFor(iteraatioraja);
        super.add(iteraatioraja);
    }
}
