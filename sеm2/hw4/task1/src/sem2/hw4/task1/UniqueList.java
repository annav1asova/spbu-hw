package sem2.hw4.task1;

/** Class for list, where each element doesn't contained more than once (and elements are sorted) */
public class UniqueList<T extends Comparable> extends SingleLinkedList<T> implements List<T> {
    public UniqueList() {
        super();
    }

    /**
     * method adds element to the list only if it doesn't exist there.
     *
     * @param value element to be added has this value
     * @throws AlreadyAddedException if element is already in the list
     */
    @Override
    public void add(T value) throws AlreadyAddedException {
        if (hasAdded(value))
            throw new AlreadyAddedException();

        super.add(value);
    }

    /**
     * method that removes value from the list if it exists there.
     *
     * @param value element to be deleted has this value
     * @throws NoSuchElementException if in the list there is no element with value
     */
    @Override
    public void remove(T value) throws NoSuchElementException {
        if (!hasAdded(value))
            throw new NoSuchElementException();

        super.remove(value);
    }

    /**
     * method that checks if element already exist in list.
     *
     * @param value value of element that has to be checked
     * @return true if exists, false otherwise
     */
    public boolean hasAdded(T value) {
        if (super.isEmpty())
            return false;

        Element temp = first;
        while (temp.next != null && !value.equals(temp.value)) {
            temp = temp.next;
        }
        return value.equals(temp.value);
    }

    /** Constructs a new 'already added exception' */
    public static class AlreadyAddedException extends RuntimeException {
        public AlreadyAddedException() {
            super("element that you are trying to add is already in the list");
        }
    }

    /** Constructs a new 'no such element' exception */
    public static class NoSuchElementException extends RuntimeException {
        public NoSuchElementException() {
            super("element that you are trying to remove doesn't exist in the list");
        }
    }
}
