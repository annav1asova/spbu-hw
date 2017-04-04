package sem2.hw3.task1;

import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

/** Test class for Sorter */
public class SorterTest {
    /** size of array */
    private int arraySize = 1000;

    /**
     * generates array filled with random value.
     *
     * @param size length of array with random values
     * @return generated array
     */
    private int[] generateRandomArray(int size) {
        Random r = new Random();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    /** Test Quick Sort on random array */
    @Test
    public void testingQuickSort() {
        Sorter testing = new QuickSorter();
        int testArray[] = generateRandomArray(arraySize);
        testing.sort(testArray);
        for (int i = 0; i < arraySize - 1; i++)
            Assert.assertTrue(testArray[i] < testArray[i + 1]);
    }

    /** Test Bubble Sort on random array */
    @Test
    public void testingBubbleSort() {
        Sorter testing = new BubbleSorter();
        int testArray[] = generateRandomArray(arraySize);
        testing.sort(testArray);
        for (int i = 0; i < arraySize - 1; i++)
            Assert.assertTrue(testArray[i] < testArray[i + 1]);
    }
}
