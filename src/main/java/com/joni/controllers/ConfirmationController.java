package com.joni.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Popup;

public class ConfirmationController {

    public Button yesButton;

    // Depending on choice made (yes/no), execute appropriate action
    @FXML
    public void choiceMade(ActionEvent event) {
        Popup popUp = (Popup) ((Node)event.getSource()).getScene().getWindow();
        popUp.hide();

//        if (event.getSource() == yesButton) {
//
//        }
    }

}
