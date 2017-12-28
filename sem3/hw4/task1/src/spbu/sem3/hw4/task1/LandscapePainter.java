package spbu.sem3.hw4.task1;

import java.awt.*;

public class LandscapePainter {
    private static final Color SKY_COLOR = new Color(135, 206, 235);
    private static final Color MOUNTAIN_COLOR = new Color(110, 123, 139);
    private static final int SIZE_X = 700;
    private static final int SIZE_Y = 500;

    public void paintLandscape(Graphics2D g, double[] X, double[] Y) {
        generateBackground(g);
        generateMountains(g, X, Y);
    }

    private void generateBackground(Graphics2D g) {
        g.setColor(SKY_COLOR);
        g.fillRect(0, 0, SIZE_X, SIZE_Y);
    }

    private void generateMountains(Graphics2D g, double[] X, double[] Y) {
        Polygon polygon = new Polygon();
        polygon.addPoint(0, SIZE_Y);
        for (int i = 0; i < X.length; i++) {
            polygon.addPoint((int) X[i], (int) Y[i]);
        }
        polygon.addPoint(SIZE_X, SIZE_Y);

        g.setColor(MOUNTAIN_COLOR);
        g.fillPolygon(polygon);
    }
}
