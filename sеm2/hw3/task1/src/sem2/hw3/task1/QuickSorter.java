package sem2.hw3.task1;

/** Class that sorts array using quick sort */
public class QuickSorter implements Sorter {
    public void sort(int array[]) {
        qsort(array, 0, array.length - 1);
    }

    /**
     * changes values of two elements in array.
     *
     * @param i index of first element
     * @param j index of second element
     * @param array
     */
    private void swap(int i, int j, int[] array) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * sort piece of array.
     *
     * @param array
     * @param left start of the piece
     * @param right end of the piece
     */
    private void qsort(int array[], int left, int right) {
        int i = left;
        int j = right;
        int x = array[left];
        while (i <= j) {
            while (i <= right && array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                swap(i, j, array);
                i++;
                j--;
            }
        }
        if (i < right) {
            qsort(array, i, right);
        }
        if (j > left) {
            qsort(array, left, j);
        }
    }
}
