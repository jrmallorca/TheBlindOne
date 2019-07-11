package com.joni.controller;

import com.joni.AlphaNumericTextFormatter;
import com.joni.model.ConfirmModel;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.joni.controller.FXMLName.*;

public class CharCreationController extends MainWindowController implements Initializable {

    // Fields mainly for testing purposes
    @FXML
    private GridPane charCreation;

    @FXML
    private TextField textField;

    private ConfirmModel confirmModel;

    public CharCreationController(Stage stage, WindowModel windowModel) {
        super(stage, windowModel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textField.setTextFormatter(new AlphaNumericTextFormatter(20));
    }

    // If name.length >= 1, ask player if they're sure of the name chosen
    @FXML
    private void checkLength(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            if (getTextFieldText().length() > 0) {
                confirmModel = new ConfirmModel();
                if (confirmModel.confirm(getStage(), getWindowModel().getFXMLLoader(CONFIRM)))
                    switchScene();
            }
        }
    }

    private void switchScene() throws IOException {
        Stage stage = getStage();
        WindowModel windowModel = getWindowModel();

        FXMLLoader loader = windowModel.getFXMLLoader(INTRO);
        loader.setControllerFactory(type -> new IntroCutsceneController(stage, windowModel));
        windowModel.setSceneParent(stage, windowModel.getParent(loader));

        setNextRootID(stage.getScene().getRoot().getId());
    }

    public String getTextFieldText() {
        return textField.getText();
    }

}
