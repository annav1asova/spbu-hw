package sem2.hw2.task1;

/** Class for Stack on array */
public class ArrayStack<Type> implements Stack<Type> {
    private Type array[];
    private int head;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = (Type[])new Object[maxSize];
        head = -1;
    }

    public void push(Type value) {
        if (head == maxSize - 1)
            throw new StackIsFilledException();
        else
            array[++head] = value;
    }

    public Type pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Type popped = array[head];
        head--;
        return popped;
    }

    public Type peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[head];
    }

    public boolean isEmpty() {
        return head == -1;
    }
}
