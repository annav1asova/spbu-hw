package sem2.hw3.task2;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/** Test class for Output */
public class OutputTest {
    private int testArray[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
    private String expected = "4 1 2 5 8 7 6 3 0 ";

    /** Test ConsoleOutput */
    @Test
    public void testingConsoleOutput() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        PrintStream prev = System.out;
        System.setOut(printStream);

        Output outConsole = new ConsoleOutput();
        outConsole.output(testArray);

        System.setOut(prev);
        printStream.close();

        String result = byteArrayOutputStream.toString();
        Assert.assertTrue(result.equals(expected));
    }

    /** Test FileOutput */
    @Test
    public void testingFileOutput() throws Exception {
        Output outFile = new FileOutput();
        outFile.output(testArray);
        Scanner sc = new Scanner(new File("output.txt"));
        String result = sc.nextLine();
        Assert.assertTrue(result.equals(expected));
    }
}