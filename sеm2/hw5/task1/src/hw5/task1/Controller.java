package hw5.task1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/** Class for controller */
public class Controller implements Initializable {
    @FXML
    private Spinner firstArgument;

    @FXML
    private Spinner secondArgument;

    @FXML
    private ComboBox<String> operation;

    @FXML
    private TextField resultField;

    ObservableList<String> options = FXCollections.observableArrayList("+", "-", "*", "/");

    private Calculator calculator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        operation.setItems(options);
        operation.setValue("+");

        calculator = new Calculator();
        int min = calculator.getMin();
        int max = calculator.getMax();

        firstArgument.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max));
        secondArgument.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max));
    }

    /** method that recounts value of expression if anything changes */
    public void recount() {
        int firstArgumentValue = (Integer)firstArgument.getValue();
        int secondArgumentValue = (Integer)secondArgument.getValue();

        char operationValue = operation.getValue().charAt(0);

        resultField.setText(String.valueOf(calculator.count(firstArgumentValue, secondArgumentValue, operationValue)));
    }
}

