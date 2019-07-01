package com.joni.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleScreen2Controller {

    public Button newGame;
    public Button controls;

    // Switches scenes
    @FXML
    public void switchScene(ActionEvent event) throws IOException {
        Parent parent;

        if(event.getSource() == newGame) parent = FXMLLoader.load(getClass().getResource("/fxml/CharCreation.fxml"));
        else parent = FXMLLoader.load(getClass().getResource("/fxml/Controls.fxml"));

        parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        // Get stage information (Look at start() in Main.java)
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.getScene().setRoot(parent);
        window.show();
    }

    @FXML
    public void exitGame(ActionEvent event) {
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

}
