import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable{
    private Landscape landscape;
    private Tank tank;
    private boolean running;

    public Game(Landscape landscape, Tank tank) {
        this.landscape = landscape;
        this.tank = tank;
    }

    public Tank getTank() {
        return tank;
    }

    public void paint(Graphics g) {
        landscape.paint(g);
        tank.paint(g);
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
                Thread.sleep(50);
            } catch (InterruptedException ex) {}
        }
    }
}
