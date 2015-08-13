/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FraktaalinPiirtoalusta;

import Fraktaalinpiirturi.Fraktaalinpiirturi;
import Listenerit.Zoomaaja;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Ivan
 */
public class FraktaalinPiirtoalusta extends JPanel{
    
    private Fraktaalinpiirturi fraktaalinpiirturi = new Fraktaalinpiirturi();
    
    public FraktaalinPiirtoalusta() {
        this.addMouseWheelListener(new Zoomaaja(this));
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(fraktaalinpiirturi.piirraFraktaali(this.getWidth(), this.getHeight()), 0, 0, null);
    }
    
    public void lisaaZoom(int xKeskipiste, int yKeskipiste) {
        fraktaalinpiirturi.lisaaZoom(xKeskipiste, yKeskipiste, this.getWidth(), this.getHeight());
        this.repaint();
    }
    
    public void vahennaZoom(int xKeskipiste, int yKeskipiste) {
        fraktaalinpiirturi.vahennaZoom(xKeskipiste, yKeskipiste, this.getWidth(), this.getHeight());
        this.repaint();
    }
    
    public int getZoomauskerroin() {
        return fraktaalinpiirturi.getZoomauskerroin();
    }
}
