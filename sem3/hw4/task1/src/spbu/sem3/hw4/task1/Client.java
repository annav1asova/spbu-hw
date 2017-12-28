package spbu.sem3.hw4.task1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Client {
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;
    private JFrame frame = new JFrame("Pink Tanks");
    private UI ui;

    public Client() throws FileNotFoundException {
        ui = new UI();

        try {
            socket = new Socket("127.0.0.1", 8888);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //in = new ObjectInputStream(socket.getInputStream());
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("JOIN");

            JLabel rulesFirstPart = new JLabel("Use up and down arrows to rotate gun; left and right arrows to move tank.");
            JLabel rulesSecondPart  = new JLabel("Use S and W keys to change velocity of balls; A and D keys to change their size");

            Container board = frame.getContentPane();
            board.setLayout(new BoxLayout(board, BoxLayout.Y_AXIS));
            board.add(ui);
            ui.start();
            board.add(rulesFirstPart);
            board.add(rulesSecondPart);

            Resender resend = new Resender();
            resend.start();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setResizable(false);
            frame.addKeyListener(new KeyInputHandler(out));
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Client();
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Потоки не были закрыты!");
        }
    }

    private class Resender extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    //System.out.println("получаю состояние в клиенте");
                    String s = in.readLine();
                    GameState state = Deserialization.deserialize(s);
                    ui.print(state);
                }
            } catch (IOException e) {
                System.err.println("Ошибка при получении сообщения.");
                e.printStackTrace();
            } finally {
               close();
            }
        }
    }
}