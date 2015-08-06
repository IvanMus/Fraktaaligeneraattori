/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kompleksiluku;

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
public class KompleksilukuTest {
    
    Kompleksiluku luku;
    
    public KompleksilukuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        luku=new Kompleksiluku(1,2);
    }
    
    @After
    public void tearDown() {
    }
//     TODO add test methods here.
//     The methods must be annotated with annotation @Test. For example:   
     
     @Test
     public void luvunEtaisyysOrigostaOikein() {
        assertEquals(5.0 , luku.pituusToiseen(), 0.0001);
     }
     
     @Test
     public void getteriXKoordinaatilleToimii() {
         assertEquals(1, luku.getXKoordinaatti(), 0);
     }
     
     @Test
     public void getteriYKoordinaatilleToimii() {
         assertEquals(2, luku.getYKoordinaatti(), 0);
     }
     
     @Test
     public void kaanteislukuOikein() {
         Kompleksiluku kaanteisluku=luku.kaanteisluku();
         assertEquals(0.2, kaanteisluku.getXKoordinaatti(), 0.0001);      
         assertEquals(-0.4, kaanteisluku.getYKoordinaatti(), 0.0001);
     }
     
     @Test
     public void summaOikein() {
         Kompleksiluku summa=luku.summa(new Kompleksiluku(1,1));
         assertEquals(2, summa.getXKoordinaatti(), 0.0001); 
         assertEquals(3, summa.getYKoordinaatti(), 0.0001); 
     }
     
     @Test
     public void tuloOikein() {
         Kompleksiluku tulo=luku.tulo(new Kompleksiluku(0.2, -0.4));
         assertEquals(1, tulo.getXKoordinaatti(), 0.0001);
         assertEquals(0, tulo.getYKoordinaatti(), 0.0001);
     }
     
     @Test
     public void positiivinenPotenssiinKorotusToimii() {
         Kompleksiluku potenssiinKolme=luku.potenssi(3);
         assertEquals(-11, potenssiinKolme.getXKoordinaatti(), 0.0001);
         assertEquals(-2, potenssiinKolme.getYKoordinaatti(), 0.0001);
     }
     
     @Test
     public void negatiivinenPotenssiinKorotusToimii() {
         Kompleksiluku potenssiinMiinusKaksi=luku.potenssi(-2);
         assertEquals(-0.12, potenssiinMiinusKaksi.getXKoordinaatti(), 0.0001);
         assertEquals(-0.16, potenssiinMiinusKaksi.getYKoordinaatti(), 0.0001);
     }
     
     @Test
     public void nollanteenPotenssiinKorotusToimii() {
         Kompleksiluku nollasPotenssi=luku.potenssi(0);
         assertEquals(1, nollasPotenssi.getXKoordinaatti(), 0);
         assertEquals(0, nollasPotenssi.getYKoordinaatti(), 0);
     }
     
     @Test
     public void palauttaaNullinKunKaanteislukuMaarittamaton() {
         Kompleksiluku origo=new Kompleksiluku(0, 0);
         assertEquals(null, origo.kaanteisluku());
     }
}
