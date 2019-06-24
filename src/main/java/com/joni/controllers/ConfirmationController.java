package com.joni.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ConfirmationController {

    public Button yesButton;

    // Depending on choice made (yes/no), execute appropriate action
    @FXML
    public void choiceMade(ActionEvent event) {
        Stage popUp = (Stage) ((Node)event.getSource()).getScene().getWindow();
        popUp.hide();

//        if (event.getSource() == yesButton) {
//
//        }
    }

}
