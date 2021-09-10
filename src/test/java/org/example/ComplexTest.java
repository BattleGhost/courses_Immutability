package org.example;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexTest {
    private static Complex firstNumber;
    private static Complex secondNumber;
    public static final double DELTA = 1e-9;

    @BeforeClass
    public static void createNumbers() {
        firstNumber = new Complex(3, 4);
        secondNumber = new Complex(2, 5);
    }

    @Test
    public void numbersWithSameRealAndImaginaryShouldBeEqual() {
        Complex sameNumber = new Complex(firstNumber.getRealPart(), firstNumber.getImaginaryPart());
        assertEquals(firstNumber, sameNumber);
    }

    @Test
    public void addShouldWorkCorrect() {
        /*
            (3 + 4i) + (2 + 5i) = 5 + 9i
        */
        Complex additionResult = Complex.add(firstNumber, secondNumber);
        assertEquals(5, additionResult.getRealPart(), DELTA);
        assertEquals(9, additionResult.getImaginaryPart(), DELTA);
    }

    @Test
    public void subtractShouldWorkCorrect() {
        /*
            (3 + 4i) - (2 + 5i) = 1 - i
        */
        Complex additionResult = Complex.subtract(firstNumber, secondNumber);
        assertEquals(1, additionResult.getRealPart(), DELTA);
        assertEquals(-1, additionResult.getImaginaryPart(), DELTA);
    }

    @Test
    public void multiplyShouldWorkCorrect() {
        /*
            (3 + 4i) * (2 + 5i) = -14 + 23i
        */
        Complex additionResult = Complex.multiply(firstNumber, secondNumber);
        assertEquals(-14, additionResult.getRealPart(), DELTA);
        assertEquals(23, additionResult.getImaginaryPart(), DELTA);
    }

    @Test
    public void divideShouldWorkCorrect() {
        /*
            (3 + 4i) / (2 + 5i) = 26/29 - 7i/29
        */
        Complex additionResult = Complex.divide(firstNumber, secondNumber);
        assertEquals(((double) 26)/29, additionResult.getRealPart(), DELTA);
        assertEquals(((double) -7)/29, additionResult.getImaginaryPart(), DELTA);
    }

    @Test(expected = ArithmeticException.class)
    public void divideShouldThrowZeroDivisionException() {
        /*
            (3 + 4i) / 0 => ArithmeticException
        */
        Complex.divide(firstNumber, 0);
    }
}