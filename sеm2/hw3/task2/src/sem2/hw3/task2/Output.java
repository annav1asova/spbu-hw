package sem2.hw3.task2;

import java.io.IOException;

/** Interface that prints two-dimensional matrix */
public interface Output {
    /**
     * prints two-dimensional matrix by spiral
     *
     * @param array
     * @throws IOException
     */
    void output(int[][] array) throws IOException;
}
