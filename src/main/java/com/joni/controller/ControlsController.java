package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static com.joni.model.FXMLName.TITLE_SCREEN_2;

public class ControlsController {

    private WindowModel windowModel;
    private final Map<FXMLName, String> fxmlPaths = Collections.singletonMap(TITLE_SCREEN_2, "/fxml/TitleScreen2.fxml");

    @FXML
    public void switchScene() throws IOException {
        // Load the FXML file and change the scene
        FXMLLoader loader = windowModel.getFXMLLoader(TITLE_SCREEN_2);
        windowModel.setSceneParent(windowModel.getParent(loader));

        // Get controller and set appropriate values for its fields
        TitleScreen2Controller controller = loader.getController();
        windowModel.setMap(controller.getFXMLPaths());
        controller.setWindowModel(windowModel);
    }

    Map<FXMLName, String> getFXMLPaths() {
        return fxmlPaths;
    }

    void setWindowModel(WindowModel model) {
        windowModel = model;
    }

}
