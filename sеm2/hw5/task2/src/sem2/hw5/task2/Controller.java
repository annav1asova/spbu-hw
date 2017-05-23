package sem2.hw5.task2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/** Class for controller */
public class Controller {
    @FXML
    private TextField resultField;

    private boolean isOperationChosen = false;
    private double firstOperandValue = 0;
    private double secondOperandValue = 0;
    private char operation = '+';

    Calculator calculator = new Calculator();

    /** method called when you click on digit-button */
    public void argumentClick(ActionEvent actionEvent) {
        Button operand = (Button) actionEvent.getSource();
        if (isOperationChosen) {
            resultField.setText(operand.getText());
            isOperationChosen = false;
        } else {
            resultField.setText(resultField.getText() + operand.getText());
        }
    }

    /** method called when you click on operation-button */
    public void operationClick(ActionEvent actionEvent) {
        String firstOperand = resultField.getText();
        firstOperandValue = Double.parseDouble(resultField.getText());
        Button operationButton = (Button) actionEvent.getSource();
        operation = operationButton.getText().charAt(0);
        isOperationChosen = true;
    }

    /** method that recounts value of expression, called when '=' is pressed */
    public void recount(ActionEvent actionEvent) {
        String secondOperand = resultField.getText();
        secondOperandValue = Double.parseDouble(resultField.getText());
        resultField.setText(Double.toString(calculator.count(firstOperandValue, secondOperandValue, operation)));
    }

    /** method that clears all fields */
    public void clear(ActionEvent actionEvent) {
        firstOperandValue = 0;
        secondOperandValue = 0;
        operation = '+';
        isOperationChosen = false;
        resultField.setText("");
    }
}
