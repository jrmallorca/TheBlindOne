module RPG {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.joni to javafx.fxml;
    exports com.joni;
}