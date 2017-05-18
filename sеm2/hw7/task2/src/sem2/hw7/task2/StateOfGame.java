package sem2.hw7.task2;

import java.util.ArrayList;

/** Class that helps to find out state of the current game */
public class StateOfGame {

    /**
     * method that checks whether the game is finished for X/O
     *
     * @param filled array with numbers of filled with some player's symbol buttons
     * @return true if the game is finished, false otherwise
     */
    public static boolean isTheGameFinished(ArrayList<Integer> filled) {
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
    private static boolean isDiagonalFilled(ArrayList<Integer> filled) {
        return (filled.contains(1) && filled.contains(5) && filled.contains(9)) || (filled.contains(3) && filled.contains(5) && filled.contains(7));
    }

    /** method that checks whether the column is filled
     *
     * @param indexOfColumn index of column
     * @param filled array with numbers of filled with some player's symbol buttons
     * @return true if this column is filled, false otherwise
     */
    private static boolean isColumnFilled(int indexOfColumn, ArrayList<Integer> filled) {
        return filled.contains(indexOfColumn) && filled.contains(indexOfColumn + 3) && filled.contains(indexOfColumn + 6);
    }

    /** method that checks whether the column is filled
     *
     * @param indexOfRow index of column
     * @param filled array with numbers of filled with some player's symbol buttons
     * @return true if this row is filled, false otherwise
     */
    private static boolean isRowFilled(int indexOfRow, ArrayList<Integer> filled) {
        return filled.contains(indexOfRow) && filled.contains(indexOfRow + 1) && filled.contains(indexOfRow + 2);
    }
}
