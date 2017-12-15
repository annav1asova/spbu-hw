package spbu.sem3.hw2.task1;

/** abstract class for computer in network. */
public abstract class Computer {
    private boolean isInfected;

    public Computer() {
        isInfected = false;
    }

    public boolean isInfected() {
        return isInfected;
    }

    public void setInfected() {
        isInfected = true;
    }

    /** returns true is computer will infects (it means it wasn't infected before). */
    public boolean tryToInfect(int probability) {
        return probability < getChancesToBecomeInfected() && !isInfected();
    }

    /** returns probability to get infected for each computer depending on OS. */
    protected abstract int getChancesToBecomeInfected();
}
