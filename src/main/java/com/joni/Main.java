package com.joni;

import com.joni.controller.TitleScreenController;
import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

import static com.joni.model.FXMLName.TITLE_SCREEN;

public class Main extends Application {

    @Override
    public void start(Stage window) throws IOException {
        // Create an instance of a model that will help switching scenes
        WindowModel windowModel = new WindowModel();
        HashMap<FXMLName, String> pathsFXML = new HashMap<>();
        pathsFXML.put(TITLE_SCREEN, "/fxml/TitleScreen.fxml");

        // Load FXML file, set controller and its fields
        FXMLLoader loader = windowModel.getFXMLLoader(FXMLName.TITLE_SCREEN, pathsFXML);
        loader.setControllerFactory(type -> new TitleScreenController(window, windowModel, pathsFXML));

        // Create an instance of a scene and set it to the window
        window.setScene(new Scene(windowModel.getParent(loader)));

        // Set the settings for the window
        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
