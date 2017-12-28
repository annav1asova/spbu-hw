package spbu.sem3.hw4.task1;

public class Landscape {
    private static final double X[] = {0, 100, 200, 350, 400, 470, 500, 530, 600, 700};
    private static final double Y[] = {250, 230, 200, 240, 300, 250, 100, 120, 350, 400};

    public static double[] getX() {
        return X;
    }

    public static double[] getY() {
        return Y;
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