package com.joni.beginningTests;

import com.joni.TestFXBase;
import com.joni.controller.titleScreen.ControlsController;
import com.joni.model.WindowModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.joni.controller.FXMLName.CONTROLS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlsTest extends TestFXBase {

    private ControlsController controller;

    @Override
    public void start(Stage stage) throws IOException {
        // Get relevant fields from TestFXBase
        WindowModel windowModel = getWindowModel();

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(CONTROLS);
        loader.setControllerFactory(type -> new ControlsController(stage, windowModel));

        // Create an instance of a scene and set it to the stage
        stage.setScene(new Scene(windowModel.getParent(loader)));
        controller = loader.getController();

        // Set the settings for the stage
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    @Test
    void testSwitchSceneCorrectly() {
        clickOn("#backToMenu");
        assertEquals("titleScreen2", controller.getNextRootID());
    }

}
