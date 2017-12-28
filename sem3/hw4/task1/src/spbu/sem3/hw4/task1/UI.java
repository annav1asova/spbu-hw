package spbu.sem3.hw4.task1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UI extends JPanel implements Runnable {
    GameState state;
    boolean running;

    private final static int SIZE_X = 700;
    private final static int SIZE_Y = 500;

    public UI() {
        state = new GameState();
        running = true;
    }

    public void print(GameState state) {
        this.state = state;
    }

    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D)graphics;
        if(state.isGameOver()) {
            running = false;
            g.setColor(Color.red);
            g.fillRect(0, 0, SIZE_X, SIZE_Y);
            g.setColor(Color.white);
            g.drawString("ВЗРЫВ", SIZE_X / 4, SIZE_Y / 4);
            g.drawString("GAME OVER", SIZE_X / 2, SIZE_Y / 2);
            return;
        }
        Landscape landscape = state.getLandscape();
        LandscapePainter landscapePainter = new LandscapePainter();
        landscapePainter.paintLandscape(g, landscape.getX(), landscape.getY());

        ArrayList<Tank> tanks = state.getTanks();
        for (int i = 0; i < tanks.size(); i++) {
            int locationX = tanks.get(i).getLocationX();
            double rotationOfBarrel = tanks.get(i).getRotationOfBarrel();
            TankPainter.paintTank(g, locationX, rotationOfBarrel, landscape);
        }

        ArrayList<Ball> balls = state.getBalls();
        BallPainter.paintBalls(g, balls);
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (running) {
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {}
        }
    }
}
