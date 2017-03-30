package sem2.hw2.task1;

public class PointerStack<Type> implements Stack<Type> {
    private Element head;

    public PointerStack() {
        head = null;
    }

    public void push(Type value){
        head = new Element(value, head
        );
    }

    public Type pop() {
        if (isEmpty()) {
            System.out.println("your stack is empty");
            return null;
        }

        Type popped = head.value;
        head = head.next;
        return popped;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Type peek() {
        if (isEmpty()) {
            System.out.println("your stack is empty");
            return null;
        }
        return head.value;
    }

    private class Element {
        private Type value;
        private Element next;

        public Element(Type value, Element next){
            this.value = value;
            this.next = next;
        }
    }
}
