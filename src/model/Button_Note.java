package model;

import controller.Note_Button_Controller;
import javafx.event.Event;
import javafx.scene.control.Button;

public class Button_Note extends Button {
    public Button_Note (String Name){
        this.setText(Name);
        this.addEventFilter(Event.ANY,new Note_Button_Controller());
        System.out.println(this.getClass().getResource("/resources/style.css").getPath());
        this.setStyle(this.getClass().getResource("/resources/style.css").getPath());
    }
}
