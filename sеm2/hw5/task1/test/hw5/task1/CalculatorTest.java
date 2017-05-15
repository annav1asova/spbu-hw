package hw5.task1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/** Test class for Calculator */
public class CalculatorTest {
    private int firstValue;
    private int secondValue;

    Random r = new Random();

    Calculator calculator = new Calculator();

    @Before
    public void initialize() {
        firstValue = r.nextInt(calculator.getMax() - calculator.getMin()) + calculator.getMin();
        secondValue = r.nextInt(calculator.getMax() - calculator.getMin()) + calculator.getMin();
    }

    /** tests operation '+' */
    @Test
    public void testAdding() {
        double result = calculator.count(firstValue, secondValue, '+');
        double expected = firstValue + secondValue;
        Assert.assertTrue(result == expected);
    }

    /** tests operation '*' */
    @Test
    public void testMultiplying() {
        double result = calculator.count(firstValue, secondValue, '*');
        double expected = firstValue * secondValue;
        Assert.assertTrue(result == expected);
    }

    /** tests operation '-' */
    @Test
    public void testSubtracting() {
        double result = calculator.count(firstValue, secondValue, '-');
        double expected = firstValue - secondValue;
        Assert.assertTrue(result == expected);
    }

    /** tests operation '/' */
    @Test
    public void testDividing() {
        double result = calculator.count(firstValue, secondValue, '/');
        double expected = firstValue / secondValue;
        Assert.assertTrue(result == expected);
    }
}