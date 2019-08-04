package com.joni.controller.enemies;

import com.joni.controller.MainWindowController;
import com.joni.entities.Player;
import com.joni.entities.enemies.Enemy;
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

    private Player player;
    private Enemy enemy;
    private EnemyAction enemyAction;

    @FXML
    private Label enemyActionText;

    @FXML
    private Label countdown;
    private BigDecimal attackTime; // Initial enemy attack time
    private BigDecimal reactTime; // Time when the player produces a reaction (remaining attackTime)
    private final BigDecimal decrement = new BigDecimal("0.1");
    private final Timer timer = new Timer();

    // TODO: 14/07/2019 Include a possible list of monsters to be encountered and then get a random one
    public CombatController(Stage stage, WindowModel windowModel, Player player, Enemy enemy) {
        super(stage, windowModel);
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fightLoop();
    }

    private void fightLoop() {
        // Get original attack time
        resetAttackTime();

        // Get the random enemyAction and set its respective label text
        enemyAction = enemy.randomEnum(EnemyAction.class);
        enemyActionText.setText(enemy.enemyActionString(enemyAction));

        // Start the timer and its respective task
        // The timer drops every 0.1 seconds until it gets a player reaction, or becomes 0.0
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
        // Stop timer
        reactTime = attackTime;
        timer.cancel();

        // Check effect
        switch (keyEvent.getCode()) {
            case W:
                player.getVocation().buttonW(enemyAction, player, enemy, reactTime);
                break;
            case A:
                player.getVocation().buttonA(enemyAction, player, enemy);
                break;
            case S:
                player.getVocation().buttonS(enemyAction, player, enemy);
                break;
            case D:
                player.getVocation().buttonD(enemyAction, player, enemy);
                break;
            case DIGIT1:
                player.getVocation().skillButtonOne(enemyAction, player, enemy);
                break;
            case DIGIT2:
                player.getVocation().skillButtonTwo(enemyAction, player, enemy);
                break;
            case DIGIT3:
                player.getVocation().skillButtonThree(enemyAction, player, enemy);
                break;

        }

        if (player.getHp() >= 0 || enemy.getHp() >= 0) fightLoop();
//            else switchScene();
    }

    private void noPlayerReaction() {
        // TODO: 13/07/2019 Calculate damage done to player
    }

    private void resetAttackTime() {
        attackTime = enemy.getAttackTime();
    }

    public BigDecimal getAttackTime() {
        return attackTime;
    }

}
