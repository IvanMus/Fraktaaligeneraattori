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
 * Luokasta luodaan listeneri, jolla tarkkaaillaan RGB-värimallin vihreän värin
 * muutoksia.
 *
 * @see Nappaimisto.RGBrajojenSaataja
 * @author Ivan
 */
public class VihreanvarinListeneri implements ChangeListener {

    /**
     * JSlideri jolla säädetään vihreän värin ylärajaa.
     */
    private final JSlider varinYlaraja;
    /**
     * JSlideri jolla säädetään vihreän värin alarajaa.
     */
    private final JSlider varinAlaraja;
    /**
     * FraktaalinPiirtoalusta jota kauttaa muutokset välitetään.
     */
    private final FraktaalinPiirtoalusta alusta;

    public VihreanvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider alaraja, JSlider ylaraja) {
        this.alusta = alusta;
        varinYlaraja = ylaraja;
        varinAlaraja = alaraja;
    }

    /**
     * Metodi muuttaa vihreän värin ylä- ja alarajaa.
     *
     * @see Varit.Varit
     * @param ce
     */
    @Override
    public void stateChanged(ChangeEvent ce) {
        alusta.muutaVihreanVarinRajoja(varinAlaraja.getValue(), varinYlaraja.getValue());
    }
}
