/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 * Luokka luo graafisen käyttöliittymän näppäimistön.
 *
 * @author Ivan
 */
public class Nappaimisto extends JPanel {

    public Nappaimisto(FraktaalinPiirtoalusta alusta) {
        super.setPreferredSize(new Dimension(340, 730));
        super.setLayout(new GridLayout(5, 2));
        super.add(new PotenssinMuunnin(alusta));
        super.add(new IteraattorinValitsija(alusta));
        super.add(new IteraatiorajaMuunnin(alusta));
        super.add(new VaritaulukonValitsija(alusta));
        super.add(new RGBrajojenSaataja(alusta, "Red Upper Bound", "Red Lower Bound", 1));
        super.add(new RGBrajojenSaataja(alusta, "Green Upper Bound", "Green Lower Bound", 2));
        super.add(new RGBrajojenSaataja(alusta, "Blue Upper Bound", "Blue Lower Bound", 3));
        super.add(new JPanel());
        super.add(new PaivitaNappi(alusta));
        super.add(new TallennusNappi(alusta));
    }
}
