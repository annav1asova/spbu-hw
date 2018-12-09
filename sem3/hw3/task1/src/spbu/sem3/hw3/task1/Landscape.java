package spbu.sem3.hw3.task1;

import java.awt.*;

public class Landscape {
    private static final double X[] = {0, 100, 200, 350, 400, 470, 500, 530, 600, 700};
    private static final double Y[] = {250, 230, 200, 240, 300, 250, 100, 120, 350, 400};
    
    private static final Color SKY_COLOR = new Color(135, 206, 235);
    private static final Color MOUNTAIN_COLOR = new Color(110, 123, 139);
    private static final int SIZE_X = 700;
    private static final int SIZE_Y = 500;

    public void paint(Graphics g) {
        Graphics2D g1 = (Graphics2D)g;
        generateBackground(g1);
        generateMountains(g1);
    }

    private void generateBackground(Graphics2D g) {
        g.setColor(SKY_COLOR);
        g.fillRect(0, 0, SIZE_X, SIZE_Y);
    }

    private void generateMountains(Graphics2D g) {
        Polygon polygon = new Polygon();
        polygon.addPoint(0, SIZE_Y);
        for (int i = 0; i < X.length; i++) {
            polygon.addPoint((int) X[i], (int) Y[i]);
        }
        polygon.addPoint(SIZE_X, SIZE_Y);

        g.setColor(MOUNTAIN_COLOR);
        g.fillPolygon(polygon);

    }

    public int getMountainHeight(int place) {
        for (int i = 0; i < X.length - 1; i++) {
            if (X[i] <= place && place < X[i + 1]) {
                return (int)(Y[i] + (place - X[i]) * ((Y[i + 1] - Y[i]) / (X[i + 1] - X[i])));
            }
        }
        return 0;
    }
}
