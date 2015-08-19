/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GraafinenKayttoliittyma;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import Nappaimisto.Nappaimisto;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Luokka edustaa ohjelman graafista käyttöliittymää.
 * @author Ivan
 */
public class GraafinenKayttoliittyma implements Runnable{
    
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Fraktaali");
        frame.setPreferredSize(new Dimension(900, 730));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void luoKomponentit(Container container) {
        FraktaalinPiirtoalusta piirtoalusta = new FraktaalinPiirtoalusta();
        container.add(new Nappaimisto(piirtoalusta), BorderLayout.EAST);
        container.add(piirtoalusta);
    } 
}
