/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivan
 */
public class RandomVaritTest {

    Varit varit;

    public RandomVaritTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        varit = new RandomVarit(100);
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:

    @Test
    public void taulukonAlustusToimiiEliAlussaJaLopussaVari() {
        assertNotNull(varit.haeVari(0));
        assertNotNull(varit.haeVari(100));
    }

    @Test
    public void varienMaaranMuuttaminenToimii() {
        varit.muutaVarienMaara(200);
        assertNotNull(varit.haeVari(0));
        assertNotNull(varit.haeVari(200));
        assertEquals(201, varit.haeVarienMaara());
    }

    @Test
    public void varienMaaraOikein() {
        assertEquals(101, varit.haeVarienMaara());
    }

    @Test
    public void VaritaulukonNimiOikein() {
        assertEquals("Random Colours", varit.toString());
    }

    @Test
    public void sinisenVariRajojenMuuttaminenToimiiSallittuna() {
        varit.muutaSinisenVarinRajoja(10, 20);
        assertEquals(10, varit.sinisenVarinAlaraja);
        assertEquals(10, varit.sinisenVarinYlaraja);
    }

    @Test
    public void vihreanVariRajojenMuuttaminenToimiiSallittuna() {
        varit.muutaVihreanVarinRajoja(10, 20);
        assertEquals(10, varit.vihreanVarinAlaraja);
        assertEquals(10, varit.vihreanVarinYlaraja);
    }

    @Test
    public void punaisenVariRajojenMuuttaminenToimiiSallittuna() {
        varit.muutaPunaisenVarinRajoja(10, 20);
        assertEquals(10, varit.punaisenVarinAlaraja);
        assertEquals(10, varit.punaisenVarinYlaraja);
    }

    @Test
    public void sinisenVariRajojenMuuttaminenEiToimiKunVaaratParametrit() {
        varit.muutaSinisenVarinRajoja(20, 10);
        assertEquals(0, varit.sinisenVarinAlaraja);
        assertEquals(256, varit.sinisenVarinYlaraja);
    }

    @Test
    public void vihreanVariRajojenMuuttaminenEiToimiKunVaaratParametrit() {
        varit.muutaVihreanVarinRajoja(20, 10);
        assertEquals(0, varit.vihreanVarinAlaraja);
        assertEquals(256, varit.vihreanVarinYlaraja);
    }

    @Test
    public void punaisenVariRajojenMuuttaminenEiToimiKunVaaratParametrit() {
        varit.muutaPunaisenVarinRajoja(20, 10);
        assertEquals(0, varit.punaisenVarinAlaraja);
        assertEquals(256, varit.punaisenVarinYlaraja);
    }
    
    @Test
    public void varienAlustustaEiTapahduKunVarirajojaMuutetaan() {
        varit.muutaPunaisenVarinRajoja(10, 20);
        varit.alustaJosLineaarisetVaritVaativat();
        assertTrue(varit.vaatiikoLineaarisetVaritAlustusta);
    }
    
    @Test
    public void varirajojenAlustusUuteenVaritaulukkoonToimii() {
        LineaarisetVarit uudetVarit = new LineaarisetVarit(-1);
        varit.muutaPunaisenVarinRajoja(10, 20);
        varit.muutaSinisenVarinRajoja(10, 20);
        varit.muutaVihreanVarinRajoja(10, 20);
        varit.alustaUuteenTaulukkoonVanhanRGBrajat(uudetVarit);
        assertEquals(10, uudetVarit.punaisenVarinAlaraja);
        assertEquals(10, uudetVarit.sinisenVarinAlaraja);
        assertEquals(10, uudetVarit.vihreanVarinAlaraja);
        assertEquals(10, uudetVarit.punaisenVarinYlaraja);
        assertEquals(10, uudetVarit.sinisenVarinYlaraja);
        assertEquals(10, uudetVarit.vihreanVarinYlaraja);
    }
}
