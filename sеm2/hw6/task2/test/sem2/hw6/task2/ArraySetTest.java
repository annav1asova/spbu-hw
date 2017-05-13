package sem2.hw6.task2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/** Tests for ArraySet */
public class ArraySetTest {
    private int arraySize = 100;
    private int testArray[] = new int[arraySize];
    ArraySet<Integer> set;
    Random r = new Random();

    @Before
    public void initialize() {
        set = new ArraySet<Integer>();
    }

    /** tests work of function 'size' */
    @Test
    public void testSize() {
        for (int i = 0; i < arraySize; i++) {
            set.add(i);
        }
        Assert.assertTrue(set.size() == arraySize);
    }

    /** tests work of function 'isEmpty' */
    @Test
    public void testIsEmpty() {
        for (int i = 0; i < arraySize; i++) {
            set.add(i);
        }
        for (int i = 0; i < arraySize; i++) {
            set.remove(i);
        }
        Assert.assertTrue(set.isEmpty());
    }

    /** tests work of function 'contains' */
    @Test
    public void testContains() {
        for (int i = 0; i < arraySize; i++) {
            int nextRandomNumber = r.nextInt();
            set.add(nextRandomNumber);
            testArray[i] = nextRandomNumber;
        }

        for (int i = 0; i < arraySize; i++)
            Assert.assertTrue(set.contains(testArray[i]));
    }

    /** tests work of function 'iterator' */
    @Test
    public void testIterator() {
        set.add(16);
        set.add(8);
        set.add(292);
        set.add(22);

        Iterator iterator = set.iterator();
        while(iterator.hasNext())
            Assert.assertTrue(set.contains(iterator.next()));
    }

    /** tests work of function 'toArray' */
    @Test
    public void testToArray() {
        for (int i = 0; i < arraySize; i++) {
            int nextRandomNumber = r.nextInt();
            set.add(nextRandomNumber);
            testArray[i] = nextRandomNumber;
        }

        Object[] resultArray = set.toArray();

        for (int i = 0; i < resultArray.length; i++) {
            Assert.assertTrue(set.contains(resultArray[i]));
        }
    }

    /** tests work of functions 'add' and 'remove' */
    @Test
    public void testAddAndRemove() {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            int nextRandomNumber = r.nextInt();
            set.add(nextRandomNumber);
            testList.add(nextRandomNumber);
        }

        Assert.assertTrue(set.size() <= arraySize);

        Iterator iterator = testList.iterator();

        while(iterator.hasNext()) {
            set.remove(iterator.next());
        }

        Assert.assertTrue(set.isEmpty());
    }

    /** tests work of function 'containsAll' */
    @Test
    public void testContainsAll() {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            int nextRandomNumber = r.nextInt();
            set.add(nextRandomNumber);
            testList.add(nextRandomNumber);
        }

        Assert.assertTrue(set.containsAll(testList));
    }

    /** tests work of function 'addAll' */
    @Test
    public void testAddAll() {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            testList.add(r.nextInt());
        }

        set.add(r.nextInt());
        set.addAll(testList);
        Assert.assertTrue(set.containsAll(testList));
    }

    /** tests work of function 'retainAll' */
    @Test
    public void testRetainAll() {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            testList.add(r.nextInt() + 10);
        }

        set.add(2);
        set.addAll(testList);
        set.add(6);
        set.retainAll(testList);
        Assert.assertTrue(set.containsAll(testList));
        Assert.assertTrue(!set.contains(2));
        Assert.assertTrue(!set.contains(6));
    }

    /** tests work of function 'removeAll' */
    @Test
    public void testRemoveAll() {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            testList.add(r.nextInt());
        }

        set.addAll(testList);
        set.removeAll(testList);
        for (Integer value: testList) {
            Assert.assertTrue(!set.contains(value));
        }
    }

    /** tests work of function 'clear' */
    @Test
    public void testClear() {
        ArrayList<Integer> testList = new ArrayList<>();
        for (int i = 0; i < arraySize; i++) {
            testList.add(r.nextInt());
        }

        set.addAll(testList);
        set.clear();

        Assert.assertTrue(set.isEmpty());
    }
}