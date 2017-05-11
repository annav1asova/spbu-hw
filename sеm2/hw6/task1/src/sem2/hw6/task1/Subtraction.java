package sem2.hw6.task1;

/** class for subtraction */
public class Subtraction extends Operator {
    public int calculate () {
        return leftOperand.calculate() - rightOperand.calculate();
    }

    public char getChar() {
        return '-';
    }
}
