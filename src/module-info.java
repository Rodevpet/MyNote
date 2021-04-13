module MyNote {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;

    opens model to javafx.fxml;
    opens controller to javafx.fxml;
    exports model;
    exports controller;
}