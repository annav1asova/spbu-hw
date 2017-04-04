package sem2.hw2.task1;

/**  Class that can find value of arithmetic expression */
public class Calculator {
    /** max size of array stack */
    private static int maxSize = 100000;

    /** stack that is used for converting expression to postfix form */
    private static Stack<Character> operators = new ArrayStack<Character>(maxSize);

    /** stack that is used for calculating value of expression in postfix form */
    private static Stack<Double> numbers = new ArrayStack<Double>(maxSize);

    public static double calculate(String expression) throws Throwable {
        return infixToPostfix(expression,  "");
    }

    /**
     * @param a operator or bracket
     * @return priority of operator or bracket
     */
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

    /**
     * calculate value of expression by converting it to postfix form and calling postfixCalculation.
     *
     * @param myString String that contains expression (infix form)
     * @param resultString String that contains postfix form of expression
     * @return result of calculation expression in postfix form
     * @throws TooManyArgumentsException if stack with arguments is filled
     * @throws MissedArgumentException if stack with arguments is empty
     */
    private static double infixToPostfix(String myString, String resultString) throws Throwable {
        for (int i = 0; i < myString.length(); i++) {
            char temp = myString.charAt(i);

            if (isDigit(temp)) {
                resultString = resultString + temp;
            }
            else if (temp == '(') {
                try {
                    operators.push(temp);
                } catch (Stack.StackIsFilledException e) {
                    throw new TooManyArgumentsException();
                }
            }
            else if (temp == ')') {
                char topToken;
                try {
                    topToken = operators.pop();
                } catch (Stack.EmptyStackException e) {
                    throw new MissedArgumentException();
                }
                while (topToken != '(') {
                    resultString = resultString + topToken;
                    try {
                        topToken = operators.pop();
                    } catch (Stack.EmptyStackException e) {
                        throw new MissedArgumentException();
                    }
                }
            }
            else if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                while (!operators.isEmpty() && priority(operators.peek()) >= priority(temp)) {
                    resultString = resultString + operators.pop();
                }
                try {
                    operators.push(temp);
                } catch (Stack.StackIsFilledException e) {
                    throw new TooManyArgumentsException();
                }
            }
        }
        while (!operators.isEmpty()) {
            resultString = resultString + operators.pop();
        }
        return postfixCalculation(resultString);
    }

    /**
     * calculates value of expression with one operator.
     *
     * @param a left operand in simple expression
     * @param b right operand in simple expression
     * @param c operator in simple expression
     * @return value of expression
     */
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

    /**
     * calculates value of expression in postfix form.
     *
     * @param myString postfix form of expression
     * @return value of expression
     * @throws TooManyArgumentsException if stack with arguments is filled
     * @throws MissedArgumentException if stack with arguments is empty
     */
    private static double postfixCalculation(String myString) throws Throwable {;
        for (int i = 0; i < myString.length(); i++) {
            char temp = myString.charAt(i);

            if (isDigit(temp)) {
                try {
                    numbers.push((double)temp - '0');
                } catch (Stack.StackIsFilledException e) {
                    throw new TooManyArgumentsException();
                }
            }

            if (temp == '+' || temp == '-' || temp == '*' || temp == '/') {
                double a;
                double b;
                try {
                    a = numbers.pop();
                    b = numbers.pop();
                } catch (Stack.EmptyStackException e) {
                    throw new MissedArgumentException();
                }

                try {
                    numbers.push(myOperator(b, a, temp));
                } catch (Stack.StackIsFilledException e) {
                    throw new TooManyArgumentsException();
                }
            }
        }
        double result = 0;
        try {
            result = numbers.pop();
        } catch (Stack.EmptyStackException e){
            e.printStackTrace();
        }
        return result;
    }

    /** Constructs a new 'missed argument exception' with message */
    public static class MissedArgumentException extends Throwable {
        public MissedArgumentException() {
            super("you've missed an argument somewhere");
        }
    }
    /** Constructs a new 'too many arguments exception' with message */
    public static class TooManyArgumentsException extends Throwable {
        public TooManyArgumentsException() {
            super("too many arguments in expression");
        }
    }
}