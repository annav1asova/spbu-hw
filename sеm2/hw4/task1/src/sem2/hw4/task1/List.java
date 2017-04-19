package sem2.hw4.task1;

/** Interface for sorted list */
public interface List<T extends Comparable> {
    void add(T value);
    void remove(T value);
    boolean isEmpty();
    void showList();
}
