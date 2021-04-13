package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import view.Warning_Note_Not_Found;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Remove_Button_Controller implements EventHandler<Event>, Join {
    private Events_Manager events_manager;
    private void onMouseClicked() {
        events_manager.getHtml_Editor().setHtmlText("");
        if (events_manager.getCurrent_Button() != null) {
            File delete = new File(events_manager.getDirNote().getAbsolutePath() + "/" + events_manager.getCurrent_Button().getText());
            for (File sup : Objects.requireNonNull(delete.listFiles())) {
                sup.delete();
            }
            delete.delete();
            events_manager.getSection().getChildren().remove(events_manager.getCurrent_Button());
            events_manager.setCurrent_Button(null);
        } else {
            new Warning_Note_Not_Found();
        }
    }
    @Override
    public void handle(Event event) {
        if (event.getEventType()== MouseEvent.MOUSE_CLICKED){onMouseClicked();}
    }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
