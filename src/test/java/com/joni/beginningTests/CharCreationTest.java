package com.joni.beginningTests;

import com.joni.TestFXBase;
import com.joni.controller.CharCreationController;
import com.joni.model.WindowModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.joni.controller.FXMLName.CHAR_CREATION;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharCreationTest extends TestFXBase {

    private CharCreationController controller;

    @Override
    public void start(Stage stage) throws IOException {
        // Get relevant fields from TestFXBase
        WindowModel windowModel = getWindowModel();

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(CHAR_CREATION);
        loader.setControllerFactory(type -> new CharCreationController(stage, windowModel));

        // Create an instance of a scene and set it to the stage
        stage.setScene(new Scene(windowModel.getParent(loader)));
        controller = loader.getController();

        // Set the settings for the stage
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    @Test
    void testMaxLengthFormatter() {
        // Must not surpass 20 char limit
        clickOn("#textField").write("012345678901234567890");
        assertEquals("01234567890123456789", controller.getTextFieldText());
    }

    @Test
    void testAlphaNumericFormatter() {
        // Must only accept ALPHA_NUMERIC_FORMAT in textField
        clickOn("#textField").write("£$%^&*()[}:;'#~@<>?,./");
        assertEquals("", controller.getTextFieldText());
    }

    // TODO: 09/07/2019 Implement what happens if nothing is written
//    @Test
//    void testCheckLength0() {
//        clickOn("#textField").write("").push(KeyCode.ENTER);
//        assertEquals("titleScreen2", controller.getNextRootID());
//    }

    @Test
    void testSwitchSceneCorrectly() {
        clickOn("#textField").write("Sol").push(KeyCode.ENTER);
        // TODO: 11/07/2019 Implement a way to properly check ConfirmController
        clickOn("#yesButton");
        assertEquals("introCutscene", controller.getNextRootID());
    }

}
