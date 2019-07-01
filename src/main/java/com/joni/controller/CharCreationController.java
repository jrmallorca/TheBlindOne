package com.joni.controller;

import com.joni.AlphaNumericTextFormatter;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CharCreationController implements Initializable {

    @FXML
    public TextField textField;

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textField.setTextFormatter(new AlphaNumericTextFormatter(20));
    }

    // If name.length >= 1, ask player if they're sure of the name chosen
    @FXML
    public void checkLength(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER)
            if (textField.getText().length() > 0) {
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                confirmation(window);
            }
    }

    private void confirmation(Stage window) throws IOException {
        Stage popUp = new Stage();
        popUp.initStyle(StageStyle.UNDECORATED); // Makes sure that window has no minimize, exit, etc. buttons
        popUp.initModality(Modality.APPLICATION_MODAL); // Window process has to be completed before being able to interact with parent window
        popUp.initOwner(window);

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Confirmation.fxml"));
        parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        popUp.setScene(new Scene(parent));
        popUp.show();
    }
}
