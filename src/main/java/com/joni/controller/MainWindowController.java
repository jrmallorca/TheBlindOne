package com.joni.controller;

import com.joni.model.WindowModel;
import javafx.stage.Stage;

public abstract class MainWindowController {

    // TODO: 09/07/2019 Consider making these fields static 
    private Stage stage;
    private WindowModel windowModel;

    // Field(s) mainly for testing purposes
    private String nextRootID; // Checks if scene switches properly

    protected MainWindowController(Stage stage, WindowModel windowModel) {
        this.stage = stage;
        this.windowModel = windowModel;
    }

    protected Stage getStage() {
        return stage;
    }

    protected WindowModel getWindowModel() {
        return windowModel;
    }

    public String getNextRootID() {
        return nextRootID;
    }

    protected void setNextRootID(String nextRootID) {
        this.nextRootID = nextRootID;
    }
}
