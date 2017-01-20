package ua.litovka.lection2.junit;

import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {

    @Test
    public void testSum() throws Exception {
        int expected = 2 + 5;
        int real = new Calculator().sum(2, 5);
        assertEquals("Error in sum", expected, real);


    }


    @Test
    public void testDivide() throws Exception {
        int expected =  2 /  5;
        int real = new Calculator().divide(2, 5);
        assertEquals("Error in divide", expected, real);
    }

    @Test(expected = ArithmeticException.class)
    public void testDividException() throws Exception {
        int expected =  2 /  0;
        int real = new Calculator().divide(2, 0);
        assertEquals("Error in divide", expected, real);
    }


}