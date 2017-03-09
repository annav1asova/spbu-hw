package sem2.hw1.task1;

public class Stack<Type> {
    private Element head;

    public Stack(){

    }

    public void push(Type value){
        head = new Element(value, head);
    }

    public Type pop(){
        if (isEmpty())
            return null;

        Type popped = head.value;
        head = head.next;
        return popped;
    }

    public boolean isEmpty(){
        return head == null;
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
