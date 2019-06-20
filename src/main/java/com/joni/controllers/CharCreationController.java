package com.joni.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public class CharCreationController {

    // If name.length >= 1, ask player if they're sure of the name chosen
    @FXML
    public void checkLength(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER)
            if (event.getText().length() > 0) confirmation(event);
    }

    private void confirmation(KeyEvent event) throws IOException {
        Popup popUp = new Popup();

        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Confirmation.fxml"));
        parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        // Get stage information (Look at start() in Main.java)
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        popUp.getScene().setRoot(parent);
        popUp.show(window);
    }

}
