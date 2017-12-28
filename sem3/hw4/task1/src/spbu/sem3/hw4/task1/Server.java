package spbu.sem3.hw4.task1;

import javafx.geometry.Side;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Server {
    private List<Player> players =
            Collections.synchronizedList(new ArrayList<Player>());
    private ServerSocket server;
    private static GameState state;
    private static final int MAX_PLAYERS = 2;

    public Server() {
        try {
            server = new ServerSocket(8888);
            int index = 0;
            state = new GameState();

            while (index <= MAX_PLAYERS - 1) {
                Socket socket = server.accept();
                Player player = new Player(socket, index);
                index++;
                players.add(player);
                player.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }

    private class Player extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket socket;
        private int index;

        public Player(Socket socket, int index) {
            this.socket = socket;
            this.index = index;
            try {
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            try {
                String command = "";
                while (true) {
                    command = in.readLine();
                    handleCommand(index + " " + command);

                    synchronized(players) {
                        Iterator<Player> iter = players.iterator();
                        while(iter.hasNext()) {
                            Player next = (Player) iter.next();
                            next.out.println(state.toString());
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void handleCommand(String command) {
            String[] parts = command.split(" ");
            if (parts[0].equals("finish")) {
                System.out.println("game over server");
            }
            int index = Integer.parseInt(parts[0]);
            Side direction = null;
            switch (parts[1]) {
                case "JOIN":
                    state.join(index);
                    break;
                case "GO":
                    switch (parts[2]) {
                        case "LEFT":
                            direction = Side.LEFT;
                            break;
                        case "RIGHT":
                            direction = Side.RIGHT;
                            break;
                    }
                    state.go(index, direction);
                    break;
                case "BARREL":
                    switch (parts[2]) {
                        case "UP":
                            direction = Side.TOP;
                            break;
                        case "DOWN":
                            direction = Side.BOTTOM;
                            break;
                    }
                    state.moveGun(index, direction);
                    break;
                case "SHOT":
                    state.fire(index);
                    break;
                case "VELOCITY":
                    switch (parts[2]) {
                        case "UP":
                            direction = Side.TOP;
                            break;
                        case "DOWN":
                            direction = Side.BOTTOM;
                            break;
                    }
                    state.changeVelocity(index, direction);
                    break;
                case "SIZE":
                    switch (parts[2]) {
                        case "UP":
                            direction = Side.TOP;
                            break;
                        case "DOWN":
                            direction = Side.BOTTOM;
                            break;
                    }
                    state.changeSize(index, direction);
                    break;
            }
        }
    }
}