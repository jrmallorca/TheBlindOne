package com.joni.controller;

import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IntroCutsceneController extends MainWindowController {

    // Fields mainly for testing purposes
    @FXML
    private GridPane introCutscene;
    
    public IntroCutsceneController(Stage stage, WindowModel model) {
        // TODO: 11/07/2019 Change it so it can save the player name 
        super(stage, model);
    }
    
}
