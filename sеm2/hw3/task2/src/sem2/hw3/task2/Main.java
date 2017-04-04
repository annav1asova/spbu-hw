package sem2.hw3.task2;

import java.io.IOException;
import java.util.Scanner;

/** Main class */
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int array[][] = inputArray();
        System.out.println("Выберите, где вы хотите увидеть массив(Консоль или Файл): ");
        String where = sc.nextLine();
        if (where.equals("Консоль")) {
            Output outConsole = new ConsoleOutput();
            outConsole.output(array);
        } else if (where.equals("Файл")) {
            Output outFile = new FileOutput();
            outFile.output(array);
        }
    }

    /**
     * method that returns matrix from console.
     */
    private static int[][] inputArray() {
        System.out.println("Введите размер двумерного массива: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int inputArray[][] = new int[size][size];
        System.out.println("Введите ваш двумерный массив: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                inputArray[i][j] = sc.nextInt();
            }
        }
        return inputArray;
    }
}
