/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Iteraattorit;

import Kompleksiluku.Kompleksiluku;
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
public class MandelbrotIteraattoriTest {
    
    MandelbrotIteraattori iteraattori;
    
    public MandelbrotIteraattoriTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        iteraattori = new MandelbrotIteraattori();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    @Test
    public void palauttaaOikeanIteraatioMaaranKunAlleIteraatiorajan() {
        assertEquals(1, iteraattori.iteroi(new Kompleksiluku(3, 0), 10, 2));
        assertEquals(2, iteraattori.iteroi(new Kompleksiluku(1.5, 0), 10, 3));
    }
    
    @Test
    public void palauttaaOikenaIteraatioMaaranKunTasanIteraatioraja() {
        assertEquals(100, iteraattori.iteroi(new Kompleksiluku(0, 0), 100, 3));
    }
    
    @Test
    public void OikeaIteraatioMaaraKunPotenssiNegatiivinenJaEiKaanteislukua() {
        assertEquals(1, iteraattori.iteroi(new Kompleksiluku(0, 0), 100, -3));
    }
    
    @Test
    public void IteraattorinNimiOikein() {
        assertEquals("Mandelbrot", iteraattori.toString());
    }
}
