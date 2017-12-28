package spbu.sem3.hw4.task1;

import javafx.geometry.Side;

import static javafx.geometry.Side.*;

public class Tank {
    private Landscape landscape;
    private int locationX;
    private double rotationOfBarrel;
    private int velocityOfBalls;
    private int sizeOfBalls;

    private static final int BARREL_WIDTH = 30;
    private static final int TANK_STEP = 5;
    private static final double BARREL_STEP = 0.1;
    private static final int VELOCITY_STEP = 5;
    private static final int SIZE_STEP = 3;
    private static final int MAX_VELOCITY = 70;
    private static final int MIN_VELOCITY = 20;
    private static final int MAX_SIZE = 20;
    private static final int MIN_SIZE = 5;

    public Tank(Landscape landscape, int x, double rotationOfBarrel, int velocityOfBalls, int sizeOfBalls) {
        this.landscape = landscape;
        this.locationX = x;
        this.rotationOfBarrel = rotationOfBarrel;
        this.velocityOfBalls = velocityOfBalls;
        this.sizeOfBalls = sizeOfBalls;
    }

    public void go(Side side) {
        if (side == LEFT) {
            locationX -= TANK_STEP;
        }
        else if (side == RIGHT)
            locationX += TANK_STEP;
    }

    public void moveBarrel(Side side) {
        if (side == TOP) {
            rotationOfBarrel -= BARREL_STEP;
        } else if (side == BOTTOM){
            rotationOfBarrel += BARREL_STEP;
        }
    }

    public Ball shot() {
        double cos = Math.cos(rotationOfBarrel);
        double sin = Math.sin(rotationOfBarrel);
        int startX = locationX + (int)(BARREL_WIDTH * cos);
        int startY = landscape.getMountainHeight(locationX) - (int)(BARREL_WIDTH * sin);

        //Random r = new Random();
        return new Ball(startX, startY, rotationOfBarrel, velocityOfBalls, sizeOfBalls, landscape);
    }

    public double getRotationOfBarrel() {
        return rotationOfBarrel;
    }

    public int getLocationX() {
        return locationX;
    }

    @Override
    public String toString() {
        return locationX + " " + rotationOfBarrel + " " + velocityOfBalls + " " + sizeOfBalls + " ";
    }

    public void changeVelocity(Side side) {
        if (side == TOP) {
            velocityOfBalls += VELOCITY_STEP;
        } else if (side == BOTTOM) {
            velocityOfBalls -= VELOCITY_STEP;
        }
        velocityOfBalls = Math.min(MAX_VELOCITY, velocityOfBalls);
        velocityOfBalls = Math.max(MIN_VELOCITY, velocityOfBalls);
    }

    public void changeSize(Side side) {
        if (side == TOP) {
            sizeOfBalls += SIZE_STEP;
        } else if (side == BOTTOM) {
            sizeOfBalls -= SIZE_STEP;
        }
        sizeOfBalls = Math.min(MAX_SIZE, sizeOfBalls);
        sizeOfBalls = Math.max(MIN_SIZE, sizeOfBalls);
    }
}
