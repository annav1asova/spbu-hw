package sem2.hw6.task1;

/** Class for Tree for math expressions */
public class Tree {
    /* root of this tree */
    private Operator root;

    /* index in string with expression, where parsing has stopped */
    private int index = 0;

    /**
     * method that runs parser of expression
     *
     * @param expression string with operators and digits
     * @return tree of this expression
     */
    public Operand getTree(String expression) {
        return parse(expression);
    }

    /**
     * method that reads number or '(' and operator
     *
     * @param expression string with operators and digits
     * @return operand
     */
    public Operand parse(String expression) {
        char symbol = expression.charAt(index);
        Operand operand = null;

        if (symbol == '(') {
            index++;
            operand = readOperator(expression);
        } else if (isDigit(symbol)) {
            operand = new Number(getNumber(expression));
        }
        return operand;
    }

    /**
     * method that read operatorand then calls parsing of left and right child
     *
     * @param expression string with operators and digits
     * @return piece of result tree, current operator as root
     */
    private Operator readOperator(String expression) {
        Operator operator = null;
        switch(expression.charAt(index)) {
            case '+':
                operator =  new Addition();
                break;
            case '/':
                operator = new Division();
                break;
            case '*':
                operator = new Multiplication();
                break;
            case '-':
                operator = new Subtraction();
                break;
        }

        index += 2;
        operator.initializeLeftOperand(parse(expression));
        index++;
        operator.initializeRightOperand(parse(expression));
        index++;

        return operator;
    }

    /**
     * method that read a number from string
     *
     * @param expression from this string method reads
     * @return integer value of number
     */
    private int getNumber(String expression) {
        int result = 0;
        while (isDigit(expression.charAt(index))) {
            result *= 10;
            result += expression.charAt(index) - '0';
            index++;
        }
        return result;
    }

    /**
     * method that checks whether the symbol is digit
     *
     * @param symbol
     * @return true if it is digit, false otherwise
     */
    private boolean isDigit(char symbol) {
        return (symbol >= '0' && symbol <= '9');
    }

    /* method runs print function for root of tree */
    void print() {
        root.print();
    }
}
