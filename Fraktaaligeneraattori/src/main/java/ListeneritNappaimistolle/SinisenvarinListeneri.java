/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ListeneritNappaimistolle;

import FraktaalinPiirtoalusta.FraktaalinPiirtoalusta;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Luokasta luodaan listeneri, jolla tarkkaillaan RGB-värimallin sinisen värin
 * muutoksia.
 *
 * @see Nappaimisto.RGBrajojenSaataja
 * @author Ivan
 */
public class SinisenvarinListeneri implements ChangeListener {

    /**
     * JSlideri jolla säädetään sinisen värin ylärajaa.
     */
    private final JSlider varinYlaraja;
    /**
     * JSlideri jolla säädetään sinisen värin alarajaa.
     */
    private final JSlider varinAlaraja;
    /**
     * FraktaalinPiirtoalusta jota kautta muutokset välitetään.
     */
    private final FraktaalinPiirtoalusta alusta;

    public SinisenvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider alaraja, JSlider ylaraja) {
        this.alusta = alusta;
        varinYlaraja = ylaraja;
        varinAlaraja = alaraja;
    }

    /**
     * Metodi muuttaa sinisen värin ylä- ja alarajaa.
     *
     * @see Varit.Varit
     * @param ce
     */
    @Override
    public void stateChanged(ChangeEvent ce) {
        alusta.muutaSinisenVarinRajoja(varinAlaraja.getValue(), varinYlaraja.getValue());
    }
}
