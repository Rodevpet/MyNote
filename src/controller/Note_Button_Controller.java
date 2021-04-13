package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.Path_Note;
import model.ResearchNote;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Note_Button_Controller implements EventHandler, Initializable{
    private final Path_Note path_note = new Path_Note();
    @FXML
    private Button Button_Note;

    private static Events_Manager events_manager;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button_Note.addEventFilter(Event.ANY,this);
    }

    @Override
    public void handle(Event event) {
        if (event.getEventType()== MouseEvent.MOUSE_ENTERED){onMouseEntered();}
        if (event.getEventType()== MouseEvent.MOUSE_CLICKED){onMouseClicked();}
        if (event.getEventType()== MouseEvent.MOUSE_EXITED){onMouseExited();}
    }

    public void onMouseEntered(){
        if (!Button_Note.getId().equals("onMouseClicked"))
            Button_Note.setId("onMouseEntered");
    }

    public void onMouseExited(){
        if (Button_Note.getId().equals("onMouseClicked"))
            Button_Note.setId("onMouseExited");
    }

    public void onMouseClicked(){
        if (Button_Note != null)
            Button_Note.setId("onMouseExited");
        Button_Note.setId("onMouseClicked");
        try {
            events_manager.getHtml_Editor().setHtmlText(new ResearchNote().ResearchNote(path_note.getPath_Note()+"/"+Button_Note.getText() + "/Note.txt"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        events_manager.setCurrent_Button(Button_Note);
    }

    public static void setEvents_manager(Events_Manager events_manager) {
        Note_Button_Controller.events_manager = events_manager;
    }
}
