package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Note_Book;

public class Book_Note_Controller implements EventHandler {
    private Events_Manager events_manager;
    private Note_Book _noteBook;
    @Override
    public void handle(Event event) {
        _noteBook = (Note_Book) event.getSource();
        if (event.getEventType()== MouseEvent.MOUSE_CLICKED){onMouseClicked();}
    }

    private void onMouseClicked() {
        events_manager.setCurrent_Book(_noteBook);
    }

    public void setEvents_manager (Events_Manager events_manager){
        this.events_manager = events_manager;
    }
}
