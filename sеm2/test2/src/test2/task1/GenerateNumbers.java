package test2.task1;

import java.util.Random;

public class GenerateNumbers {
    int[][] currentPairs;
    boolean[][] alreadyFilled;

    public GenerateNumbers(int size) {
        Random r = new Random();
        currentPairs = new int[size][size];
        int max = size * size / 2;
        currentPairs = new int[size][size];
        alreadyFilled = new boolean[size][size];

        for (int i = 1; i < max; i++) {
            fill(i, size);
            fill(i, size);
        }
    }

    private void fill (int value, int size) {
        Random r = new Random();
        boolean emptyButtonNotFound = true;
        while (emptyButtonNotFound) {
            int firstButtonNumber = r.nextInt(Math.abs(size * size));
            if (!alreadyFilled[firstButtonNumber / size][firstButtonNumber % size]) {
                alreadyFilled[firstButtonNumber / size][firstButtonNumber % size] = true;
                currentPairs[firstButtonNumber / size][firstButtonNumber % size] = value;
                emptyButtonNotFound = false;
            }
        }
    }
}
