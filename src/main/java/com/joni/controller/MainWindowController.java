package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.stage.Stage;

import java.util.HashMap;

abstract class MainWindowController {

    private Stage stage;
    private WindowModel windowModel;
    private HashMap<FXMLName, String> mapFXML;

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

    abstract void setPathsFXML();

}
