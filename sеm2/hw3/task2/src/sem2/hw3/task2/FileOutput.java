package sem2.hw3.task2;

import java.io.IOException;
import java.io.PrintWriter;

/** Class that prints two-dimensional matrix to the file */
public class FileOutput extends Converter implements Output {
    public void output(int[][] array) throws IOException {
        PrintWriter out = new PrintWriter("output.txt");
        int result[] = toSpiral(array);
        for (int i = 0; i < result.length; i++) {
            out.print(result[i] + " ");
        }
        out.close();
    }
}
