import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pink Tank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setResizable(false);

        Landscape landscape = new Landscape();
        Tank tank = new Tank(landscape);
        Game game = new Game(landscape, tank);

        frame.add(game);
        game.start();
        frame.addKeyListener(new KeyInputHandler(game));

        frame.setVisible(true);
    }
}