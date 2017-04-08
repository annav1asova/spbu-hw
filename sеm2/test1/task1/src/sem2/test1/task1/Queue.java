package sem2.test1.task1;

/** Interface for queue with priority */
public interface Queue<T> {
    /** add an element to the queue */
    void enqueue(T value, int key);

    /** removes an element from queue (with max priority) */
    T dequeue();

    /** checks emptiness of queue */
    boolean isEmpty();

    /** returns size of queue */
    int size();
}
