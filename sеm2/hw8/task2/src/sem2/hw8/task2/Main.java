package sem2.hw8.task2;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 100000;

//        for (int i = 0; i < size / ThreadedQuickSort.MAX_THREADS; i += size / (20 * ThreadedQuickSort.MAX_THREADS)) {
//            int arrray[] = generateNewRandomArray(size);
//            long before = System.currentTimeMillis();
//            ThreadedQuickSort threadedQuickSorter = new ThreadedQuickSort(i, arrray, 0, size - 1);
//            threadedQuickSorter.compute();
//            long after = System.currentTimeMillis();
//            System.out.println(i + " " + (after - before));
//        }
        int arrayNonThreaded[] = generateNewRandomArray(size);
        long before1 = System.currentTimeMillis();
        NonThreadedQuickSort nonThreadedQuickSorter = new NonThreadedQuickSort();
        nonThreadedQuickSorter.sort(arrayNonThreaded);
        long after1 = System.currentTimeMillis();
        System.out.println(after1 - before1);

        int arrayThreaded[] = generateNewRandomArray(size);
        long before = System.currentTimeMillis();
        ThreadedQuickSort threadedQuickSorter = new ThreadedQuickSort(size /
                ThreadedQuickSort.MAX_THREADS, arrayThreaded, 0, arrayThreaded.length - 1);
        threadedQuickSorter.sort(arrayThreaded);
        long after = System.currentTimeMillis();
        System.out.println(after - before);

    }

    private static int[] generateNewRandomArray(int size) {
        Random r = new Random();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            int randomInt = r.nextInt();
            array[i] = randomInt;
        }
        return array;
    }
}
