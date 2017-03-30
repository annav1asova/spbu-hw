package sem2.hw2.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        System.out.println("Ответ: " + Calculator.calculate(expression));
    }
}
