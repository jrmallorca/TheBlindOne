package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.joni.model.FXMLName.CHAR_CREATION;
import static com.joni.model.FXMLName.CONTROLS;

public class TitleScreen2Controller {

    @FXML
    private Button newGame;
    @FXML
    private Button controls;

    private WindowModel windowModel;
    private final Map<FXMLName, String> fxmlPaths = new HashMap<>();

    // Switches scenes
    @FXML
    public void switchScene(ActionEvent event) throws IOException {
        if (event.getSource() == newGame) {
            // Load the FXML file and change the scene
            FXMLLoader loader = windowModel.getFXMLLoader(CHAR_CREATION);
            windowModel.setSceneParent(windowModel.getParent(loader));

            // Get controller and set appropriate values for its fields
            CharCreationController controller = loader.getController();
            windowModel.setMap(controller.getFXMLPaths());
            controller.setWindowModel(windowModel);
        } else {
            // Load the FXML file and change the scene
            FXMLLoader loader = windowModel.getFXMLLoader(CONTROLS);
            windowModel.setSceneParent(windowModel.getParent(loader));

            // Get controller and set appropriate values for its fields
            ControlsController controller = loader.getController();
            windowModel.setMap(controller.getFXMLPaths());
            controller.setWindowModel(windowModel);
        }
    }

    @FXML
    public void exitGame(ActionEvent event) {
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.close();
    }

    Map<FXMLName, String> getFXMLPaths() {
        fxmlPaths.put(CHAR_CREATION, "/fxml/CharCreation.fxml");
        fxmlPaths.put(CONTROLS, "/fxml/Controls.fxml");
        return fxmlPaths;
    }

    void setWindowModel(WindowModel model) {
        windowModel = model;
    }

}
