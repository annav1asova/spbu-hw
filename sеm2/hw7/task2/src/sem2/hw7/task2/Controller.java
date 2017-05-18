package sem2.hw7.task2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

/** Class for controller of application */
public class Controller {
    /** label for field with information */
    @FXML
    private Label infoField;

    /** number of opened cells */
    private int opened = 0;
    /** this variable is true of the game is finished, false otherwise */
    private boolean isFinished = false;

    /** array with numbers of buttons, where there is 'X' */
    ArrayList<Integer> arrayX = new ArrayList<>();
    /** array with numbers of buttons, where there is 'O' */
    ArrayList<Integer> arrayO = new ArrayList<>();

    ArrayList<Button> buttons = new ArrayList<>();

    /** method that processes event of clicking on buttons */
    public void click(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (button.getText().length() == 0 && !isFinished) {
            buttons.add(button);
            switch (opened % 2) {
                case 0:
                    button.setText("X");
                    infoField.setText("Ход игрока O");
                    arrayX.add(Integer.parseInt(button.getId()));
                    if (StateOfGame.isTheGameFinished(arrayX)) {
                        infoField.setText("X победил!");
                        isFinished = true;
                    }
                    break;
                case 1:
                    button.setText("O");
                    infoField.setText("Ход игрока X");
                    arrayO.add(Integer.parseInt(button.getId()));
                    if (StateOfGame.isTheGameFinished(arrayO)) {
                        infoField.setText("O победил!");
                        isFinished = true;
                    }
                    break;
            }
            opened += 1;
            if (!isFinished && arrayO.size() + arrayX.size() == 9) {
                infoField.setText("Ничья");
            }
        }
    }

    public void newGame(ActionEvent actionEvent) {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setText("");
            arrayX.clear();
            arrayO.clear();
            isFinished = false;
            opened = 0;
            infoField.setText("Ход игрока X");
        }
    }
}
