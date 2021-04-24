package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import model.Button_Note;
import model.MODE_BUTTON;
import model.Path_Note;
import model.ResearchNote;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Note_Button_Controller implements EventHandler{
    private Button_Note Button_Note;

    private Events_Manager events_manager;
    @Override
    public void handle(Event event) {
        Button_Note = (Button_Note) event.getSource();
        if (event.getEventType()== MouseEvent.MOUSE_ENTERED){onMouseEntered();}
        if (event.getEventType()== MouseEvent.MOUSE_CLICKED){onMouseClicked();}
        if (event.getEventType()== MouseEvent.MOUSE_EXITED){onMouseExited();}
    }

    public void onMouseEntered(){
        if (Button_Note.getMode() != MODE_BUTTON.ON_MOUSE_EXITED.get())
            Button_Note.setMode(MODE_BUTTON.ON_MOUSE_ENTERED.get());
    }

    public void onMouseExited(){
        if (Button_Note.getMode() != MODE_BUTTON.ON_MOUSE_CLICKED.get())
            Button_Note.setMode(MODE_BUTTON.ON_MOUSE_EXITED.get());
    }

    public void onMouseClicked(){
        if (events_manager.getCurrent_Note()!=null)
            events_manager.getCurrent_Note().setMode(MODE_BUTTON.ON_MOUSE_EXITED.get());
        if (Button_Note != null)
            Button_Note.setMode(MODE_BUTTON.ON_MOUSE_EXITED.get());
        Button_Note.setMode(MODE_BUTTON.ON_MOUSE_CLICKED.get());
        try {
            events_manager.getHtml_Editor().setHtmlText(new ResearchNote().ResearchNote(Button_Note.getPath_Note().getAbsolutePath()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        events_manager.setCurrent_Note(Button_Note);
    }

    public void setEvents_manager(Events_Manager events_manager) {
        this.events_manager = events_manager;
    }
}
