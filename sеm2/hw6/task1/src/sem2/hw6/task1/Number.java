package sem2.hw6.task1;

/** class for numbers */
public class Number implements Operand {
    /** value of number */
    public int value;

    /** constructor for numbers, initializes it */
    public Number(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}
