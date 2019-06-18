package com.joni.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScreenController {

    // Changes screen to TitleScreen2.fxml
    public void pressToContinue(ActionEvent event) throws IOException {
        Parent titleScreen2Parent = FXMLLoader.load(getClass().getResource("TitleScreen2.fxml"));
        Scene titleScreen2Scene = new Scene(titleScreen2Parent);

        // Get stage information (Look at start() in Main.java)
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(titleScreen2Scene);
        window.show();
    }

}
