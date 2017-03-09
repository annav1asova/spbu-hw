package sem2.hw1.task2;

public class List {
    private Element first;

    public List() {
        first = null;
    }

    public void add(int value) {

        if (isEmpty()) {
            first = new Element(value, null);
            return;
        }

        if (value < first.value) {
            first = new Element(value, first);
            return;
        }

        Element temp = first;
        while (temp.next != null && value > temp.next.value) {
            temp = temp.next;
        }
        temp.next = new Element(value, temp.next);
    }

    public void remove(int value) {
        if (isEmpty())
            return;

        Element temp = first;
        if (temp.next == null && temp.value == value)
        {
            first = null;
            return;
        }

        if (temp.value == value)
        {
            first = temp.next;
            return;
        }

        while (temp.next != null && temp.next.value != value)
        {
            temp = temp.next;
        }
        if (temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Element {
        private int value;
        private Element next;

        public Element(int value, Element next) {
            this.value = value;
            this.next = next;
        }

    }
}
