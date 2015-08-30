/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KuvanTallentaja;

import Fraktaalinpiirturi.Fraktaalinpiirturi;
import java.awt.GridLayout;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Luokka vastaa fraktaalikuvan tallentamisesta työpöydälle.
 *
 * @author Ivan
 */
public class KuvanTallentaja {

    /**
     * Taulukko resoluutioista kuvan tallentamista varten.
     */
    private JComboBox<String> resoluutiot = new JComboBox();

    /**
     * Metodi hakee parametrina annetusta piirturista nykyisen kuvan, ja
     * tallentaa sen työpöydälle.
     *
     * @param piirturi
     */
    public void tallennaKuva(Fraktaalinpiirturi piirturi) {
        int valinta = JOptionPane.showConfirmDialog(null, luoValikkoResoluutiolle(), "Save", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (valinta == JOptionPane.OK_OPTION) {
            try {
                File tiedosto = tiedosto();
                int[] resoluutiotTaulukko = palautaResoluutiot(resoluutiot.getSelectedIndex());
                ImageIO.write(piirturi.palautaFraktaali(resoluutiotTaulukko[0], resoluutiotTaulukko[1]), "png", tiedosto);
                JOptionPane.showMessageDialog(null, "Image saved to Desktop!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "An error occured!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Metodi palauttaa tiedoston, johon kuva tallennetaan.
     *
     * @return
     */
    private File tiedosto() {
        File tiedosto = new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Fractal.png");
        if (tiedosto.exists()) {
            for (int i = 1; i < 1000; i++) {
                String tiedostopolku = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "Fractal" + i + ".png";
                tiedosto = new File(tiedostopolku);
                if (!tiedosto.exists()) {
                    return tiedosto;
                }
            }
            return tiedosto;
        }
        return tiedosto;
    }

    /**
     * Metodi alustaa eri resoluutiot oliomuuttujaan resoluutiot.
     *
     * @return
     */
    private void alustaResoluutiot() {
        resoluutiot.addItem("640x480");
        resoluutiot.addItem("720x400");
        resoluutiot.addItem("1360x786");
        resoluutiot.addItem("1280x800");
        resoluutiot.addItem("1280x1024");
        resoluutiot.addItem("1600x900");
        resoluutiot.addItem("1600x1200");
        resoluutiot.addItem("1920x1080");
    }

    /**
     * Metodi palauttaa kaksipaikkaisen taulukon, josta poimitaan resoluutiot
     * fraktaalikuvion piirtoon.
     *
     * @param paikka
     * @return
     */
    private int[] palautaResoluutiot(int paikka) {
        if (paikka == 0) {
            int[] palautettava = {640, 480};
            return palautettava;
        } else if (paikka == 1) {
            int[] palautettava = {720, 400};
            return palautettava;
        } else if (paikka == 2) {
            int[] palautettava = {1360, 786};
            return palautettava;
        } else if (paikka == 3) {
            int[] palautettava = {1280, 800};
            return palautettava;
        } else if (paikka == 4) {
            int[] palautettava = {1280, 1024};
            return palautettava;
        } else if (paikka == 5) {
            int[] palautettava = {1600, 900};
            return palautettava;
        } else if (paikka == 6) {
            int[] palautettava = {1600, 1200};
            return palautettava;
        }
        int[] palautettava = {1920, 1080};
        return palautettava;
    }

    /**
     * Metodi palauttaa JPanelin, joka toimii valikkona resoluution
     * valitsemiselle.
     *
     * @return
     */
    private JPanel luoValikkoResoluutiolle() {
        JPanel valikko = new JPanel();
        valikko.setLayout(new GridLayout(2, 1));
        valikko.add(new JLabel("Choose resolution:"));
        valikko.add(resoluutiot);
        alustaResoluutiot();
        return valikko;
    }
}
