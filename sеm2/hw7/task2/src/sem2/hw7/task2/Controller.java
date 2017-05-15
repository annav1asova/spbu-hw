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

    /** method that processes event of clicking on buttons */
    public void click(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (button.getText().length() == 0 && !isFinished) {
            switch (opened % 2) {
                case 0:
                    button.setText("X");
                    infoField.setText("Ход игрока O");
                    arrayX.add(Integer.parseInt(button.getId()));
                    if (isTheGameFinished(arrayX)) {
                        infoField.setText("X победил!");
                        isFinished = true;
                    }
                    break;
                case 1:
                    button.setText("O");
                    infoField.setText("Ход игрока X");
                    arrayO.add(Integer.parseInt(button.getId()));
                    if (isTheGameFinished(arrayO)) {
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

    /**
     * method that checks whether the game is finished for X/O
     *
     * @param filled array with numbers of filled with some player's symbol buttons
     * @return true if the game is finished, false otherwise
     */
    public boolean isTheGameFinished(ArrayList<Integer> filled) {
        if (filled.size() >= 3) {
            for (int i = 1; i <= 7; i += 3) {
                if (isRowFilled(i, filled)) {
                    return true;
                }
            }
            for (int i = 1; i <= 3; i++) {
                if (isColumnFilled(i, filled)) {
                    return true;
                }
            }
            if (isDiagonalFilled(filled)) {
                return true;
            }
        }
        return false;
    }

    /**
     * method that checks whether the diagonal is filled
     *
     * @param filled array with numbers of filled with some player's symbol buttons
     * @return true if some diagonal is filled, false otherwise
     */
    private boolean isDiagonalFilled(ArrayList<Integer> filled) {
        return (filled.contains(1) && filled.contains(5) && filled.contains(9)) || (filled.contains(3) && filled.contains(5) && filled.contains(7));
    }

    /** method that checks whether the column is filled
     *
     * @param indexOfColumn index of column
     * @param filled array with numbers of filled with some player's symbol buttons
     * @return true if this column is filled, false otherwise
     */
    private boolean isColumnFilled(int indexOfColumn, ArrayList<Integer> filled) {
        return filled.contains(indexOfColumn) && filled.contains(indexOfColumn + 3) && filled.contains(indexOfColumn + 6);
    }

    /** method that checks whether the column is filled
     *
     * @param indexOfRow index of column
     * @param filled array with numbers of filled with some player's symbol buttons
     * @return true if this row is filled, false otherwise
     */
    private boolean isRowFilled(int indexOfRow, ArrayList<Integer> filled) {
        return filled.contains(indexOfRow) && filled.contains(indexOfRow + 1) && filled.contains(indexOfRow + 2);
    }
}
