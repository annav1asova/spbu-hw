package spbu.sem3.hw4.task1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;

import static java.awt.event.KeyEvent.*;

public class KeyInputHandler extends KeyAdapter {
    PrintWriter out;
    KeyInputHandler(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case VK_LEFT:
                out.println("GO LEFT");
                break;
            case VK_RIGHT:
                out.println("GO RIGHT");
                break;
            case VK_UP:
                out.println("BARREL UP");
                break;
            case VK_DOWN:
                out.println("BARREL DOWN");
                break;
            case VK_ENTER:
                out.println("SHOT");
                break;
            case VK_S:
                out.println("VELOCITY DOWN");
                break;
            case VK_W:
                out.println("VELOCITY UP");
                break;
            case VK_A:
                out.println("SIZE DOWN");
                break;
            case VK_D:
                out.println("SIZE UP");
                break;
        }
    }
}