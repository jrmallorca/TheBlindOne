package com.joni.combatTest;

import com.joni.TestFXBase;
import com.joni.controller.ZombieController;
import com.joni.model.WindowModel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

import static com.joni.controller.FXMLName.ZOMBIE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZombieTest extends TestFXBase {

    private ZombieController controller;

    @Override
    public void start(Stage stage) throws IOException {
        // Get relevant fields from TestFXBase
        WindowModel windowModel = getWindowModel();

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(ZOMBIE);
        loader.setControllerFactory(type -> new ZombieController(stage, windowModel));

        // Create an instance of a scene and set it to the stage
        stage.setScene(new Scene(windowModel.getParent(loader)));
        controller = loader.getController();

        // Set the settings for the stage
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    // Makes sure that attackTime actually decreases
    @Test
    void testTimer() {
        final BigDecimal attackTime = controller.getAttackTime();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                assertEquals(1, attackTime.compareTo(controller.getAttackTime()));
            }

        }, 100);
    }

}
