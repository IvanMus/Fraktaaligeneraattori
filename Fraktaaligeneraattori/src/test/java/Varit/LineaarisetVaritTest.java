/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Varit;

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
public class LineaarisetVaritTest {
    
    Varit varit;
    
    public LineaarisetVaritTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        varit=new LineaarisetVarit(100);
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
    }
}
