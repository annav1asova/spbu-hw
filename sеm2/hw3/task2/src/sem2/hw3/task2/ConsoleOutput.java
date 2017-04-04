package sem2.hw3.task2;

/** Class that prints two-dimensional matrix to the console */
public class ConsoleOutput extends Converter implements Output {
    public void output(int[][] array) {
        int result[] = toSpiral(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
