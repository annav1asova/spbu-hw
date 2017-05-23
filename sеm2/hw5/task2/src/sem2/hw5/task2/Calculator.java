package sem2.hw5.task2;

/** Class that calculates the result of expression */
public class Calculator {
    private int min = -1000;
    private int max = 1000;

    /**
     * method that counts result of simple expression
     *
     * @param firstArgument first operand
     * @param secondArgument second operand
     * @param operation operation
     * @return result
     */
    public double count (double firstArgument, double secondArgument, char operation) {
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
