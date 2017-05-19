package test2.task1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class Main extends Application {

    int size = 4;
    private GridPane gridPane = new GridPane();
    private GenerateNumbers generator = new GenerateNumbers(size);
    private Button[][] buttons = new Button[size][size];

    private boolean[][] opened = new boolean[size][size];
    private int[][] values = generator.currentPairs;
    int currentStateOfGame = 0;
    int firstOpenedValue = 0;
    int firstOpenedIndexI = 0;
    int firstOpenedIndexJ = 0;
    int openedPairs = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        for (int row = 0 ; row < size ; row++ ){
            RowConstraints rc = new RowConstraints();
            rc.setFillHeight(true);
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }
        for (int col = 0 ; col < size; col++ ) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setFillWidth(true);
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        for (int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < size ; j++) {
                buttons[i][j] = createButton(i, j);
                grid.add(buttons[i][j], i, j);
            }
        }

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createButton(int i, int j) {
        Button button = new Button();
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        button.setOnAction(e -> {
            click(i, j);
        });
        return button;
    }


    public void click(int i, int j) {
        if (opened[i][j] == false && currentStateOfGame == 0) {
            opened[i][j] = true;
            currentStateOfGame = 1;
            firstOpenedValue = values[i][j];
            firstOpenedIndexI = i;
            firstOpenedIndexJ = j;
            buttons[i][j].setText(Integer.toString(values[i][j]));
        }

        else if (opened[i][j] == false && currentStateOfGame == 1) {
            opened[i][j] = true;
            buttons[i][j].setText(Integer.toString(values[i][j]));
            if (firstOpenedValue != values[i][j]) {
                //здесь надо как-то подождать секунду
                buttons[i][j].setText("");
                buttons[firstOpenedIndexI][firstOpenedIndexJ].setText("");
                opened[i][j] = false;
                opened[firstOpenedIndexI][firstOpenedIndexJ] = false;
            } else {
                openedPairs += 2;
            }
            currentStateOfGame = 0;
        }
        if (openedPairs == size * size) {
            System.out.println("Вы победили!");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
