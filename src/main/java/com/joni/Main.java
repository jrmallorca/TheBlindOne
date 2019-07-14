package com.joni;

import com.joni.controller.titleScreen.TitleScreenController;
import com.joni.model.WindowModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;

import static com.joni.controller.FXMLName.TITLE_SCREEN;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Create an instance of a model that will help switching scenes
        WindowModel windowModel = new WindowModel();

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(TITLE_SCREEN);
        loader.setControllerFactory(type -> new TitleScreenController(stage, windowModel));

        // Create an instance of a scene and set it to the stage
        stage.setScene(new Scene(windowModel.getParent(loader)));

        // Set the settings for the stage
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
