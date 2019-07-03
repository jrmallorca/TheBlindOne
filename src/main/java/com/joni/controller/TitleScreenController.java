package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

import static com.joni.model.FXMLName.TITLE_SCREEN_2;

public class TitleScreenController extends MainWindowController {

    public TitleScreenController(Stage stage, WindowModel windowModel, HashMap<FXMLName, String> map) {
        super(stage, windowModel, map);
        setPathsFXML();
    }

    @FXML
    public void switchScene() throws IOException {
        Stage window = getStage();
        WindowModel windowModel = getWindowModel();
        HashMap<FXMLName, String> mapFXML = getMapFXML();

        FXMLLoader loader = windowModel.getFXMLLoader(TITLE_SCREEN_2, mapFXML);
        loader.setControllerFactory(type -> new TitleScreen2Controller(window, windowModel, mapFXML));
        windowModel.setSceneParent(window, windowModel.getParent(loader));
    }

    @Override
    void setPathsFXML() {
        HashMap<FXMLName, String> mapFXML = getMapFXML();
        mapFXML.clear();
        mapFXML.put(TITLE_SCREEN_2, "/fxml/TitleScreen2.fxml");
    }
}
