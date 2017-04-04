package sem2.hw2.task1;

import org.junit.Assert;
import org.junit.Test;

/** Test class for Calculator */
public class CalculatorTest {
    /** Test calculator for expressions without brackets */
    @Test
    public void testWithoutBrackets() throws Throwable {
        String expression = "1 + 9 * 7 - 4 / 2 + 1";
        double expected = 63;
        double result = Calculator.calculate(expression);
        Assert.assertTrue(result == expected);
    }

    /** Test calculator for expressions with brackets */
    @Test
    public void testWithBrackets() throws Throwable {
        String expression = "(1 + 9) * (7 - 4) / 2 + 1";
        double expected = 16;
        double result = Calculator.calculate(expression);
        Assert.assertTrue(result == expected);
    }
}