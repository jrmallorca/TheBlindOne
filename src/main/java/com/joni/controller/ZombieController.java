package com.joni.controller;

import com.joni.model.WindowModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ZombieController extends MainWindowController implements Initializable {

    // Fields mainly for testing purposes
    @FXML
    private GridPane zombie;

    @FXML
    private Label countdown;
    private BigDecimal attackTime = new BigDecimal("1.5");
    private final BigDecimal decrement = new BigDecimal("0.1");
    private final Timer timer = new Timer();

    public ZombieController(Stage stage, WindowModel windowModel) {
        super(stage, windowModel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        countdown.setText(attackTime.toString());
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                BigDecimal zero = new BigDecimal("0.0");
                if (attackTime.equals(zero)) {
                    noPlayerReaction();
                } else {
                    attackTime = attackTime.subtract(decrement);
                    Platform.runLater(() -> countdown.setText(attackTime.toString()));
                }
            }

        }, 100, 100);
    }

    @FXML
    private void playerReaction(KeyEvent keyEvent) {
        // TODO: 13/07/2019 Actual combat logic
    }

    private void noPlayerReaction() {
        // TODO: 13/07/2019 Calculate damage done to player
    }

    public BigDecimal getAttackTime() {
        return attackTime;
    }

}
