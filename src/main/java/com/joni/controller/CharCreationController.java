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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class CharCreationController extends MainWindowController implements Initializable {

    @FXML
    public TextField textField;

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
    public void checkLength(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            if (textField.getText().length() > 0) {
                confirmModel = new ConfirmModel();
                if (confirmModel.confirm(getStage(), getWindowModel().getFXMLLoader(FXMLName.CONFIRM, getMapFXML())))
                    switchScene();
            }
        }
    }

    @FXML
    private void switchScene() throws IOException {
        // TODO: 03/07/2019 Add the next FXML later
        // switchScene();
        System.out.println("Working");
    }

    @Override
    void setPathsFXML() {
        // TODO: 03/07/2019 Add next fxml scenes
        HashMap<FXMLName, String> mapFXML = getMapFXML();
        mapFXML.clear();
        mapFXML.put(FXMLName.CONFIRM, "/fxml/Confirm.fxml");
    }

}
