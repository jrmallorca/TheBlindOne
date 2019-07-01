package com.joni.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;

/*
    This model handles the logic of switching scenes
 */
public class WindowModel {

    private HashMap<FXMLName, FXMLLoader> fxmlLoaderMap = new HashMap<>();
    private Scene scene;

    public WindowModel(Scene scene) {
        this.scene = scene;
    }

    public void addFXMLLoader(FXMLName name, String pathFXML){
        fxmlLoaderMap.put(name, new FXMLLoader(getClass().getResource(pathFXML)));
    }

    public void removeFXMLLoader(FXMLName name){
        fxmlLoaderMap.remove(name);
    }

    public Parent getParent(FXMLName name) throws IOException {
        return (Parent) fxmlLoaderMap.get(name).load();
    }

    public Object getController(FXMLLoader loader) {
        return loader.getController();
    }

    public void switchScene(Parent parent){
        scene.setRoot(parent);
    }

    public void setStyleSheet(Parent parent, String pathCSS) {
        parent.getStylesheets().add(getClass().getResource(pathCSS).toExternalForm());
    }
}
