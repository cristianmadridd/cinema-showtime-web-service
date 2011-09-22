/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wspkg;

import java.util.HashMap;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Helio
 */
public class UtilTest {
    
    public UtilTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recuperarCodigoFonte method, of class Util.
     */
    @Test
    public void testRecuperarCodigoFonte() throws Exception {
        System.out.println("recuperarCodigoFonte");
        String urlstr = "http://www.google.com.br/movies?hl=pt-BR&near=maring%C3%A1";
        //String expResult = "";
        String result = Util.recuperarCodigoFonte(urlstr);
        System.out.println(result);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testParseURL() throws Exception {
        System.out.println("parseURL");
        String urlstr = "http://www.google.com.br/movies?hl=pt-BR&near=sao+paulo";
        //String expResult = "";
        ArrayList<HashMap> result = Util.parseURL(urlstr);
        System.out.println(result);
        System.out.println("nº de cinemas = "+result.size());
        for (HashMap cinema: result){
            System.out.println("nome do cinema = "+cinema.get("name"));
            System.out.println("\tnº de filmes = "+((ArrayList)cinema.get("movie list")).size());
        }
        System.out.println("n");
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    
}
