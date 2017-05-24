package sem2.hw8.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

/** Test-class for QuickSorter */
public class QuickSorterTest {
    /** size of array */
    int size = 8000000;
    /** array that will be sorted by threadedQuickSorter */
    int arrayThreaded[] = new int[size];
    /** array that will be sorted by nonThreadedQuickSorter */
    int arrayNonThreaded[] = new int[size];

    /** fills first and second arrays with the same random numbers */
    @Before
    public void initialization () {
        arrayNonThreaded = generateNewRandomArray(size);
        for (int i = 0; i < size; i++) {
            arrayThreaded[i] = arrayNonThreaded[i];
        }
    }

    /** fills array with the random numbers */
    private static int[] generateNewRandomArray(int size) {
        Random r = new Random();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt();
        }
        return array;
    }

    /** test working of threaded quick sort */
    @Test
    public void testThreaded() {
        long before = System.currentTimeMillis();
        new ForkJoinPool().invoke(new ThreadedQuickSort(size /
                (ThreadedQuickSort.MAX_THREADS), arrayThreaded, 0, arrayThreaded.length - 1));
        long after = System.currentTimeMillis();
        long secondTime = after - before;
        System.out.println("Threaded quickSort time: " + secondTime);
        for (int i = 0; i < size - 1; i++) {
            Assert.assertTrue(arrayThreaded[i] <= arrayThreaded[i + 1]);
        }
    }

    /** test working of non-threaded quick sort */
    @Test
    public void testNonThreaded(){
        long before1 = System.currentTimeMillis();
        QuickSorter nonThreadedQuickSorter = new NonThreadedQuickSort();
        nonThreadedQuickSorter.sort(arrayNonThreaded);
        long after1 = System.currentTimeMillis();
        long firstTime = after1 - before1;
        System.out.println("Non-threaded quickSort time: " + firstTime);
        for (int i = 0; i < size - 1; i++) {
            Assert.assertTrue(arrayNonThreaded[i] <= arrayNonThreaded[i + 1]);
        }
    }
}