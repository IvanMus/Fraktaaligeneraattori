/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fraktaalinpiirturi;

import java.awt.image.BufferedImage;
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
public class FraktaalinpiirturiTest {
    
    Fraktaalinpiirturi piirturi;
    
    public FraktaalinpiirturiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        piirturi = new Fraktaalinpiirturi();
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    @Test
    public void kuvanPalauttaminenToimii() {
        assertEquals(new BufferedImage(1, 1, 1).getClass(), piirturi.piirraFraktaali(1, 1).getClass());
    }
    
    @Test
    public void zoomaaminenToimii() {
        piirturi.lisaaZoom(0, 0, 10, 10);
        assertEquals(1, piirturi.getZoomauskerroin());
    }
    
    @Test
    public void kuvanLoitontaminenToimii() {
        piirturi.vahennaZoom(0, 0, 10, 10);
        assertEquals(-1, piirturi.getZoomauskerroin());
    }
    
    @Test
    public void zoomausKerroinOikein() {
        assertEquals(0, piirturi.getZoomauskerroin());
    }
}
