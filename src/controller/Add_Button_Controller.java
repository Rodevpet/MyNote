package controller;

import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import model.Button_Note;
import view.Enter_Name_Note;
import view.Note_Exist;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class Add_Button_Controller implements EventHandler <Event>, Join {
    private Events_Manager events_manager;
    public void setController (Events_Manager eventsManger){
        this.events_manager = eventsManger;
    }

    @Override
    public void handle(Event event) {
      if (event.getEventType()== MouseEvent.MOUSE_CLICKED){
          try {
              Add_Note();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
    }
    private void Add_Note () throws IOException {
        Optional<String> Name = new Enter_Name_Note().Enter_Name_Note();
        URL url = null;
        if (Name.isPresent()) {
            File directory = new File(events_manager.getDirNote().getAbsolutePath()+ "/" + Name.get());
            if (directory.exists()) {
                new Note_Exist();
            } else {
                directory.createNewFile();
                    System.err.println(events_manager.getCurrent_Book());
                    events_manager.getCurrent_Book().getChildren().add(new TreeItem(new Button_Note(Name.get(), events_manager,new File(events_manager.getCurrent_Note().getPath_Note().getParent()))));
                events_manager.getHtml_Editor().setHtmlText("");
            }
        }
    }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
