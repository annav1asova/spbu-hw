package sem2.test1.task1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/** Test class for Unique List */
public class PriorityQueueTest {
    /** size of array */
    private int arraySize = 100;

    Random r = new Random();

    /** test without any exceptions which checks that queue is empty after deleting all added elements */
    @Test
    public void testForEmptinessWithoutException() {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arraySize; i++) {
            queue.enqueue(r.nextInt(), r.nextInt());
        }

        for (int i = 0; i < arraySize; i++) {
            queue.dequeue();
        }
        Assert.assertTrue(queue.isEmpty());
    }

    /** tests that size works correctly */
    @Test
    public void testForIntegersWithoutException() {
        Queue<Integer> queue = new PriorityQueue<>();
        int sizeOfDeleted = r.nextInt(arraySize);
        for (int i = 0; i < arraySize; i++) {
            queue.enqueue(r.nextInt(), r.nextInt());
        }

        for (int i = 0; i < arraySize - sizeOfDeleted; i++) {
            queue.dequeue();
        }
        Assert.assertTrue(queue.size() == sizeOfDeleted);
    }

    /** tests that 'empty queue exception' throws if you are trying to delete element from empty queue */
    @Test (expected = PriorityQueue.EmptyQueueException.class)
    public void testForIntegerWithEmptyQueueException() {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arraySize; i++) {
            queue.enqueue(r.nextInt(), r.nextInt());
        }
        for (int i = 0; i < arraySize; i++) {
            queue.dequeue();
        }
        queue.dequeue();
    }

    /** tests that queue works for chars */
    @Test
    public void testForCharsWithoutException() {
        Queue<Character> queue = new PriorityQueue<>();
        for (int i = 0; i < arraySize; i++) {
            queue.enqueue((char)(r.nextInt(26) + 'a'), r.nextInt(arraySize));
        }

        char expected = (char)(r.nextInt(26) + 'a');
        queue.enqueue(expected, arraySize + 1);
        char removed = queue.dequeue();

        for (int i = 0; i < arraySize; i++) {
            queue.dequeue();
        }
        Assert.assertTrue(queue.isEmpty() && expected == removed);
    }
}