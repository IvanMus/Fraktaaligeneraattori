/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritFraktaalinPiirtoalustalle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * Luokka vastaaa kuvan zoomaamisesta.
 * @author Ivan
 */
public class Zoomaaja implements MouseWheelListener{
    
    private FraktaalinPiirtoalusta alusta;
    
    public Zoomaaja(FraktaalinPiirtoalusta alusta) {
        this.alusta = alusta;
    }

    /**
     * Metodi reagoi hiirenrullan liikuttamiseen, ja muuttaa piirettävän 
     * fraktaalin koordinaatiston rajoja, riippuen siitä mihin
     * suuntaan liikuttaminen tapahtuu.
     * @param mwe 
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        if(mwe.getWheelRotation() < 0) {
            if(alusta.getZoomauskerroin() < 28) {
             alusta.lisaaZoom(mwe.getX(), mwe.getY());
            }
        }
        else if(mwe.getWheelRotation() > 0) {
            if(alusta.getZoomauskerroin() > -10) {                         
             alusta.vahennaZoom(mwe.getX(), mwe.getY());
            }
        }
    }
}
