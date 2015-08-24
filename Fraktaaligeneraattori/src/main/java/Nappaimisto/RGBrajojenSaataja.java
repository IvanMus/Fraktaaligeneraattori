/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Nappaimisto;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import ListeneritNappaimistolle.PunaisenvarinListeneri;
import ListeneritNappaimistolle.SinisenvarinListeneri;
import ListeneritNappaimistolle.VihreanvarinListeneri;
import java.awt.GridLayout;
import java.util.Hashtable;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author Ivan
 */
public class RGBrajojenSaataja extends JPanel {

    public RGBrajojenSaataja(FraktaalinPiirtoalusta alusta, String ylarajanNimi, String alarajanNimi, int RGBListenerinNumero) {
        super.setLayout(new GridLayout(4, 1));
        JSlider varinYlaraja = new JSlider(JSlider.HORIZONTAL, 0, 256, 256);
        JSlider varinAlaraja = new JSlider(JSlider.HORIZONTAL, 0, 256, 0);
        alustaVariSlideritMerkein(varinAlaraja, varinYlaraja);
        alustaSlidereihinVariListeneri(alusta, RGBListenerinNumero, varinAlaraja, varinYlaraja);
        super.add(new JLabel(ylarajanNimi));
        super.add(varinYlaraja);
        super.add(new JLabel(alarajanNimi));
        super.add(varinAlaraja);

    }

    private void alustaVariSlideritMerkein(JSlider varinAlaraja, JSlider varinYlaraja) {
        Hashtable sliderinMerkit = new Hashtable();
        sliderinMerkit.put(new Integer(0), new JLabel("0"));
        sliderinMerkit.put(new Integer(256), new JLabel("256"));
        varinAlaraja.setLabelTable(sliderinMerkit);
        varinAlaraja.setPaintLabels(true);
        varinYlaraja.setLabelTable(sliderinMerkit);
        varinYlaraja.setPaintLabels(true);
    }

    private void alustaSlidereihinVariListeneri(FraktaalinPiirtoalusta alusta, int listenerinNumero, JSlider varinAlaraja, JSlider varinYlaraja) {
        if (listenerinNumero == 1) {
            lisaaPunaisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        } else if (listenerinNumero == 2) {
            lisaaVihreanvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        } else {
            lisaaSinisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        }
    }

    private void lisaaPunaisenvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider varinAlaraja, JSlider varinYlaraja) {
        PunaisenvarinListeneri listeneri = new PunaisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        varinAlaraja.addChangeListener(listeneri);
        varinYlaraja.addChangeListener(listeneri);
    }

    private void lisaaVihreanvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider varinAlaraja, JSlider varinYlaraja) {
        VihreanvarinListeneri listeneri = new VihreanvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        varinAlaraja.addChangeListener(listeneri);
        varinYlaraja.addChangeListener(listeneri);
    }

    private void lisaaSinisenvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider varinAlaraja, JSlider varinYlaraja) {
        SinisenvarinListeneri listeneri = new SinisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        varinAlaraja.addChangeListener(listeneri);
        varinYlaraja.addChangeListener(listeneri);
    }
}
