package ClasseInverseeTest.Demo;

// approche glassbox
// Suite non complète ayant pour but de montrer le formalisme

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import Exceptions.*;
import TP3.Q1.Methods;

class NumClassTest {

    public static final int [] ORDERED_TAB = {1,2,3,4};
    public static final int [] NOT_ORDERED_TAB = {4,2,1,3};
    public static final int [] SAME_VALUE_TAB = {1,1,1,1};


	/*
	// JUnit 4
	// Si nécessaire
	@Before
	public void setUp() {
	}

	// JUnit 4
	// Si nécessaire
	@After
	public void tearDown() {
	}
	*/

    // JUnit 5
    // Si nécessaire
    @BeforeAll
    public static void setUp() {
    }

    // JUnit 5
    // Si nécessaire
    @AfterAll
    public static void tearDown() {
    }


    @Test
    public void testSum(){
        // Set up
        // Exercise
        // Verify
        assertEquals(10, Methods.sum(ORDERED_TAB));
        // Teardown

    }


    @Test
    public void testGreatestNormal()  {
        // Set up
        // Exercise
        // Verify
        assertEquals(4, Methods.greatest(NOT_ORDERED_TAB));
        // Teardown
    }

    @Test
    public void testGreatestSameValue()  {
        // Set up
        // Exercise
        // Verify
        assertEquals(1, Methods.greatest(SAME_VALUE_TAB));
        // Teardown
    }

    @Test
    public void testIsEvenTrue()  {
        // Set up
        // Exercise
        // Verify
        assertEquals(true, Methods.isEven(2));
        // Teardown
    }

    @Test
    public void testIsEvenFalse()  {
        // Set up
        // Exercise
        // Verify
        assertEquals(false, Methods.isEven(3));
        // Teardown
    }

    @Test
    public void testPgcdNormal() {
        // Set up
        // Exercise
        // Verify
        try {
            assertEquals(107,Methods.pgcd(749, 642));
        } catch (NegativeArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Teardown
    }

    @Test
    public void testPgcdDividedByZero() {
        // Set up
        // Exercise
        // Verify

        try {
            assertEquals(10,Methods.pgcd(10, 0));
        } catch (NegativeArgumentException e) {

        }
        // on test la division par 0 aka d==0
        // Teardown

    }

    // JUnit 5
    // Pour JUnit4 voir exemple dans PolyClassTest
    @Test
    public void testPGCDNegativeArgumentException() {
        // Set up
        // Exercise
        // Verify
        Assertions.assertThrows(NegativeArgumentException.class, () -> Methods.pgcd(10, -10));
        Assertions.assertThrows(NegativeArgumentException.class, () -> Methods.pgcd(-10, 10));
        Assertions.assertThrows(NegativeArgumentException.class, () -> Methods.pgcd(-10, -10));
        // Teardown
    }

}
