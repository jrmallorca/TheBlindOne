package com.joni.controller;

import com.joni.model.ConfirmModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmController implements Initializable {

    @FXML
    private Button yesButton;
    @FXML
    private Button noButton;
    @FXML
    private Label label;

    private Stage stage;
    private boolean switchScenePrompt;
    private String labelText;

    public ConfirmController(String labelText, Stage stage) {
        this.labelText = labelText;
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        label.setText(labelText);
    }

    // Depending on choice made (yes/no), execute appropriate action
    @FXML
    public void choiceMadeButton(ActionEvent actionEvent) {
        if (actionEvent.getSource() == yesButton)
            switchScenePrompt = true;
        stage.close();
    }

    public boolean isSwitchScenePrompt() {
        return switchScenePrompt;
    }

}
