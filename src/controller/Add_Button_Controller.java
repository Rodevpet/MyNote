package controller;

import javafx.scene.input.MouseEvent;
import model.Add_Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;

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
        TextInputDialog CreateNote = new TextInputDialog();
        CreateNote.setTitle("Créer une Note");
        CreateNote.setHeaderText("Veuillez saisir le nom de la note à créer : ");
        Optional<String> Name = CreateNote.showAndWait();
        URL url = null;
        if (Name.isPresent()) {
            System.out.println(events_manager.getDirNote().getAbsolutePath() + "/" + Name.get());
            File directory = new File(events_manager.getDirNote().getAbsolutePath()+ "/" + Name.get());
            if (directory.exists()) {
                Alert exist = new Alert(Alert.AlertType.ERROR);
                exist.setTitle("Erreur");
                exist.setHeaderText("Note déjà existante");
                exist.setContentText("Erreur : la note que vous essayez de créer existe déjà.");
                exist.showAndWait();
            } else {
                events_manager.setIndex(0);
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
                    events_manager.getSection().getChildren().add(events_manager.getIndex(), FXMLLoader.load(url));
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
