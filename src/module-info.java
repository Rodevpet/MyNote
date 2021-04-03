module MyNote {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;

    opens main to javafx.fxml;
    opens edit to javafx.fxml;
    opens controller to javafx.fxml;
    exports edit;
    exports main;
    exports controller;
}