package com.joni.controller.titleScreen;

import com.joni.controller.MainWindowController;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.joni.controller.FXMLName.TITLE_SCREEN_2;

public class TitleScreenController extends MainWindowController {

    // Field(s) mainly for testing purposes
    @FXML
    private GridPane titleScreen;

    @FXML
    private Button pressToContinue;

    public TitleScreenController(Stage stage, WindowModel windowModel) {
        super(stage, windowModel);
    }

    // TODO: 06/07/2019 I wonder if we can use getConstructor(Stage.class, WindowModel.class, HashMap<>.class).newInstance(stage, windowModel);
    // TODO: 06/07/2019 to replace the content in loader.setControllerFactory(...);
    // Check once you've tried implementing controllers for fight scenes
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
