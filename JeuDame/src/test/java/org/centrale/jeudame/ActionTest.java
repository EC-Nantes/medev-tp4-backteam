/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.centrale.jeudame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author yaelv
 */
public class ActionTest {
    
    public ActionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of deplacer method, of class Action.
     */
    @Test
    public void testDeplacer() {
        System.out.println("deplacer");
        Plateau plateau = null;
        Action instance = new ActionImpl();
        boolean expResult = false;
        boolean result = instance.deplacer(plateau);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prendre method, of class Action.
     */
    @Test
    public void testPrendre() {
        System.out.println("prendre");
        Plateau plateau = null;
        Action instance = new ActionImpl();
        boolean expResult = false;
        boolean result = instance.prendre(plateau);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prise method, of class Action.
     */
    @Test
    public void testPrise() {
        System.out.println("prise");
        Plateau plateau = null;
        Piece p = null;
        int newX = 0;
        int newY = 0;
        Action instance = new ActionImpl();
        instance.prise(plateau, p, newX, newY);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ActionImpl implements Action {

        public boolean deplacer(Plateau plateau) {
            return false;
        }

        public boolean prendre(Plateau plateau) {
            return false;
        }

        public void prise(Plateau plateau, Piece p, int newX, int newY) {
        }
    }
    
}
