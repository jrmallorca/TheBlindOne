package com.joni.controller;

import animatefx.animation.FadeIn;
import animatefx.animation.FadeOut;
import animatefx.util.SequentialAnimationFX;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class IntroCutsceneController extends MainWindowController implements Initializable {

    // Field(s) mainly for testing purposes
    @FXML
    private GridPane introCutscene;

    @FXML
    private MediaView mediaView;
    private MediaPlayer mediaPlayer;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    
    public IntroCutsceneController(Stage stage, WindowModel model) {
        // TODO: 11/07/2019 Change it so it can save the player name 
        super(stage, model);
    }

    @Override
    // TODO: 12/07/2019 Change the last line of the poem or manage to conjure a better overall poem
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Opacity set to 0 so that it would appear when the animation is used
        mediaView.setOpacity(0);
        label1.setOpacity(0);
        label2.setOpacity(0);
        label3.setOpacity(0);
        label4.setOpacity(0);

        mediaPlayer = new MediaPlayer(new Media(getClass().getResource("/gif/SnowFall.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);

        Duration duration = Duration.seconds(1.5);
        new SequentialAnimationFX(new FadeIn(label1).setSpeed(0.5),
                                  new FadeIn(mediaView).setSpeed(0.5),
                                  new FadeIn(label2).setSpeed(0.5).setDelay(duration),
                                  new FadeIn(label3).setSpeed(0.5).setDelay(duration),
                                  new FadeIn(label4).setSpeed(0.5).setDelay(duration),
                                  new FadeOut(mediaView).setSpeed(0.5).setDelay(duration)).play();
        
    }
}
