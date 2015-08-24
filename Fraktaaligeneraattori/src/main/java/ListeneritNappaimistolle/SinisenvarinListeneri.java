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
 *
 * @author Ivan
 */
public class SinisenvarinListeneri implements ChangeListener{
    
    private final JSlider varinYlaraja;
    private final JSlider varinAlaraja;
    private final FraktaalinPiirtoalusta alusta;

    public SinisenvarinListeneri(FraktaalinPiirtoalusta alusta, JSlider alaraja, JSlider ylaraja) {
        this.alusta = alusta;
        varinYlaraja = ylaraja;
        varinAlaraja = alaraja;
    }

    @Override
    public void stateChanged(ChangeEvent ce) {
        alusta.muutaSinisenVarinRajoja(varinAlaraja.getValue(), varinYlaraja.getValue());
    }
}
