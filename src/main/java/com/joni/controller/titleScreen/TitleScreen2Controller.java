package com.joni.controller.titleScreen;

import com.joni.controller.CharCreationController;
import com.joni.controller.MainWindowController;
import com.joni.model.WindowModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.joni.controller.FXMLName.CHAR_CREATION;
import static com.joni.controller.FXMLName.CONTROLS;

public class TitleScreen2Controller extends MainWindowController {

    // Field(s) mainly for testing purposes
    @FXML
    private GridPane titleScreen2;

    @FXML
    private Button newGame;
    @FXML
    private Button controls;

    public TitleScreen2Controller(Stage stage, WindowModel windowModel) {
        super(stage, windowModel);
    }

    @FXML
    private void switchScene(ActionEvent event) throws IOException {
        Stage stage = getStage();
        WindowModel windowModel = getWindowModel();

        if (event.getSource() == newGame) {
            FXMLLoader loader = windowModel.getFXMLLoader(CHAR_CREATION);
            loader.setControllerFactory(type -> new CharCreationController(stage, windowModel));
            windowModel.setSceneParent(stage, windowModel.getParent(loader));
        } else {
            FXMLLoader loader = windowModel.getFXMLLoader(CONTROLS);
            loader.setControllerFactory(type -> new ControlsController(stage, windowModel));
            windowModel.setSceneParent(stage, windowModel.getParent(loader));
        }

        setNextRootID(stage.getScene().getRoot().getId());
    }

    @FXML
    private void exitGame() {
        getStage().close();
    }

}
