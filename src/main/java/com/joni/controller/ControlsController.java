package com.joni.controller;

import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.joni.controller.FXMLName.TITLE_SCREEN_2;

public class ControlsController extends MainWindowController {

    // Fields mainly for testing purposes
    @FXML
    private GridPane controls;

    @FXML
    private Button backToMenu;

    public ControlsController(Stage stage, WindowModel windowModel) {
        super(stage, windowModel);
    }

    @FXML
    private void switchScene() throws IOException {
        Stage stage = getStage();
        WindowModel windowModel = getWindowModel();

        FXMLLoader loader = windowModel.getFXMLLoader(TITLE_SCREEN_2);
        loader.setControllerFactory(type -> new TitleScreen2Controller(stage, windowModel));
        windowModel.setSceneParent(stage, windowModel.getParent(loader));

        setNextRootID(stage.getScene().getRoot().getId());
    }

}
