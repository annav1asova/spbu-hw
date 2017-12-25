import java.awt.*;

public class Ball {
    private int startX;
    private int startY;
    private double angle;
    private long startTime;
    private final static double VELOCITY = 60;
    private final static double COEFFICIENT_TIME = 4;
    private final static double g = 9.8;
    private final static int SIZE_X = 700;
    private final static int SIZE_Y = 500;
    private final static int BALL_SIZE = 10;

    public Ball(int x, int y, double angle) {
        startX = x;
        startY = y;
        this.angle = angle;
        startTime = System.currentTimeMillis();
    }

    public boolean paint(Graphics2D g, long time) {
        double t = timeFromStart(time);
        int x = newXCoordinate(t);
        int y = newYCoordinate(t);
        g.fillOval(x - BALL_SIZE / 2, y - BALL_SIZE / 2, BALL_SIZE, BALL_SIZE);
        return isBallOnScreen(x, y);
    }

    private boolean isBallOnScreen(int x, int y) {
        return (x > 0 && x < SIZE_X && y > 0 && y < SIZE_Y);
    }

    private int newXCoordinate(double time) {
        return (int)(startX + VELOCITY * Math.cos(angle) * time);
    }

    private int newYCoordinate(double time) {
        return (int)(startY + VELOCITY * Math.sin(angle) * time + g *  time * time / 2.0);
    }

    private double timeFromStart(long time) {
        return COEFFICIENT_TIME * (time - startTime) / 1000.0;
    }
}
