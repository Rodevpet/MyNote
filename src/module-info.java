module MyNote {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    requires java.datatransfer;

    opens main to javafx.fxml;
    opens edit to javafx.fxml;
    exports edit;
    exports main;
}