/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Luokasta luodaan listeneri, jolla tarkkaillaan Päivitysnapin painalluksia.
 *
 * @see Nappaimisto.PaivitaNappi
 * @author Ivan
 */
public class PaivitysnapinListeneri implements ActionListener {

    /**
     * FraktaalinPiirtoalusta jota kautta muutokset välitetään.
     */
    private final FraktaalinPiirtoalusta alusta;

    public PaivitysnapinListeneri(FraktaalinPiirtoalusta alusta) {
        this.alusta = alusta;
    }

    /**
     * Metodi tarkkailee graafisen käyttöliittymän "Update" napin painalluksia,
     * ja aina kun nappia painetaan, niin metodi piirtää fraktaalista uuden
     * kuvan.
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        alusta.paivitaKuva();
    }
}
