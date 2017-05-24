package sem2.hw8.task2;

/** class for q sort in one thread */
public class NonThreadedQuickSort implements QuickSorter {
    @Override
    public void sort(int array[]) {
        qsort(array, 0, array.length - 1);
    }

    /**
     * sorts piece of array
     *
     * @param array
     * @param start start of the piece
     * @param end end of the piece
     */
    private void qsort(int array[], int start, int end) {
        if (end - start <= 0) {
            return;
        }
        Partition partition = new Partition();
        int i = partition.split(array, start, end);

        qsort(array, i, end);
        qsort(array, start, i - 1);
    }
}
