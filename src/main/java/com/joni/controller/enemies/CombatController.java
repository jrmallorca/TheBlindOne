package com.joni.controller.enemies;

import com.joni.controller.MainWindowController;
import com.joni.entities.Player;
import com.joni.entities.enemies.Enemy;
import com.joni.model.CombatModel;
import com.joni.model.WindowModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class CombatController extends MainWindowController implements Initializable {

    // Field(s) mainly for testing purposes
    @FXML
    private GridPane combat;

    private CombatModel combatModel;
    private Player player;
    private Enemy enemy;
    private Attack attack;

    @FXML
    private Label countdown;
    private BigDecimal attackTime;
    private final BigDecimal decrement = new BigDecimal("0.1");
    private final Timer timer = new Timer();

    // TODO: 14/07/2019 Include a possible list of monsters to be encountered and then get a random one
    public CombatController(Stage stage, WindowModel windowModel, CombatModel combatModel, Player player, Enemy enemy) {
        super(stage, windowModel);
        this.combatModel = combatModel;
        this.player = player;
        this.enemy = enemy;

        attackTime = enemy.getAttackTime();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fightLoop();
    }

    private void fightLoop() {
        attack = combatModel.randomEnum(Attack.class);

        countdown.setText(attackTime.toString());

        // The timer drops every 0.1 seconds until it gets a player reaction, or becomes 0.0
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
