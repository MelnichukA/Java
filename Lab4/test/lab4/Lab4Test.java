/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1710512
 */
public class Lab4Test {
    
    public Lab4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class Lab4.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Lab4.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of shuffleArray method, of class Lab4.
     */
    @Test
    public void testShuffleArray() {
        int[] a = { 1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };
        int[] b = {1, 2, 3, 4, 5, 6, 16, 15, 14, 13, 12, 11 };
        Lab4.shuffleArray(a);
        assertArrayEquals(b,a); //if arrays not equals and test is failed, it is success 
    }
    
}
