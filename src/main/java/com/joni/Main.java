package com.joni;

import com.joni.controller.TitleScreenController;
import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.Map;

import static com.joni.model.FXMLName.TITLE_SCREEN;

public class Main extends Application {

    private final Map<FXMLName, String> fxmlPaths = Collections.singletonMap(TITLE_SCREEN, "/fxml/TitleScreen.fxml");

    @Override
    public void start(Stage window) throws Exception {
        // Create an instance of a model that will help switching scenes
        WindowModel windowModel = new WindowModel();
        windowModel.setMap(fxmlPaths);

        // Load the FXML file
        FXMLLoader loader = windowModel.getFXMLLoader(TITLE_SCREEN);

        // Create an instance of a scene, add it to windowModel and set the window's scene
        Scene scene = new Scene(windowModel.getParent(loader));
        windowModel.setScene(scene);
        window.setScene(scene);

        // Get controller and set appropriate values for its fields
        TitleScreenController controller = loader.getController();
        controller.setWindowModel(windowModel);

        // Configure contents of the HashMap inside windowModel
        windowModel.setMap(controller.getFXMLPaths());

        // Set the settings for the window
        window.setFullScreen(true);
        window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
