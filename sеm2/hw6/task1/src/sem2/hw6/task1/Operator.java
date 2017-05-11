package sem2.hw6.task1;

/** Class for operator */
public abstract class Operator implements Operand {
    /** left Operand */
    protected Operand leftOperand;

    /** right Operand */
    protected Operand rightOperand;

    /** returns char symbol of operator */
    abstract char getChar();

    public void print() {
        System.out.print("(" + getChar() + " ");
        leftOperand.print();
        System.out.print(" ");
        rightOperand.print();
        System.out.print(")");
    }

    /** initializes left operand */
    public void initializeLeftOperand(Operand left) {
        leftOperand = left;
    }

    /** initializes right operand */
    public void initializeRightOperand(Operand right) {
        rightOperand = right;
    }
}
