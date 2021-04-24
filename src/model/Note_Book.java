package model;

import controller.Book_Note_Controller;
import controller.Events_Manager;
import javafx.event.Event;
import javafx.scene.control.TreeItem;

import java.io.File;

public class Note_Book extends TreeItem {
    private Events_Manager events_manager;
    private File path;
    public Note_Book(String name, Events_Manager events_manager, File path){
        this.setValue(name);
        this.events_manager = events_manager;
        this.path = path;
        Book_Note_Controller BNC = new Book_Note_Controller();
        BNC.setEvents_manager(events_manager);
        this.addEventHandler(Event.ANY,BNC);
    }
}
