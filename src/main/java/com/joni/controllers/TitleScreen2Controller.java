package com.joni.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class TitleScreen2Controller {

    // Changes screen to TitleScreen2.fxml
    @FXML
    public void exitGame(ActionEvent event) {
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }


}
