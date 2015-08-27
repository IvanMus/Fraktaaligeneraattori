/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritFraktaalinPiirtoalustalle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Luokka vastaa kuvan keskittämisestä tiettyyn pikseliin, riippuen siitä mihin
 * klikataan.
 *
 * @author Ivan
 */
public class KuvanSiirtaja implements MouseListener {

    /**
     * FraktaalinPiirtoalusta jota kautta muutokset välitetään.
     */
    private final FraktaalinPiirtoalusta alusta;

    public KuvanSiirtaja(FraktaalinPiirtoalusta alusta) {
        this.alusta = alusta;
    }

    /**
     * Metodi tarkkailee hiiren klikkauksia, ja perustuen siihen mihin kohtaan
     * kuvaa klikataan, muuttaa klikatun pikselin uudeksi keskipisteeksi.
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getButton() == 1) {
            alusta.vaihdaKeskipiste(me.getX(), me.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
}
