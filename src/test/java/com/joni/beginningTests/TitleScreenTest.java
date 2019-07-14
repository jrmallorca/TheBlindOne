package com.joni.beginningTests;

import com.joni.TestFXBase;
import com.joni.controller.titleScreen.TitleScreenController;
import com.joni.controller.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitleScreenTest extends TestFXBase {

    private TitleScreenController controller;

    @Override
    public void start(Stage stage) throws IOException {
        // Get relevant fields from TestFXBase
        WindowModel windowModel = getWindowModel();

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(FXMLName.TITLE_SCREEN);
        loader.setControllerFactory(type -> new TitleScreenController(stage, windowModel));

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
        clickOn("#pressToContinue");
        assertEquals("titleScreen2", controller.getNextRootID());
    }
}
