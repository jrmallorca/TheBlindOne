package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

import static com.joni.model.FXMLName.TITLE_SCREEN_2;

public class ControlsController extends MainWindowController {

    // Fields mainly for testing purposes
    @FXML
    private GridPane controls;

    ControlsController(Stage stage, WindowModel windowModel, HashMap<FXMLName, String> map) {
        super(stage, windowModel, map);
        setPathsFXML();
    }

    @FXML
    private void switchScene() throws IOException {
        Stage stage = getStage();
        WindowModel windowModel = getWindowModel();
        HashMap<FXMLName, String> mapFXML = getMapFXML();

        FXMLLoader loader = windowModel.getFXMLLoader(TITLE_SCREEN_2, mapFXML);
        loader.setControllerFactory(type -> new TitleScreen2Controller(stage, windowModel, mapFXML));
        windowModel.setSceneParent(stage, windowModel.getParent(loader));

        setNextRootID(stage.getScene().getRoot().getId());
    }

    @Override
    void setPathsFXML() {
        HashMap<FXMLName, String> mapFXML = getMapFXML();
        mapFXML.clear();
        mapFXML.put(TITLE_SCREEN_2, "/fxml/TitleScreen2.fxml");
    }
}
