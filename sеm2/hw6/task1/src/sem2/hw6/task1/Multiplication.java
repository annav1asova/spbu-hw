package sem2.hw6.task1;

/** class for multiplication */
public class Multiplication extends Operator {
    public int calculate () {
        return leftOperand.calculate() * rightOperand.calculate();
    }

    protected char getChar() {
        return '*';
    }
}
