package com.joni.controller;

import com.joni.model.FXMLName;
import com.joni.model.WindowModel;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static com.joni.model.FXMLName.TITLE_SCREEN_2;

public class TitleScreenController {

    private WindowModel windowModel;

    private final Map<FXMLName, String> fxmlPaths = Collections.singletonMap(TITLE_SCREEN_2, "/fxml/TitleScreen2.fxml");

    @FXML
    public void switchScene() throws IOException {
        windowModel.setSceneParent(windowModel.getParent(windowModel.getFXMLLoader(TITLE_SCREEN_2)));
    }

    public void setWindowModel(WindowModel model) {
        windowModel = model;
    }

    public WindowModel getWindowModel(WindowModel model) {
        return windowModel;
    }

    public Map<FXMLName, String> getFXMLPaths() {
        return fxmlPaths;
    }
}
