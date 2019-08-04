package com.joni.model;

import com.joni.controller.ConfirmController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/*
    This model handles the logic of confirmation (yes/no prompts)
 */
public class ConfirmModel {

    public boolean confirm(Stage stage, FXMLLoader loader) throws IOException {
        Stage popUp = new Stage();
        popUp.initOwner(stage);
        popUp.initStyle(StageStyle.UNDECORATED); // Makes sure that window has no minimize, exit, etc. buttons
        popUp.initModality(Modality.APPLICATION_MODAL); // Window process has to be completed before being able to interact with parent window

        loader.setControllerFactory(type -> new ConfirmController("Is this your name?", popUp));
        Parent parent = loader.load();
        parent.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        popUp.setScene(new Scene(parent));
        popUp.showAndWait(); // Makes it stay inside the show() method until window closes

        ConfirmController controller = loader.getController();
        return controller.isSwitchScenePrompt();
    }

}
