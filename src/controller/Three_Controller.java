package controller;

import javafx.fxml.FXMLLoader;
import model.Path_Note;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Three_Controller implements Join {
    private Events_Manager events_manager;
    private Path_Note path_note = new Path_Note();
    public void Init (){
        if (!path_note.getPath_Note().exists()){
            path_note.getPath_Note().mkdir();
        }
        for (File dur : Objects.requireNonNull(path_note.getPath_Note().listFiles())) {
            if (dur.isDirectory()) {
                File[] files = dur.listFiles((dir1, name) -> name.toLowerCase().endsWith(".fxml"));
                assert files != null;
                for (File file : files) {
                    try {
                        URL url = new File(file.getAbsolutePath()).toURI().toURL();
                        events_manager.getSection().getChildren().add(FXMLLoader.load(url));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
