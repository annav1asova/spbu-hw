package sem2.hw2.task1;

public class Calculator {
    private static int maxSize = 100000;
    private static Stack<Character> operators = new ArrayStack<>(maxSize);
    private static Stack<Double> numbers = new ArrayStack<>(maxSize);

    public static double calculate(String expression) {
        return infixToPostfix(expression.length(), expression,  "");
    }

    private static int priority(char a) {
        if (a == '(')
            return 0;
        if (a == '+' || a == '-')
            return 1;
        if (a == '*' || a == '/')
            return 2;
        else
            return -1;
    }

    private static double infixToPostfix(int index, String myString, String resultString) {
        for (int i = 0; i < index; i++) {
            char temp = myString.charAt(i);

            if (isDigit(temp)) {
                resultString = resultString + temp;
            }
            else if (temp == '(') {
                operators.push(temp);
            }
            else if (temp == ')') {
                char topToken = operators.pop();
                while (topToken != '(') {
                    resultString = resultString + topToken;
                    topToken = operators.pop();
                }
            }
            else if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                while (!operators.isEmpty() && priority(operators.peek()) >= priority(temp)) {
                    resultString = resultString + operators.pop();
                }
                operators.push(temp);
            }
        }
        while (!operators.isEmpty()) {
            resultString = resultString + operators.pop();
        }
        return postfixCalculation(resultString);
    }

    private static double myOperator(double a, double b, char c) {
        if (c == '+')
            return a + b;
        if (c == '-')
            return a - b;
        if (c == '*')
            return a * b;
        if (c == '/')
            return a / b;
        else
            return -1;
    }

    private static boolean isDigit(char temp) {
        return (temp >= '0' && temp <= '9');
    }

    private static double postfixCalculation(String myString) {;
        for (int i = 0; i < myString.length(); i++) {
            char temp = myString.charAt(i);

            if (isDigit(temp)) {
                numbers.push((double)temp - '0');
            }

            if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                double a = numbers.pop();
                double b = numbers.pop();
                numbers.push(myOperator(b, a, temp));
            }
        }
        double result = numbers.pop();
        return result;
    }
}