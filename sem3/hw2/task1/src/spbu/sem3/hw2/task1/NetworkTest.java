package spbu.sem3.hw2.task1;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
        network = createNetwork("input1.txt", new TrueRandomGenerator());
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
        network = createNetwork("input1.txt", new TrueRandomGenerator());
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
            network = createNetwork("input2.txt", new TrueRandomGenerator());
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

    /** tests order of infections with random generator, that always infects computer. */
    @Test
    public void testOrderOfInfections() throws FileNotFoundException {
        network = createNetwork("input3.txt", new NotReallyRandomGenerator());

        ArrayList<ArrayList<Integer>> expectedInfections = generateExpectations();

        for (int i = 0; i < expectedInfections.size(); i++) {
            ArrayList<Integer> currentExpectations = expectedInfections.get(i);
            boolean[] infections = network.getCurrentState();
            for (int j = 0; j < 12; j++) {
                assertTrue(infections[j] == currentExpectations.contains(j));
            }
            network.makeStep();
        }
    }

    /** tests order of infections with random generator, that infects only computers with Windows os. */
    @Test
    public void testOrderOfWindowsInfections() throws FileNotFoundException {
        network = createNetwork("input3.txt", new InfectingWindowsGenerator());

        network.makeStep();
        boolean[] infections = network.getCurrentState();
        for (int i = 0; i < 12; i++) {
            assertTrue(infections[i] == (i == 0 || i == 1 || i == 5));
        }
        network.makeStep();
        infections = network.getCurrentState();
        for (int i = 0; i < 12; i++) {
            assertTrue(infections[i] == (i == 0 || i == 1 || i == 5 || i == 2 || i == 7));
        }

        for (int i = 0; i < 10; i++) {
            network.makeStep();
        }
        infections = network.getCurrentState();
        for (int i = 0; i < 12; i++) {
            assertTrue(infections[i] == (i == 0 || i == 1 || i == 5 || i == 2 || i == 7));
        }
    }

//     for this network and always-zero random generator
//            1---2---3---4---5
//            |
//            6----7
//            |
//            8
//            |
//            9---10
//            |
//            11
//            |
//            12
    private ArrayList<ArrayList<Integer>> generateExpectations() {
        ArrayList<Integer> initially = new ArrayList<>();
        initially.add(0);

        ArrayList<Integer> afterOneStep = new ArrayList<>(initially);
        afterOneStep.add(1);
        afterOneStep.add(5);

        ArrayList<Integer> afterTwoSteps = new ArrayList<>(afterOneStep);
        afterTwoSteps.add(2);
        afterTwoSteps.add(6);
        afterTwoSteps.add(7);

        ArrayList<Integer> afterThreeSteps = new ArrayList<>(afterTwoSteps);
        afterThreeSteps.add(3);
        afterThreeSteps.add(8);

        ArrayList<Integer> afterFourSteps = new ArrayList<>(afterThreeSteps);
        afterFourSteps.add(4);
        afterFourSteps.add(9);
        afterFourSteps.add(10);

        ArrayList<Integer> afterFiveSteps = new ArrayList<>(afterFourSteps);
        afterFiveSteps.add(11);

        ArrayList<ArrayList<Integer>> expectations = new ArrayList<>();
        expectations.add(initially);
        expectations.add(afterOneStep);
        expectations.add(afterTwoSteps);
        expectations.add(afterThreeSteps);
        expectations.add(afterFourSteps);
        expectations.add(afterFiveSteps);

        return expectations;
    }

    private Network createNetwork(String filePath, RandomGenerator random) throws FileNotFoundException {
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

        return new Network(adjacencyMatrix, computers, alreadyInfected, random);
    }

    private class NotReallyRandomGenerator implements RandomGenerator {
        @Override
        public int generate(int max) {
            return 0;
        }
    }

    private class InfectingWindowsGenerator implements RandomGenerator {
        @Override
        public int generate(int max) {
            return 20;
        }
    }
}