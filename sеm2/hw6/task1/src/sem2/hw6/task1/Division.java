package sem2.hw6.task1;

/** class for division */
public class Division extends Operator {
    public int calculate () {
        return leftOperand.calculate() / rightOperand.calculate();
    }

    public char getChar() {
        return '/';
    }
}
