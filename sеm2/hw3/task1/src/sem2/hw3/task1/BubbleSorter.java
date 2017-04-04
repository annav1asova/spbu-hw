package sem2.hw3.task1;

/** Class that sorts array using bubble sort */
public class BubbleSorter implements Sorter {
    /**
     * changes values of two elements in array.
     *
     * @param i index of first element
     * @param j index of second element
     * @param array
     */
    private void swap(int i, int j, int array[]) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i <  n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
    }
}
