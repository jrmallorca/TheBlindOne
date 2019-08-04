module RPG {
    requires javafx.media;
    requires javafx.controls;
    requires javafx.fxml;
    requires AnimateFX;

    opens com.joni to javafx.fxml;
    opens com.joni.controller to javafx.fxml;
    opens com.joni.controller.titleScreen to javafx.fxml;
    opens com.joni.controller.enemies to javafx.fxml;
    exports com.joni;
}