package sem2.hw6.task1;

/** class for addition */
public class Addition extends Operator {
    public int calculate () {
        return leftOperand.calculate() + rightOperand.calculate();
    }

    public char getChar() {
        return '+';
    }
}
