package com.joni.beginningTests;

import com.joni.TestFXBase;
import com.joni.controller.TitleScreen2Controller;
import com.joni.model.WindowModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.joni.controller.FXMLName.TITLE_SCREEN_2;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TitleScreen2Test extends TestFXBase {

    private TitleScreen2Controller controller;

    @Override
    public void start(Stage stage) throws IOException {
        // Get relevant fields from TestFXBase
        WindowModel windowModel = getWindowModel();

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(TITLE_SCREEN_2);
        loader.setControllerFactory(type -> new TitleScreen2Controller(stage, windowModel));

        // Create an instance of a scene and set it to the stage
        stage.setScene(new Scene(windowModel.getParent(loader)));
        controller = loader.getController();

        // Set the settings for the stage
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    @Test
    void testSwitchSceneCorrectly1() {
        clickOn("#newGame");
        assertEquals("charCreation", controller.getNextRootID());
    }

    @Test
    void testSwitchSceneCorrectly2() {
        clickOn("#controls");
        assertEquals("controls", controller.getNextRootID());
    }

}
