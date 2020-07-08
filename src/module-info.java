module Note {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens main to javafx.fxml,javafx.web;
    opens edit to javafx.fxml,javafx.web;
    exports main;
    exports edit;
}