package sem2.hw8.task2;

public class Partition {
    /**
     * swaps element in array so that elements less than chosen element go before it and elements more then chosen element - after
     *
     * @param array
     * @param start start of piece
     * @param end end of piece
     * @return index of chosen element after rearranging them
     */
    public static int split(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int x = array[start];
        while (i <= j) {
            while (i <= end && array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    /** swaps two elements in array by their indexes */
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int t = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = t;
    }
}

