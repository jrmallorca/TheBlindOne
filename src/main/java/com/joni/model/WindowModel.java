package com.joni.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

/*
    This model handles the logic of switching scenes
 */
public class WindowModel {

    public FXMLLoader getFXMLLoader(FXMLName name, HashMap<FXMLName, String> map) {
        return new FXMLLoader(getClass().getResource(map.get(name)));
    }

    // Gets the parents and also sets the stylesheet
    public Parent getParent(FXMLLoader loader) throws IOException {
        Parent parent = loader.load();
        parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        return parent;
    }

    // The scene switcher
    public void setSceneParent(Stage stage, Parent parent){
        stage.getScene().setRoot(parent);
    }

}
