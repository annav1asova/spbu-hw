package sem2.hw8.task2;

import java.util.concurrent.RecursiveAction;

/** Class for threaded QSort */
public class ThreadedQuickSort extends RecursiveAction implements QuickSorter {
    public static final int MAX_THREADS = Runtime.getRuntime().availableProcessors();
    int[] array;
    final int start, end;

    private final int minParitionSize;

    public ThreadedQuickSort(int minParitionSize, int[] array, int start, int end) {
        this.minParitionSize = minParitionSize;
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        actualSort(minParitionSize, array, start, end);
    }

    /**
     * sorts an array
     *
     * @param minPartitionSize min size of piece that will be sorted by more than one thread
     * @param array
     * @param start
     * @param end
     */
    private void actualSort(int minPartitionSize, int[] array, int start, int end) {
        int sizeOfCurrentPiece = end - start + 1;
        if (sizeOfCurrentPiece <= 1)
            return;

        Partition partition = new Partition();
        int i = partition.split(array, start, end);

        if (sizeOfCurrentPiece >= minParitionSize) {
            if (i - 1 > start) {
                invokeAll(new ThreadedQuickSort(minParitionSize, array, start, i - 1));
            }
            if (end > i) {
                invokeAll(new ThreadedQuickSort(minParitionSize, array, i, end));
            }
        } else {
            actualSort(minParitionSize, array, start, i - 1);
            actualSort(minParitionSize, array, i, end);
        }
    }

    @Override
    public void sort(int[] array) {
        compute();
    }
}
