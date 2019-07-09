package com.joni.controller;

import com.joni.AlphaNumericTextFormatter;
import com.joni.model.ConfirmModel;
import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import static com.joni.model.FXMLName.CONFIRM;

public class CharCreationController extends MainWindowController implements Initializable {

    // Fields mainly for testing purposes
    @FXML
    private GridPane charCreation;

    @FXML
    private TextField textField;

    private ConfirmModel confirmModel;

    CharCreationController(Stage stage, WindowModel windowModel, HashMap<FXMLName, String> map) {
        super(stage, windowModel, map);
        setPathsFXML();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textField.setTextFormatter(new AlphaNumericTextFormatter(20));
    }

    // If name.length >= 1, ask player if they're sure of the name chosen
    @FXML
    private void checkLength(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            if (textField.getText().length() > 0) {
                confirmModel = new ConfirmModel();
                if (confirmModel.confirm(getStage(), getWindowModel().getFXMLLoader(CONFIRM, getMapFXML())))
                    switchScene();
            }
        }
    }

    private void switchScene() throws IOException {
        // TODO: 03/07/2019 Add the next FXML later
        System.out.println("Working");

//        setNextRootID(stage.getScene().getRoot().getId());
    }

    @Override
    void setPathsFXML() {
        // TODO: 03/07/2019 Add next fxml scenes
        HashMap<FXMLName, String> mapFXML = getMapFXML();
        mapFXML.clear();
        mapFXML.put(CONFIRM, "/fxml/Confirm.fxml");
    }

}
