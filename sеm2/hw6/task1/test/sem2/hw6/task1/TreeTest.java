package sem2.hw6.task1;

import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Test class for Tree */
public class TreeTest {
    /** simple test */
    @Test
    public void firstTest() {
        String expression = "(* 2 2)";
        int expected = 4;
        Tree tree = new Tree();
        Operand resultTree = tree.parse(expression);
        int result = resultTree.calculate();
        Assert.assertTrue(result == expected);
    }

    /** a little bit more complicated test */
    @Test
    public void secondTest() {
        String expression = "(* (- (+ 1 1) 8) (/ 9 (* 1 (+ 3 0))))";
        int expected = -18;
        Tree tree = new Tree();
        Operand resultTree = tree.parse(expression);
        int result = resultTree.calculate();
        Assert.assertTrue(result == expected);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream prev = System.out;
        System.setOut(printStream);

        resultTree.print();

        System.setOut(prev);
        printStream.close();

        String resultExpression = byteArrayOutputStream.toString();
        Assert.assertTrue(resultExpression.equals(expression));
    }
}