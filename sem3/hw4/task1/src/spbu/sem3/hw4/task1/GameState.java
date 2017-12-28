package spbu.sem3.hw4.task1;

import javafx.geometry.Side;

import java.io.Serializable;
import java.util.ArrayList;

public class GameState implements Serializable {
    private static Landscape landscape;
    private ArrayList<Tank> tanks;
    private ArrayList<Ball> balls;
    private boolean isGameOver;

    public GameState() {
        this.landscape = new Landscape();
        this.tanks = new ArrayList<>();
        this.balls = new ArrayList<>();
        this.isGameOver = false;
    }
    public GameState(Landscape landscape, ArrayList<Tank> tanks, ArrayList<Ball> balls, boolean isGameOver) {
        this.landscape = landscape;
        this.tanks = tanks;
        this.balls = balls;
        this.isGameOver = isGameOver;
    }

    public void join(int index) {
        Tank newTank = null;
        if (index == 0) {
            newTank = new Tank(landscape, 100, Math.toRadians(-45), 60, 10);
        } else if (index == 1) {
            newTank = new Tank(landscape, 300, Math.toRadians(-135), 60, 10);
        }
        tanks.add(newTank);
    }

    public void go(int index, Side side) {
        tanks.get(index).go(side);
    }

    public void moveGun(int index, Side side) {
        tanks.get(index).moveBarrel(side);
    }

    public void fire(int index) {
        Ball newBall = tanks.get(index).shot();
        balls.add(newBall);
    }

    public void changeVelocity(int index, Side side) {
        tanks.get(index).changeVelocity(side);
    }
    public void changeSize(int index, Side side) {
        tanks.get(index).changeSize(side);
    }

    public Landscape getLandscape() {
        return landscape;
    }

    public ArrayList<Tank> getTanks() {
        return tanks;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    @Override
    public String toString() {
        return tanks.size() + " " + tanksToString() + balls.size() + " " + ballsToString() + " " + isGameOver;
    }

    private String tanksToString() {
        String s = "";
        for (int i = 0; i < tanks.size(); i++) {
            s += tanks.get(i).toString();
        }
        return s;
    }

    private String ballsToString() {
        String s = "";
        for (Ball ball: balls) {
            s += ball.toString();
        }
        return s;
    }

    public boolean isGameOver() {
        long time = System.currentTimeMillis();
        for (Ball ball: balls) {
            int x = ball.newXCoordinate(ball.timeFromStart(time));
            int y = ball.newYCoordinate(ball.timeFromStart(time));
            for (Tank tank: tanks) {
                int tankX = tank.getLocationX();
                int tankY = landscape.getMountainHeight(tankX);
                if (Math.abs(x - tankX) < 15 && Math.abs(y - tankY) < 15) {
                    isGameOver = true;
                    return true;
                }
            }
        }
        return false;
    }
}
