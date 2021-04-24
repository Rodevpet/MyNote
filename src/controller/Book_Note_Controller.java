package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Book_Note;

public class Book_Note_Controller implements EventHandler {
    private Events_Manager events_manager;
    private Book_Note book_note;
    @Override
    public void handle(Event event) {
        book_note = (Book_Note) event.getSource();
        if (event.getEventType()== MouseEvent.MOUSE_CLICKED){onMouseClicked();}
    }

    private void onMouseClicked() {
        events_manager.setCurrent_Book(book_note);
    }

    public void setEvents_manager (Events_Manager events_manager){
        this.events_manager = events_manager;
    }
}
