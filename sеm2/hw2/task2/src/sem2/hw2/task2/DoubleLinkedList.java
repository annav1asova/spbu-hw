package sem2.hw2.task2;

public class DoubleLinkedList implements List{
    private Element first = null;
    private Element last = null;

    public void add(int value) {
        if (isEmpty()) {
            first = new Element(value, null, null);
            last = first;
            return;
        }

        if (value < first.value) {
            first = new Element(value, first, null);
            return;
        }

        Element temp = first;
        while (temp.next != null && value > temp.next.value) {
            temp = temp.next;
        }
        Element toAdd = new Element(value, temp.next, temp);
        temp.next = toAdd;
        if (temp.next.next != null)
            temp.next.next.prev = toAdd;
        if (temp.next.next == null)
            last = toAdd;
    }

    public void remove(int value) {
        if (isEmpty())
            return;

        Element temp = first;
        if (temp.next == null && temp.value == value) {
            first = null;
            last = null;
            return;
        }

        if (temp.value == value) {
            first = temp.next;
            temp.next.prev = null;
            return;
        }

        while (temp.next != null && temp.next.value != value) {
            temp = temp.next;
        }
        if (temp.next == null)
            return;

        temp.next = temp.next.next;
        if (temp.next != null)
            temp.next.prev = temp;
        if (temp.next == null)
            last = temp;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void showList() {
        Element temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private class Element {
        private int value;
        private Element next;
        private Element prev;

        public Element(int value, Element next, Element prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
