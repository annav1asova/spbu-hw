package spbu.sem3.hw2.task1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/** test class for network and infecting process. */
public class NetworkTest {
    int amountOfTheSameTest = 10000;
    Network network;

    /** checks whether process will end (all computers in network became infected). */
    @Test
    public void testProcessWillEnd() throws FileNotFoundException {
        network = createNetwork("input1.txt");
        while (!network.wholeNetworkIsInfected()) {
            network.makeStep();
        }
        boolean[] infections = network.getCurrentState();
        for (int i = 0; i < infections.length; i++) {
            assertTrue(infections[i]);
        }
    }

    /** checks that some computers can't be infected on given steps. */
    @Test
    public void testStepByStep() throws FileNotFoundException {
        network = createNetwork("input1.txt");
        network.makeStep();
        boolean[] infections = network.getCurrentState();
        for (int i = 2; i < 7; i++) {
            assertTrue(!infections[i]);
        }
        network.makeStep();
        infections = network.getCurrentState();
        for (int i = 5; i < 7; i++) {
            assertTrue(!infections[i]);
        }
        network.makeStep();
        infections = network.getCurrentState();
        assertTrue(!infections[6]);
    }

    /** checks that windows computer gets infected in 70% of cases, macOs in 20% and linux in 10% (with some inaccuracy). */
    @Test
    public void testProbability() throws FileNotFoundException {
        int windowsWasInfected = 0;
        int macWasInfected = 0;
        int linuxWasInfected = 0;
        for (int i = 0; i < amountOfTheSameTest; i++) {
            network = createNetwork("input2.txt");
            network.makeStep();
            boolean[] infections = network.getCurrentState();
            if (infections[1])
                windowsWasInfected++;
            if (infections[2])
                macWasInfected++;
            if (infections[3])
                linuxWasInfected++;
        }
        assertEquals(windowsWasInfected, amountOfTheSameTest * 0.6, amountOfTheSameTest * 0.6 / 10); //relative error = 10% seems to be ok..
        assertEquals(macWasInfected, amountOfTheSameTest * 0.2, amountOfTheSameTest * 0.2 / 10);
        assertEquals(linuxWasInfected, amountOfTheSameTest * 0.1, amountOfTheSameTest * 0.1 / 10);
    }

    private Network createNetwork(String filePath) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));
        int n = sc.nextInt();
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = sc.nextInt();
            }
        }
        Computer[] computers = new Computer[n];
        for (int i = 0; i < n; i++) {
            String os = sc.next();
            switch (os) {
                case "Windows":
                    computers[i] = new WindowsComputer();
                    break;
                case "Linux":
                    computers[i] = new LinuxComputer();
                    break;
                case "MacOs":
                    computers[i] = new MacOsComputer();
                    break;
            }
        }
        int infectedNumber = sc.nextInt();
        int[] alreadyInfected = new int[infectedNumber];
        for (int i = 0; i < infectedNumber; i++) {
            alreadyInfected[i] = sc.nextInt() - 1;
        }

        return new Network(adjacencyMatrix, computers, alreadyInfected);
    }
}