package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.stage.Stage;

import java.util.HashMap;

abstract class MainWindowController {

    // TODO: 09/07/2019 Consider making these fields static 
    private Stage stage;
    private WindowModel windowModel;
    private HashMap<FXMLName, String> mapFXML;

    // Fields mainly for testing purposes
    private String nextRootID; // Checks if scene switches properly

    MainWindowController(Stage stage, WindowModel windowModel, HashMap<FXMLName, String> map) {
        this.stage = stage;
        this.windowModel = windowModel;
        mapFXML = map;
    }

    Stage getStage() {
        return stage;
    }

    WindowModel getWindowModel() {
        return windowModel;
    }

    HashMap<FXMLName, String> getMapFXML() {
        return mapFXML;
    }

    public String getNextRootID() {
        return nextRootID;
    }

    abstract void setPathsFXML();

    void setNextRootID(String nextRootID) {
        this.nextRootID = nextRootID;
    }
}
