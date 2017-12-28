package spbu.sem3.hw2.task1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/** class for network. */
public class Network {
    private int[][] adjacencyMatrix;
    private Computer[] computers;
    private int numberOfAll;
    private int amountOfAlreadyInfected;
    private RandomGenerator random;

    public Network(int[][] adjacencyMatrix, Computer[] computers, int[] alreadyInfected, RandomGenerator random) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.computers = computers;
        numberOfAll = adjacencyMatrix.length;
        for (int i = 0; i < alreadyInfected.length; i++) {
            computers[i].setInfected();
        }
        amountOfAlreadyInfected = alreadyInfected.length;
        this.random = random;
    }

    /** this method makes one step trying to infect computers in network. */
    public void makeStep() {
        Set<Computer> justInfected = new HashSet<>();
        for (int i = 0; i < numberOfAll; i++) {
            if (computers[i].isInfected()) {
                for (Computer neighbor: getNeighboringComputers(i)) {
                    if (neighbor.tryToInfect(getRandomNumber())) {
                        justInfected.add(neighbor);
                    }
                }
            }
        }
        for (Computer computer: justInfected) {
            computer.setInfected();
            amountOfAlreadyInfected++;
        }
    }

    /** method returns true if all computers in network are infected and false otherwise. */
    public boolean wholeNetworkIsInfected() {
        return amountOfAlreadyInfected == numberOfAll;
    }

    /** prints current state of each computer. */
    public void printState() {
        for (int i = 0; i < numberOfAll; i++) {
            System.out.println(i + (computers[i].isInfected() ? " is infected" : " isn't infected"));
        }
        System.out.println();
    }

    /** returns boolean array with states of each computer (true if it is infected, false otherwise) */
    public boolean[] getCurrentState() {
        boolean[] isInfected = new boolean[numberOfAll];
        for (int i = 0; i < numberOfAll; i++) {
            if (computers[i].isInfected())
                isInfected[i] = true;
        }
        return isInfected;
    }

    private int getRandomNumber() {
        return random.generate(101);
    }

    private ArrayList<Computer> getNeighboringComputers(int i) {
        ArrayList<Computer> neighbors = new ArrayList<>();
        for (int j = 0; j < numberOfAll; j++) {
           if (adjacencyMatrix[i][j] == 1) {
               neighbors.add(computers[j]);
           }
        }
        return neighbors;
    }
}

