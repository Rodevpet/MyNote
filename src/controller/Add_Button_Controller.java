package controller;

import javafx.scene.input.MouseEvent;
import model.Add_Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import view.Enter_Name_Note;
import view.Note_Exist;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Add_Button_Controller implements EventHandler <Event>, Join {
    private Events_Manager events_manager;
    public void setController (Events_Manager eventsManger){
        this.events_manager = eventsManger;
    }

    @Override
    public void handle(Event event) {
      if (event.getEventType()== MouseEvent.MOUSE_CLICKED){ Add_Note(); }
    }
    private void Add_Note (){
        Optional<String> Name = new Enter_Name_Note().Enter_Name_Note();
        URL url = null;
        if (Name.isPresent()) {
            System.out.println(events_manager.getDirNote().getAbsolutePath() + "/" + Name.get());
            File directory = new File(events_manager.getDirNote().getAbsolutePath()+ "/" + Name.get());
            if (directory.exists()) {
                new Note_Exist();
            } else {
                try {
                    Add_Controller New = new Add_Controller(Name.get());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                File file = new File(directory + "/" + Name.get() + ".fxml");
                try {
                    url = new File(file.getAbsolutePath()).toURI().toURL();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    events_manager.getSection().getChildren().add(0, FXMLLoader.load(url));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                events_manager.getHtml_Editor().setHtmlText("");
            }
        }
    }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
