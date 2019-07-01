package com.joni.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScreenController {

    // Changes screen to TitleScreen2.fxml
    // Does this by swapping parents rather than creating a new scene
    @FXML
    public void switchScene(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/TitleScreen2.fxml"));
        parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        // Get stage information (Look at start() in Main.java)
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.getScene().setRoot(parent);
        window.show();
    }

}
