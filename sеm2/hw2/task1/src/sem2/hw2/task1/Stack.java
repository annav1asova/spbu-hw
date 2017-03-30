package sem2.hw2.task1;

public interface Stack<Type> {
    void push(Type value);
    Type pop();
    Type peek();
    boolean isEmpty();
}
