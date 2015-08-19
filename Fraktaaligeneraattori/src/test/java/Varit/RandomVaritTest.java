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
        varit=new RandomVarit(100);
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
}
