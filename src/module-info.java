module MyNote {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;

    opens view to javafx.fxml;
    opens model to javafx.fxml;
    opens controller to javafx.fxml;
    opens resources to javafx.fxml;
    exports model;
    exports view;
    exports controller;
    exports resources;
}