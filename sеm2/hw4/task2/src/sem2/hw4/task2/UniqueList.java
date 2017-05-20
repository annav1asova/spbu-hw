package sem2.hw4.task2;

/** Class for list */
public class UniqueList<T extends Comparable> {
    private Element first = null;
    private int size = 0;

    /**
     * method that adds an element to the list.
     *
     * @param value element to be added has this value
     */
    public void add(T value) {
        if (isEmpty()) {
            first = new Element(value, null);
            size++;
            return;
        }

        if (value.equals(first.value)) {
            first.quantity++;
            return;
        }

        Element temp = first;
        while (temp.next != null && value.compareTo(temp.next.value) < 0) {
            temp = temp.next;
        }

        if (temp.next != null && value.equals(temp.next.value)) {
            temp.next.quantity++;
        }
        else {
            temp.next = new Element(value, temp.next);
            size++;
        }

    }

    /**
     * method that removes an element from the list.
     *
     * @param value element to be deleted has this value
     */
    public void remove(T value) {
        Element toRemove = exists(value);
        if (toRemove == null)
            return;

        if (toRemove.quantity > 1) {
            toRemove.quantity -= 1;
            return;
        }

        Element temp = first;
        if (temp.next == null && temp.value.equals(value)) {
            first = null;
            size--;
            return;
        }

        if (temp.value.equals(value)) {
            first = temp.next;
            size--;
            return;
        }

        while (temp.next != null && !temp.next.value.equals(value)) {
            temp = temp.next;
        }
        if (temp.next == null)
            return;

        temp.next = temp.next.next;
        size--;
    }

    /**
     * method checks whether the list is empty.
     *
     * @return true if list is empty, false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * method returns size of list.
     *
     * @return field size
     */
    public int size() {
        return size;
    }

    /**
     * method that checks whether the element exists in list and returns it if exists.
     *
     * @param value value of element to be checked
     * @return null if it doesn't exist, element in list if there is element with this value
     */
    private Element exists(T value) {
        if (isEmpty())
            return null;

        Element temp = first;
        while (temp.next != null && !value.equals(temp.value)) {
            temp = temp.next;
        }
        if (value.equals(temp.value))
            return temp;
        else
            return null;
    }

    /**
     * method that returns quantity of element with given value.
     *
     * @param value
     * @return quantity of element with given value
     */
    public int quantity(T value) {
        if (exists(value) == null)
            return 0;
        else
            return exists(value).quantity;
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
    private class Element {
        protected T value;
        protected Element next;
        protected int quantity;

        protected Element(T value, Element next) {
            this.value = value;
            this.next = next;
            this.quantity = 1;
        }
    }
}