package org.example;

import java.util.Objects;

public final class Complex implements Comparable<Complex> {
    private final double realPart;
    private final double imaginaryPart;
    private final double modulus;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
        this.modulus = findModulus(realPart, imaginaryPart);
    }

    public static Complex add(Complex firstNumber, Complex secondNumber) {
        return new Complex(firstNumber.getRealPart() + secondNumber.getRealPart(),
                firstNumber.getImaginaryPart() + secondNumber.getImaginaryPart());
    }

    public static Complex subtract(Complex firstNumber, Complex secondNumber) {
        return new Complex(firstNumber.getRealPart() - secondNumber.getRealPart(),
                firstNumber.getImaginaryPart() - secondNumber.getImaginaryPart());
    }

    public static Complex multiply(Complex firstNumber, Complex secondNumber) {
        double newRealPart = firstNumber.getRealPart() * secondNumber.getRealPart() -
                firstNumber.getImaginaryPart() * secondNumber.getImaginaryPart();
        double newImaginaryPart = firstNumber.getRealPart() * secondNumber.getImaginaryPart() +
                firstNumber.getImaginaryPart() * secondNumber.getRealPart();
        return new Complex(newRealPart, newImaginaryPart);
    }

    public static Complex multiply(Complex firstNumber, double secondNumber) {
        return multiply(firstNumber, new Complex(secondNumber, 0));
    }

    public static Complex multiply(double firstNumber, Complex secondNumber) {
        return multiply(secondNumber, firstNumber);
    }

    public static Complex divide(Complex firstNumber, Complex secondNumber) {
        double denominator = Math.pow(secondNumber.getModulus(), 2);
        if (denominator == 0)
            throw new ArithmeticException("Division by zero");
        double newRealPart = (firstNumber.getRealPart() * secondNumber.getRealPart() +
                firstNumber.getImaginaryPart() * secondNumber.getImaginaryPart())/denominator;
        double newImaginaryPart = (firstNumber.getImaginaryPart() * secondNumber.getRealPart() -
                firstNumber.getRealPart() * secondNumber.getImaginaryPart())/denominator;
        return new Complex(newRealPart, newImaginaryPart);
    }

    public static Complex divide(Complex firstNumber, double secondNumber) {
        return divide(firstNumber, new Complex(secondNumber, 0));
    }

    public static Complex divide(double firstNumber, Complex secondNumber) {
        return divide(secondNumber, firstNumber);
    }

    private static double findModulus(double realPart, double imaginaryPart) {
        return Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2));
    }

    public double getRealPart() {
        return realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public double getModulus() {
        return modulus;
    }

    @Override
    public int compareTo(Complex o) {
        return Double.compare(this.modulus, o.getModulus());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Complex)) return false;
        Complex complex = (Complex) o;
        return Double.compare(complex.realPart, realPart) == 0
                && Double.compare(complex.imaginaryPart, imaginaryPart) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart + "i";
    }
}
