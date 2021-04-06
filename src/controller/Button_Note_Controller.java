package controller;

import model.ResearchNote;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Button_Note_Controller implements EventHandler <Event>,Join_Controller, Initializable {
    @FXML
    private Button Button_Note;

    private static Node node;
    @Override
    public void Join_Controller(Node node) {
        this.node = node;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Note.addEventFilter(Event.ANY,this);
        Button_Note.setId("onMouseExited");
    }

    @Override
    public void handle(Event event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED){load();}
        if (event.getEventType() == MouseEvent.MOUSE_ENTERED){onMouseEntered();}
        if (event.getEventType() == MouseEvent.MOUSE_EXITED){onMouseExited();}
    }

    private void onMouseExited() {
        if (node.getCurrent() != Button_Note){Button_Note.setId("onMouseExited");}
    }

    private void load() {
        if (node.getCurrent() != Button_Note && node.getCurrent()!= null) {
            node.getCurrent().setId("onMouseExited");
        }
        node.setCurrent(Button_Note);
        Button_Note.setId("onMouseClicked");
        node.getHtml_Editor().setHtmlText(new ResearchNote().ResearchNote(System.getProperty("user.home")+"/.note/"+Button_Note.getText() + "/Note.txt"));
    }

    private void onMouseEntered (){
        if (node.getCurrent() != Button_Note){Button_Note.setId("onMouseEntered");}
    }
}
