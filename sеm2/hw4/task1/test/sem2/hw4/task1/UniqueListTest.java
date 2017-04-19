package sem2.hw4.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/** Test class for Unique List*/
public class UniqueListTest {
    /** size of array */
    private int arraySize = 100;

    Random r = new Random();

    /** tests without any exceptions which checks that list is empty after deleting all added elements*/
    @Test
    public void testForIntegersWithoutException() {
        List<Integer> list = new UniqueList<>();
        for (int i = 0; i < arraySize; i++) {
            list.add(i);
        }

        for (int i = 0; i < arraySize; i++) {
            list.remove(i);
        }
        Assert.assertTrue(list.isEmpty());
    }

    /** tests that 'already exists exception' throwns if you add the same element twice */
    @Test (expected = UniqueList.AlreadyAddedException.class)
    public void testForIntegerWithAlreadyAddedException() {
        List<Integer> list = new UniqueList<>();
        for (int i = 0; i < arraySize; i++) {
            list.add(r.nextInt(arraySize - 1));
        }
    }

    /** tests that 'no such element exception' throwns if you delete non-existing element' */
    @Test (expected = UniqueList.NoSuchElementException.class)
    public void testForIntegerWithNoSuchElementException() {
        List<Integer> list = new UniqueList<>();
        for (int i = 0; i < arraySize; i++) {
            list.add(i);
        }
        list.remove(r.nextInt() + arraySize);
    }

    /** tests unique list for strings, checks that list is empty after deleting all that was added*/
    @Test
    public void testForStrings() {
        List<String> list = new UniqueList<>();
        String arrayWithStrings[] = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arrayWithStrings[i] = String.valueOf((char)('a' + i));
            for (int j = 0; j < r.nextInt(10) + 1; j++) {
                arrayWithStrings[i] = arrayWithStrings[i] + (char)(r.nextInt(26) + 'a');
            }
        }
        for (int i = 0; i < arraySize; i++) {
            list.add(arrayWithStrings[i]);
        }
        for (int i = 0; i < arraySize; i++) {
            list.remove(arrayWithStrings[i]);
        }
        Assert.assertTrue(list.isEmpty());
    }
}