/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka vastaa graafisen käyttöliittymän "Päivitä" napin toiminnasta.
 * @author Ivan
 */
public class PaivitysnapinListeneri implements ActionListener{
    
    private final FraktaalinPiirtoalusta alusta;
    
    public PaivitysnapinListeneri(FraktaalinPiirtoalusta alusta) {
        this.alusta = alusta;
    }
    
    /**
     * Metodi tarkkailee graafisen käyttöliittymän "Update" napin painalluksia,
     * ja aina kun nappia painetaan, niin metodi piirtää fraktaalista uuden kuvan.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.paivitaKuva();
    }
}
