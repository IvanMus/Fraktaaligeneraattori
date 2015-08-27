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
 * Luokka luo paneelin RGB-värimallin tietylle värille, josta säädellään tämän
 * värin ylä- ja alarajaa.
 *
 * @author Ivan
 */
public class RGBrajojenSaataja extends JPanel {

    protected RGBrajojenSaataja(FraktaalinPiirtoalusta alusta, String ylarajanNimi, String alarajanNimi, int RGBListenerinNumero) {
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

    /**
     * Metodi alustaa värin ylä- ja alaraja sliderit merkein.
     *
     * @param varinAlaraja
     * @param varinYlaraja
     */
    private void alustaVariSlideritMerkein(JSlider varinAlaraja, JSlider varinYlaraja) {
        Hashtable sliderinMerkit = new Hashtable();
        sliderinMerkit.put(new Integer(0), new JLabel("0"));
        sliderinMerkit.put(new Integer(256), new JLabel("256"));
        varinAlaraja.setLabelTable(sliderinMerkit);
        varinAlaraja.setPaintLabels(true);
        varinYlaraja.setLabelTable(sliderinMerkit);
        varinYlaraja.setPaintLabels(true);
    }

    /**
     * Metodi lisää värin ylä- ja alaraja slidreihin Listenerin, joka säätää
     * kyseisiä asetuksia Varit-luokassa. ListenerinNumerosta tiedetään mille
     * värille listeneri lisätään.
     *
     * @param alusta
     * @param listenerinNumero
     * @param varinAlaraja
     * @param varinYlaraja
     */
    private void alustaSlidereihinVariListeneri(FraktaalinPiirtoalusta alusta, int listenerinNumero, JSlider varinAlaraja, JSlider varinYlaraja) {
        if (listenerinNumero == 1) {
            lisaaPunaisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        } else if (listenerinNumero == 2) {
            lisaaVihreanvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        } else {
            lisaaSinisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        }
    }

    /**
     * Metodi alustaa värin ylä- ja alaraja slidereihin listenerin punaiselle
     * värille.
     *
     * @param alusta
     * @param varinAlaraja
     * @param varinYlaraja
     */
    private void lisaaPunaisenvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider varinAlaraja, JSlider varinYlaraja) {
        PunaisenvarinListeneri listeneri = new PunaisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        varinAlaraja.addChangeListener(listeneri);
        varinYlaraja.addChangeListener(listeneri);
    }

    /**
     * Metodi alustaa värin ylä- ja alaraja slidereihin listenerin vihreälle
     * värille.
     *
     * @param alusta
     * @param varinAlaraja
     * @param varinYlaraja
     */
    private void lisaaVihreanvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider varinAlaraja, JSlider varinYlaraja) {
        VihreanvarinListeneri listeneri = new VihreanvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        varinAlaraja.addChangeListener(listeneri);
        varinYlaraja.addChangeListener(listeneri);
    }

    /**
     * Metodi alustaa värin ylä- ja alaraja slidereihin listenerin siniselle
     * värille.
     *
     * @param alusta
     * @param varinAlaraja
     * @param varinYlaraja
     */
    private void lisaaSinisenvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider varinAlaraja, JSlider varinYlaraja) {
        SinisenvarinListeneri listeneri = new SinisenvarinListeneri(alusta, varinAlaraja, varinYlaraja);
        varinAlaraja.addChangeListener(listeneri);
        varinYlaraja.addChangeListener(listeneri);
    }
}
