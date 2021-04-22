package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import model.Button_Note;
import model.Path_Note;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Three_Controller implements Join {
    private Events_Manager events_manager;
    private Path_Note path_note = new Path_Note();
    public void Init (){
        System.out.println(path_note.getPath_Note());
                File[] files = path_note.getPath_Note().listFiles((dir1, name) -> name.toLowerCase().endsWith(".txt"));
                assert files != null;
                for (File file : files) {
                    events_manager.getSection().getChildren().add(new Button_Note(file.getName()));
                }
        }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
