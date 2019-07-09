package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

import static com.joni.model.FXMLName.CHAR_CREATION;
import static com.joni.model.FXMLName.CONTROLS;

public class TitleScreen2Controller extends MainWindowController {

    // Fields mainly for testing purposes
    @FXML
    private GridPane titleScreen2;

    @FXML
    private Button newGame;
    @FXML
    private Button controls;

    public TitleScreen2Controller(Stage stage, WindowModel windowModel, HashMap<FXMLName, String> map) {
        super(stage, windowModel, map);
        setPathsFXML();
    }

    @FXML
    private void switchScene(ActionEvent event) throws IOException {
        Stage stage = getStage();
        WindowModel windowModel = getWindowModel();
        HashMap<FXMLName, String> mapFXML = getMapFXML();

        if (event.getSource() == newGame) {
            FXMLLoader loader = windowModel.getFXMLLoader(CHAR_CREATION, mapFXML);
            loader.setControllerFactory(type -> new CharCreationController(stage, windowModel, mapFXML));
            windowModel.setSceneParent(stage, windowModel.getParent(loader));
        } else {
            FXMLLoader loader = windowModel.getFXMLLoader(CONTROLS, mapFXML);
            loader.setControllerFactory(type -> new ControlsController(stage, windowModel, mapFXML));
            windowModel.setSceneParent(stage, windowModel.getParent(loader));
        }

        setNextRootID(stage.getScene().getRoot().getId());
    }

    @FXML
    private void exitGame() {
        getStage().close();
    }

    @Override
    void setPathsFXML() {
        HashMap<FXMLName, String> mapFXML = getMapFXML();
        mapFXML.clear();
        mapFXML.put(CHAR_CREATION, "/fxml/CharCreation.fxml");
        mapFXML.put(CONTROLS, "/fxml/Controls.fxml");
    }

}
