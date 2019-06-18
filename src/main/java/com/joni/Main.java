package com.joni;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class Main extends Application {

    private Scene scene;

    @Override
    public void start(Stage window) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/TitleScreen.fxml"));
        window.setTitle("The Blind One");

        scene = new Scene(root);
        window.setScene(scene);

        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
