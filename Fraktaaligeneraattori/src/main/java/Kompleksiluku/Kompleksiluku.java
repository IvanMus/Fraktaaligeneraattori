/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kompleksiluku;

/**
 *
 * @author Ivan
 */
public class Kompleksiluku {
    
    private double xKoordinaatti;
    private double yKoordinaatti;
    
    public Kompleksiluku(double xKoordinaatti, double yKoordinaatti) {
        this.xKoordinaatti=xKoordinaatti;
        this.yKoordinaatti=yKoordinaatti;
    }
    
    public Kompleksiluku summa(Kompleksiluku summattava) {
        return new Kompleksiluku(xKoordinaatti+summattava.xKoordinaatti,yKoordinaatti+summattava.yKoordinaatti);
    }
    
    public Kompleksiluku tulo(Kompleksiluku kerrottava) {
        return new Kompleksiluku(xKoordinaatti*kerrottava.xKoordinaatti-yKoordinaatti*kerrottava.yKoordinaatti,xKoordinaatti*kerrottava.yKoordinaatti+yKoordinaatti*kerrottava.xKoordinaatti);
    }
    
    public Kompleksiluku potenssi(int potenssi) {
        if(potenssi==0) {
            return new Kompleksiluku(1,0);
        }
        else if(potenssi<0) {
            return negPotenssi(-potenssi);
        }
        return posPotenssi(potenssi);
    }
    
    private Kompleksiluku negPotenssi(int potenssi) {
        Kompleksiluku kaanteisluku=kaanteisluku();
        if(kaanteisluku==null) {
            return null;
        }
        Kompleksiluku palautettavaLuku=kaanteisluku;
        for (int i = 1; i < potenssi; i++) {
            palautettavaLuku=palautettavaLuku.tulo(kaanteisluku);
        }
        return palautettavaLuku;
    }
    
    private Kompleksiluku posPotenssi(int potenssi) {
        Kompleksiluku palautettavaLuku=this;
        for (int i = 1; i < potenssi; i++) {
            palautettavaLuku=palautettavaLuku.tulo(this);
        }
        return palautettavaLuku;
    }
    
    public Kompleksiluku kaanteisluku() {
        if(xKoordinaatti==0 && yKoordinaatti==0) {
            return null;
        }
        double pituusToiseen=xKoordinaatti*xKoordinaatti+yKoordinaatti*yKoordinaatti;
        return new Kompleksiluku(xKoordinaatti/pituusToiseen,-yKoordinaatti/pituusToiseen);
    }
    
    public double pituusToiseen() {
        return xKoordinaatti*xKoordinaatti+yKoordinaatti*yKoordinaatti;
    }
    
    public double getXKoordinaatti() {
        return xKoordinaatti;
    }
    
    public double getYKoordinaatti() {
        return yKoordinaatti;
    }
}
