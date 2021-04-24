package model;

import controller.Events_Manager;
import controller.Note_Button_Controller;
import javafx.event.Event;
import javafx.scene.control.Button;

import java.io.File;

public class Button_Note extends Button {
    private int Mode = MODE_BUTTON.ON_MOUSE_EXITED.get();
    private File Path_Note;
    public Button_Note (String Name, Events_Manager events_manager, File Path_Note){
        this.Path_Note = Path_Note;
        this.setText(Name);
        Note_Button_Controller NBC = new Note_Button_Controller();
        NBC.setEvents_manager(events_manager);
        this.addEventFilter(Event.ANY,NBC);
        this.setMinWidth(195);
        this.setStyle("-fx-background-radius : 0;\n" +
                "     -fx-background-color: #282828;\n" +
                "     -fx-text-fill : white");
    }
    public void setMode (int Mode){
        this.Mode = Mode;
        if (Mode == MODE_BUTTON.ON_MOUSE_CLICKED.get()){
            this.setStyle("-fx-background-radius : 0;\n" +
                    "-fx-background-color:#747474;\n" +
                    "-fx-text-fill : white");
        }else{
            if (Mode == MODE_BUTTON.ON_MOUSE_ENTERED.get()){
                this.setStyle("-fx-background-radius : 0;\n" +
                        "-fx-background-color:#363636;\n" +
                        "-fx-text-fill : white");
            }else{
                if (Mode == MODE_BUTTON.ON_MOUSE_EXITED.get()){
                    this.setStyle("-fx-background-radius : 0;\n" +
                            "-fx-background-color: #282828;\n" +
                            "-fx-text-fill : white");
                }
            }
        }
    }

    public int getMode (){ return Mode; }

    public File getPath_Note (){return Path_Note;}
}
