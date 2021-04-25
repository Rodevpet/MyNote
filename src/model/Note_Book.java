package model;

import controller.Book_Note_Controller;
import controller.Events_Manager;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;

import java.io.File;

public class Note_Book extends TreeItem {
    private Events_Manager events_manager;
    private File path;
    private Label value;
    public Note_Book(String name, Events_Manager events_manager, File path){
        value = new Label(name);
        this.setValue(value);
        this.events_manager = events_manager;
        this.path = path;
        Book_Note_Controller BNC = new Book_Note_Controller();
        BNC.setEvents_manager(events_manager);
        this.setGraphic(new Label("test"));
        this.getGraphic().addEventHandler(Event.ANY,BNC);
    }
}
