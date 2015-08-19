/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listenerit;

import Nappaimisto.Nappaimisto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokka vastaa graafisen käyttöliittymän "Päivitä" napin toiminnasta.
 * @author Ivan
 */
public class PaivitysnapinListeneri implements ActionListener{
    
    private final Nappaimisto nappaimisto;
    
    public PaivitysnapinListeneri(Nappaimisto nappaimisto) {
        this.nappaimisto = nappaimisto;
    }
    
    /**
     * Metodi tarkkailee graafisen käyttöliittymän "Update" napin painalluksia,
     * ja aina kun nappia painetaan, niin metodi piirtää fraktaalista uuden kuvan.
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        nappaimisto.paivitaKuva();
    }
}
