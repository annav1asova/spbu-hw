package sem2.test1.task1;

/** Class for queue with priorities */
public class PriorityQueue<T> implements Queue<T> {
    private Element first = null;
    private int size = 0;

    /**
     * method that adds to the queue element, queue sorted by priorities.
     *
     * @param value element to be added in queue has this value
     * @param key element to be added in queue has this priority
     */
    public void enqueue(T value, int key) {
        if (isEmpty()) {
            first = new Element(value, key, null);
            size++;
            return;
        }

        if (first.key < key) {
            first = new Element(value, key, first);
            size++;
            return;
        }

        Element temp = first;
        while (temp.next != null && key < temp.next.key) {
            temp = temp.next;
        }
        temp.next = new Element(value, key, temp.next);
        size++;
    }

    /**
     * method that extracts element with max priority.
     *
     * @return value of deleted element
     * @throws EmptyQueueException if queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();

        Element temp = first;
        T value = temp.value;
        first = first.next;
        size--;
        return value;
    }

    /**
     * method that checks whether the queue is empty.
     *
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * method that returns field 'size'.
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /** class for creating new element */
    private class Element {
        private T value;
        private int key;
        private Element next;

        private Element(T value, int key, Element next) {
            this.value = value;
            this.key = key;
            this.next = next;
        }
    }

    /** Constructs a new 'empty queue' exception */
    public static class EmptyQueueException extends RuntimeException {
        public EmptyQueueException() {
            super("priority queue is empty, you can't  remove element");
        }
    }
}
