package spbu.sem3.hw3.task1;

import javafx.geometry.Side;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.*;

public class KeyInputHandler implements KeyListener {
    Tank tank;
    Game game;
    KeyInputHandler(Game game) {
        this.game = game;
        tank = game.getTank();
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case VK_LEFT:
                tank.go(Side.LEFT);
                game.repaint();
                break;
            case VK_RIGHT:
                tank.go(Side.RIGHT);
                game.repaint();
                break;
            case VK_UP:
                tank.moveBarrel(Side.TOP);
                game.repaint();
                break;
            case VK_DOWN:
                tank.moveBarrel(Side.BOTTOM);
                game.repaint();
                break;
            case VK_ENTER:
                tank.shot();
                game.repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}