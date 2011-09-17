/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wspkg;

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
public class CinemaWebServiceTest {
    
    public CinemaWebServiceTest() {
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
     * Test of hello method, of class CinemaWebService.
     */
    @Test
    public void testHello() {
        System.out.println("hello");
        String txt = "";
        CinemaWebService instance = new CinemaWebService();
        String expResult = "";
        String result = instance.hello(txt);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorHorario method, of class CinemaWebService.
     */
    @Test
    public void testBuscarPorHorario() {
        System.out.println("buscarPorHorario");
        String cidade = "";
        String horario = "";
        CinemaWebService instance = new CinemaWebService();
        ArrayList expResult = null;
        ArrayList result = instance.buscarPorHorario(cidade, horario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
