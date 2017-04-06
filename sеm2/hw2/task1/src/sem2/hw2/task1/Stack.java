package sem2.hw2.task1;

/** interface for Stack */
public interface Stack<Type> {
    /**
     * inserts the value to the top of the stack.
     *
     * @param value
     */
    void push(Type value);

    /**
     * removes a value at the top of the stack.
     *
     * @return removed value
     */
    Type pop();

    /**
     * this method is similar to pop method, but it doesn't make any changes of Stack.
     *
     * @return the object on top of Stack
     */
    Type peek();

    /**
     * checks emptiness of stack.
     *
     * @return true if stack is empty, false otherwise
     */
    boolean isEmpty();

    /** Constructs a new stack is filled exception with message */
     public class StackIsFilledException extends RuntimeException {
        public StackIsFilledException() {
            super("'push' has been called, but stack is filled ");
        }
    }

    /** Constructs a new empty stack exception with message */
    public class EmptyStackException extends RuntimeException {
        public EmptyStackException() {
            super("'peek' or 'pop' has been called, but stack is empty");
        }
    }
}
