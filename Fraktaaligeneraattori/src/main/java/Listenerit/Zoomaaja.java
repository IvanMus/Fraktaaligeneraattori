/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Listenerit;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
 * @author Ivan
 */
public class Zoomaaja implements MouseWheelListener{
    
    private FraktaalinPiirtoalusta alusta;
    
    public Zoomaaja(FraktaalinPiirtoalusta alusta) {
        this.alusta = alusta;
    }

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
