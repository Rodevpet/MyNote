package model;

import controller.Events_Manager;
import controller.Note_Button_Controller;
import javafx.event.Event;
import javafx.scene.control.Button;

public class Button_Note extends Button {
    public Button_Note (String Name, Events_Manager events_manager){
        this.setText(Name);
        Note_Button_Controller NBC = new Note_Button_Controller();
        NBC.setEvents_manager(events_manager);
        this.addEventFilter(Event.ANY,NBC);
        System.out.println(this.getClass().getResource("/resources/style.css").getPath());
        this.setMinWidth(195);
        this.setStyle("-fx-background-radius : 0;\n" +
                "     -fx-background-color: #282828;\n" +
                "     -fx-text-fill : white");
    }
}
