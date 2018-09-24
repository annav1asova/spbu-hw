package spbu.sem3.hw4.task1;

import java.io.Serializable;

public class Ball implements Serializable {
    private int startX;
    private int startY;
    private double angle;
    private long startTime;
    private double velocity;
    private int size = 10;
    private Landscape landscape;
    private final static double COEFFICIENT_TIME = 4;
    private final static double g = 9.8;
    private final static int SIZE_X = 700;
    private final static int SIZE_Y = 500;

    public Ball(int x, int y, double angle, double velocity, int size, Landscape landscape) {
        startX = x;
        startY = y;
        this.angle = angle;
        startTime = System.currentTimeMillis();
        this.velocity = velocity;
        this.size = size;
        this.landscape = landscape;
    }

    public Ball(int startX, int startY, double angle, long startTime, double velocity, int size, Landscape landscape) {
        this.startX = startX;
        this.startY = startY;
        this.angle = angle;
        this.startTime = startTime;
        this.velocity = velocity;
        this.size = size;
        this.landscape = landscape;
    }

    public int getSize() {
        return size;
    }

    public boolean isBallOnScreen(int x, int y) {
        return (x > 0 && x < SIZE_X && y > 0 && y < SIZE_Y);
    }

    public boolean isBallOnMountain(int x, int y) {
        int mountainY = landscape.getMountainHeight(x);
        return y > mountainY;
    }

    public int newXCoordinate(double time) {
        return (int)(startX + velocity * Math.cos(angle) * time);
    }

    public int newYCoordinate(double time) {
        return (int)(startY - velocity * Math.sin(angle) * time + g *  time * time / 2.0);
    }

    public double timeFromStart(long time) {
        return COEFFICIENT_TIME * (time - startTime) / 1000.0;
    }

    @Override
    public String toString() {
        return startX + " " + startY + " " + angle + " " + startTime + " " + velocity + " " + size + " ";
    }
}
