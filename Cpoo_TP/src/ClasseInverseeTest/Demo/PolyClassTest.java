package ClasseInverseeTest.Demo;

// blackbox

// Suite non complète ayant pour but de montrer le formalisme

import static org.junit.jupiter.api.Assertions.*;

import TP4.Poly.Poly;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Exceptions.NegativeExponentException;

class PolyClassTest {

    private static final int SOME_COEFF = 2;
    private static final int NEGATIVE_EXPONENT = -2;

    private Poly myPoly;
    private Poly myPoly2x2;


    // /!\ JUnit 5 !!!
    @BeforeEach
    public void setUp() throws NegativeExponentException {
        myPoly= new Poly();
        myPoly2x2 = new Poly(2,2);
    }

    @Test
    public void testDegree() throws NegativeExponentException {
        // setup
        Poly myPolyx = new Poly(2,1);
        // exercice
        // verify
        assertEquals(1,myPolyx.degree());
        // teardown
    }


    @Test
    public void testCoeff() throws NegativeExponentException {
        // setup
        Poly myPolyx = new Poly(2,1);
        //exercice
        // verify
        assertEquals(2,myPolyx.coeff(1));
        //teardown
    }

    @Test
    public void testAdd() throws NegativeExponentException {
        // setup
        try {
            //exercices
            myPoly = myPoly.add(new Poly(2,2));
            System.out.println("Verified and exerced !");
            //verify
            assertEquals(true, myPoly.equals(myPoly2x2));
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception !");
        } catch (NegativeExponentException e) {
            System.out.println("Negative exponent exception  !");
        }
    }

	/*
	 *
	// JUnit 4
	@Test(expected=NegativeExponentException.class)
	public void testAdd_Negative() {
		// Exercise & Verify
		new Poly(SOME_COEFF, NEGATIVE_EXPONENT);
	}
	*/

    // Junit 5
    @Test
    public void testAdd_Negative() {
        // Exercise & Verify
        Assertions.assertThrows(NegativeExponentException.class, () -> new Poly(SOME_COEFF, NEGATIVE_EXPONENT));
    }


    @Test
    public void templateTest() {
        // Set up
        // Exercise
        // Verify
        // Teardown
    }

}
