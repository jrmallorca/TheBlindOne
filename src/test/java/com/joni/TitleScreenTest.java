package com.joni;

import com.joni.controller.TitleScreenController;
import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static com.joni.model.FXMLName.TITLE_SCREEN;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitleScreenTest extends TestFXBase {

    private TitleScreenController controller;

    @Override
    public void start(Stage stage) throws IOException {
        // Get relevant fields from TestFXBase
        WindowModel windowModel = getWindowModel();
        HashMap<FXMLName, String> mapFXML = getMapFXML();

        // Set up map
        mapFXML.put(TITLE_SCREEN, "/fxml/TitleScreen.fxml");

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(FXMLName.TITLE_SCREEN, mapFXML);
        loader.setControllerFactory(type -> new TitleScreenController(stage, windowModel, mapFXML));

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
