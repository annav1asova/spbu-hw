package spbu.sem3.hw4.task1;

import java.util.ArrayList;

public class Deserialization {
    public static GameState deserialize(String s) {
        String array[] = s.split(" ");
        int numberOfTanks = Integer.parseInt(array[0]);
        ArrayList<Tank> tanks = new ArrayList<>();
        int k = 1;
        for (int i = 0; i < numberOfTanks; i++) {
            int x = Integer.parseInt(array[k++]);
            double rotation = Double.parseDouble(array[k++]);
            int velocityOfBalls = Integer.parseInt(array[k++]);
            int sizeOfBalls = Integer.parseInt(array[k++]);
            tanks.add(new Tank(new Landscape(), x, rotation, velocityOfBalls, sizeOfBalls));
        }
        int m = Integer.parseInt(array[k++]);
        ArrayList<Ball> balls = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            int startX = Integer.parseInt(array[k++]);
            int startY = Integer.parseInt(array[k++]);
            double angle = Double.parseDouble(array[k++]);
            long time = Long.parseLong(array[k++]);
            double velocity = Double.parseDouble(array[k++]);
            int size = Integer.parseInt(array[k++]);

            Ball ball = new Ball(startX, startY, angle, time, velocity, size);
            balls.add(ball);
        }

        boolean isGameOver = Boolean.parseBoolean(array[k++]);

        GameState state = new GameState(new Landscape(), tanks, balls, isGameOver);
        return state;
    }
}
