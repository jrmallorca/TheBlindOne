package com.joni.combatTest;

import com.joni.TestFXBase;
import com.joni.controller.enemies.CombatController;
import com.joni.entities.Player;
import com.joni.entities.enemies.Zombie;
import com.joni.entities.vocations.Fighter;
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

import static com.joni.controller.FXMLName.COMBAT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZombieTest extends TestFXBase {

    private CombatController controller;

    @Override
    public void start(Stage stage) throws IOException {
        // Get relevant fields from TestFXBase
        WindowModel windowModel = getWindowModel();

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(COMBAT);
        loader.setControllerFactory(type -> new CombatController(stage, windowModel, new Player("Sol", 1, 1, new Fighter()), new Zombie()));

        // Create an instance of a scene and set it to the stage
        stage.setScene(new Scene(windowModel.getParent(loader)));
        controller = loader.getController();

        // Set the settings for the stage
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    @Test
    void testLook() {
        sleep(10000);
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
