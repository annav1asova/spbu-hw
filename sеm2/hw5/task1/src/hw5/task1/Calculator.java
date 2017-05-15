package hw5.task1;

/** Class that calculates the result of expression */
public class Calculator {
    private int min = 0;
    private int max = 20;

    /**
     * method that counts result of simple expression
     *
     * @param firstArgument first operand
     * @param secondArgument second operand
     * @param operation operation
     * @return result
     */
    public double count (int firstArgument, int secondArgument, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                result = firstArgument + secondArgument;
                break;
            case '*':
                result = firstArgument * secondArgument;
                break;
            case '-':
                result = firstArgument - secondArgument;
                break;
            case '/':
                result = (double)firstArgument / secondArgument;
                break;
        }
        return result;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
