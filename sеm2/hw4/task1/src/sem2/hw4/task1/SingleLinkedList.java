package sem2.hw4.task1;

/** Class for list, where elements are sorted */
public class SingleLinkedList<T extends Comparable> implements List<T> {
    protected Element first = null;

    /**
     * method that adds an element to the sorted list.
     *
     * @param value element to be added has this value
     */
    public void add(T value) {
        if (isEmpty()) {
            first = new Element(value, null);
            return;
        }

        if (value.compareTo(first.value) < 0) {
            first = new Element(value, first);
            return;
        }

        Element temp = first;
        while (temp.next != null && value.compareTo(temp.next.value) > 0) {
            temp = temp.next;
        }
        temp.next = new Element(value, temp.next);
    }

    /**
     * method that removes an element from the sorted list.
     *
     * @param value element to be deleted has this value
     */
    public void remove(T value) {
        if (isEmpty())
            return;

        Element temp = first;
        if (temp.next == null && temp.value.equals(value)) {
            first = null;
            return;
        }

        if (temp.value.equals(value)) {
            first = temp.next;
            return;
        }

        while (temp.next != null && !temp.next.value.equals(value)) {
            temp = temp.next;
        }
        if (temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    /**
     * method checks whether the list is empty.
     *
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /** method that prints list at console */
    public void showList() {
        Element temp = first;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /** class for creating new element */
    protected class Element {
        protected T value;
        protected Element next;

        protected Element(T value, Element next) {
            this.value = value;
            this.next = next;
        }
    }
}