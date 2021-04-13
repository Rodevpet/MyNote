package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Remove_Button_Controller implements EventHandler<Event>, Join {
    private Events_Manager events_manager;
    public void remove() {
        events_manager.getHtml_Editor().setHtmlText("");
        if (events_manager.getCurrent_Button() != null) {
            File delete = new File(events_manager.getDirNote().getAbsolutePath() + "/" + events_manager.getCurrent_Button().getText());
            for (File sup : Objects.requireNonNull(delete.listFiles())) {
                sup.delete();
            }
            delete.delete();
            events_manager.getSection().getChildren().remove(events_manager.getCurrent_Button());
        } else {
            Alert exist = new Alert(Alert.AlertType.ERROR);
            exist.setTitle("Erreur");
            exist.setHeaderText("Aucune Note sélectionner");
            exist.setContentText("Erreur : Aucune note n'est sélectionner \n Cliquez sur le bouton de la note pour que celle-ci soit supprimer.");
            exist.showAndWait();
        }
    }
    @Override
    public void handle(Event event) {

    }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
