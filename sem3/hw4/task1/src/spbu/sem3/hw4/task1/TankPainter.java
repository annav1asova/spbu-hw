package spbu.sem3.hw4.task1;

import java.awt.*;

public class TankPainter {
    private static final Color TANK_COLOR = new Color(238, 101, 197);
    private static final int TANK_WIDTH = 50;
    private static final int TANK_HEIGHT = 20;
    private static final int BARREL_WIDTH = 30;
    private static final int BARREL_HEIGHT = 7;

    public static void paintTank(Graphics2D g, int locationX, double rotationOfBarrel, Landscape landscape) {
        paintTankBody(g, locationX, landscape);
        paintBarrel(g, locationX, rotationOfBarrel, landscape);
    }

    private static void paintTankBody(Graphics2D g, int locationX, Landscape landscape) {
        g.setColor(TANK_COLOR);
        int locationY = landscape.getMountainHeight(locationX);
        g.fillOval(locationX - TANK_WIDTH / 2, locationY - TANK_HEIGHT / 2, TANK_WIDTH, TANK_HEIGHT);
    }

    private static void paintBarrel(Graphics2D g, int locationX, double rotationOfBarrel, Landscape landscape) {
        int locationY = landscape.getMountainHeight(locationX);
//        AffineTransform tx = AffineTransform.getRotateInstance(rotationOfBarrel, locationX, locationY);
//        g.setTransform(tx);
//        g.fillRect(locationX, locationY - BARREL_HEIGHT / 2, BARREL_WIDTH, BARREL_HEIGHT);
//        g.setTransform(new AffineTransform());
        g.setStroke(new BasicStroke(BARREL_HEIGHT));
        g.drawLine(locationX, locationY, locationX + (int)(Math.cos(rotationOfBarrel) * BARREL_WIDTH), locationY - (int)(Math.sin(rotationOfBarrel) * BARREL_WIDTH));
    }
}
