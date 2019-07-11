package com.joni.controller;

import com.joni.model.WindowModel;
import javafx.stage.Stage;

abstract class MainWindowController {

    // TODO: 09/07/2019 Consider making these fields static 
    private Stage stage;
    private WindowModel windowModel;

    // Fields mainly for testing purposes
    private String nextRootID; // Checks if scene switches properly

    MainWindowController(Stage stage, WindowModel windowModel) {
        this.stage = stage;
        this.windowModel = windowModel;
    }

    Stage getStage() {
        return stage;
    }

    WindowModel getWindowModel() {
        return windowModel;
    }

    public String getNextRootID() {
        return nextRootID;
    }

    void setNextRootID(String nextRootID) {
        this.nextRootID = nextRootID;
    }
}
