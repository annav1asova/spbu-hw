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
            boolean hasToBePainted = paintBall(g, ball);
            if (!hasToBePainted) {
                iterator.remove();
            }
        }
    }

    private static boolean paintBall(Graphics2D g, Ball ball) {
        long time = System.currentTimeMillis();
        double t = ball.timeFromStart(time);
        int x = ball.newXCoordinate(t);
        int y = ball.newYCoordinate(t);
        int ballSize = ball.getSize();
        g.fillOval(x - ballSize / 2, y - ballSize / 2, ballSize, ballSize);
        return ball.isBallOnScreen(x, y);
    }
}
