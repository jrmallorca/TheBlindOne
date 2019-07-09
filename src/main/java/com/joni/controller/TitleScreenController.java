package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

import static com.joni.model.FXMLName.TITLE_SCREEN_2;

public class TitleScreenController extends MainWindowController {

    // Fields mainly for testing purposes
    @FXML
    private GridPane titleScreen;

    @FXML
    private Button pressToContinue;

    public TitleScreenController(Stage stage, WindowModel windowModel, HashMap<FXMLName, String> map) {
        super(stage, windowModel, map);
        setPathsFXML();
    }

    // TODO: 06/07/2019 I wonder if we can use getConstructor(Stage.class, WindowModel.class, HashMap<>.class).newInstance(stage, windowModel, mapFXML);
    // TODO: 06/07/2019 to replace the content in loader.setControllerFactory(...);
    // Check once you've tried implementing controllers for fight scenes
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
