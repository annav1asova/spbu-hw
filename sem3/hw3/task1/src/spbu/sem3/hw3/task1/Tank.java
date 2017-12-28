package spbu.sem3.hw3.task1;

import javafx.geometry.Side;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import static javafx.geometry.Side.*;

public class Tank extends JPanel {
    private Landscape landscape;
    private Point location;
    private double rotationOfBarrel;
    private ArrayList<Ball> balls;

    private static final int TANK_WIDTH = 50;
    private static final int TANK_HEIGHT = 20;
    private static final int BARREL_WIDTH = 30;
    private static final int BARREL_HEIGHT = 7;
    private static final Color TANK_COLOR = new Color(238, 101, 197);
    private static final int TANK_STEP = 5;
    private static final double BARREL_STEP = 0.1;

    public Tank(Landscape landscape) {
        this.landscape = landscape;
        int x = 50;
        location = new Point(x, landscape.getMountainHeight(x));
        rotationOfBarrel = Math.toRadians(45);
        balls = new ArrayList<>();
    }

    public void go(Side side) {
        if (side == LEFT)
            location.x-= TANK_STEP;
        else if (side == RIGHT)
            location.x += TANK_STEP;
        location.y = landscape.getMountainHeight(location.x);
        repaint();
    }

    public void moveBarrel(Side side) {
       if (side == TOP) {
           rotationOfBarrel -= BARREL_STEP;
       } else if (side == BOTTOM){
           rotationOfBarrel += BARREL_STEP;
       }
       repaint();
    }

    public void shot() {
        double cos = Math.cos(rotationOfBarrel);
        double sin = Math.sin(rotationOfBarrel);
        int startX = location.x + (int)(BARREL_WIDTH * cos);
        int startY = location.y - (int)(BARREL_WIDTH * sin);
        balls.add(new Ball(startX, startY, rotationOfBarrel));
    }

    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;
        paintTank(g);
        paintBarrel(g);
        paintBalls(g);
    }

    private void paintTank(Graphics2D g) {
        g.setColor(TANK_COLOR);
        g.fillOval(location.x - TANK_WIDTH / 2, location.y - TANK_HEIGHT / 2, TANK_WIDTH, TANK_HEIGHT);
    }

    private void paintBarrel(Graphics2D g) {
//        AffineTransform tx = AffineTransform.getRotateInstance(rotationOfBarrel, location.x, location.y);
//        g.setTransform(tx);
//        g.fillRect(location.x, location.y - BARREL_HEIGHT / 2, BARREL_WIDTH, BARREL_HEIGHT);
//        g.setTransform(new AffineTransform());
        g.setStroke(new BasicStroke(BARREL_HEIGHT));
        g.drawLine(location.x, location.y, location.x + (int)(Math.cos(rotationOfBarrel) * BARREL_WIDTH), location.y - (int)(Math.sin(rotationOfBarrel) * BARREL_WIDTH));

    }

    private void paintBalls(Graphics2D g) {
        Iterator iterator = balls.iterator();
        Ball ball = null;
        while (iterator.hasNext()) {
            ball = (Ball)iterator.next();
            boolean hasToBePainted = ball.paint(g, System.currentTimeMillis());
            if (!hasToBePainted) {
                iterator.remove();
            }
        }
    }
}
