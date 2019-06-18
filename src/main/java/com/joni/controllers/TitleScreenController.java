package com.joni.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScreenController {

    // Changes screen to TitleScreen2.fxml
    @FXML
    public void pressToContinue(ActionEvent event) throws IOException {
        Parent titleScreen2Parent = FXMLLoader.load(getClass().getResource("/fxml/TitleScreen2.fxml"));

        titleScreen2Parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        // Get stage information (Look at start() in Main.java)
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.getScene().setRoot(titleScreen2Parent);
        window.show();
    }

}
