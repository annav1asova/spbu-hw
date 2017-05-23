package sem2.hw7.task2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/** Tests for stateOfGame class */
public class StateOfGameTest {

    /** tests that if row is filled then game is finished */
    @Test
    public void testFilledRow() {
        ArrayList<Integer> filledList = new ArrayList<Integer>(Arrays.asList(4, 3, 5, 6, 1));
        Assert.assertTrue(StateOfGame.isTheGameFinished(filledList));
    }

    /** tests that if column is filled then game is finished */
    @Test
    public void testFilledColumn() {
        ArrayList<Integer> filledList = new ArrayList<Integer>(Arrays.asList(6, 8, 9, 3));
        Assert.assertTrue(StateOfGame.isTheGameFinished(filledList));
    }

    /** tests that if diagonal is filled then game is finished */
    @Test
    public void testFilledDiagonal() {
        ArrayList<Integer> filledList = new ArrayList<Integer>(Arrays.asList(5, 1, 9, 8));
        Assert.assertTrue(StateOfGame.isTheGameFinished(filledList));
    }

    /** tests that there isn't any filled column, row or diagonal, then game is not finished */
    @Test
    public void testUnfinishedGame() {
        ArrayList<Integer> filledList = new ArrayList<Integer>(Arrays.asList(5, 2, 6, 9, 7));
        Assert.assertTrue(!StateOfGame.isTheGameFinished(filledList));
    }
}