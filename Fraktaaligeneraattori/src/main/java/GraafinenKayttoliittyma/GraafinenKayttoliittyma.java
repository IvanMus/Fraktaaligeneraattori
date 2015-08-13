/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraafinenKayttoliittyma;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Ivan
 */
public class GraafinenKayttoliittyma implements Runnable{
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Fraktaali");
        frame.setPreferredSize(new Dimension(730, 730));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        FraktaalinPiirtoalusta piirtoalusta = new FraktaalinPiirtoalusta();
        container.add(piirtoalusta);
    } 
}
