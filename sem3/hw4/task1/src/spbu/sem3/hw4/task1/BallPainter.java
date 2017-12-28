package spbu.sem3.hw4.task1;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class BallPainter {
    public static void paintBalls(Graphics2D g, ArrayList<Ball> balls) {
        Iterator iterator = balls.iterator();
        Ball ball = null;
        while (iterator.hasNext()) {
            ball = (Ball)iterator.next();
            boolean hasToBePainted = hasToBePainted(ball);
            if (!hasToBePainted) {
                iterator.remove();
            } else {
                paintBall(g, ball);
            }
        }
    }

    private static void paintBall(Graphics2D g, Ball ball) {
        long time = System.currentTimeMillis();
        double t = ball.timeFromStart(time);
        int x = ball.newXCoordinate(t);
        int y = ball.newYCoordinate(t);
        int ballSize = ball.getSize();
        g.fillOval(x - ballSize / 2, y - ballSize / 2, ballSize, ballSize);
    }

    private static boolean hasToBePainted(Ball ball) {
        long time = System.currentTimeMillis();
        double t = ball.timeFromStart(time);
        int x = ball.newXCoordinate(t);
        int y = ball.newYCoordinate(t);
        return !ball.isBallOnMountain(x, y);
    }
}
