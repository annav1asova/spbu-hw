package sem2.hw3.task2;

/** Class that converts matrix to one-dimensional array */
public class Converter {
    /**
     * method converts matrix to array by spiral.
     *
     * @param array two-dimensional matrix
     * @return one-dimensional array, spiral version of parameter array
     */
    public static int[] toSpiral(int[][] array) {
        int n = array.length;
        int result[] = new int[n * n];
        int curI = n / 2;
        int curJ = n / 2;
        int curInResult = 0;
        result[curInResult++] = array[curI][curJ];
        int curMax = 1;
        int cur = 0;
        while (curMax <= n)
        {
            cur = 0;
            while (cur < curMax && curI > 0) {
                curI--;
                cur++;
                result[curInResult++] = array[curI][curJ];
            }
            cur = 0;
            while (cur < curMax && curMax < n) {
                curJ++;
                cur++;
                result[curInResult++] = array[curI][curJ];
            }
            cur = 0;
            curMax++;
            while (cur < curMax && curMax < n) {
                curI++;
                cur++;
                result[curInResult++] = array[curI][curJ];
            }
            cur = 0;
            while (cur < curMax && curMax < n) {
                curJ--;
                cur++;
                result[curInResult++] = array[curI][curJ];
            }
            curMax++;
        }
        return result;
    }
}
