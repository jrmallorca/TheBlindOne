package com.joni.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
    This model handles the logic of switching scenes
 */
public class WindowModel {

    private final HashMap<FXMLName, String> loaderHashMap = new HashMap<>();
    private Scene scene;

    public void setMap(Map<FXMLName, String> map) {
        loaderHashMap.clear();
        loaderHashMap.putAll(map);
    }

    public HashMap getMap() {
        return loaderHashMap;
    }

    public FXMLLoader getFXMLLoader(FXMLName name) {
        return new FXMLLoader(getClass().getResource(loaderHashMap.get(name)));
    }

    // Gets the parents and also sets the stylesheet
    public Parent getParent(FXMLLoader loader) throws IOException {
        Parent parent = loader.load();
        parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        return parent;
    }

    // The scene switcher
    public void setSceneParent(Parent parent){
        scene.setRoot(parent);
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
}
