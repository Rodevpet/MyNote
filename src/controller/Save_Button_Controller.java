package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save_Button_Controller implements EventHandler <Event>, Join {
    private Events_Manager events_manager;

    @Override
    public void handle(Event event) {
        if (event.getEventType()== MouseEvent.MOUSE_CLICKED){
            try {
                save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void save() throws IOException {
        try {
            if (events_manager.getCurrent_Button() != null) {
                File sav = new File(events_manager.getDirNote().getAbsolutePath() + "/" + events_manager.getCurrent_Button().getText() + "/Note.txt");
                FileWriter saved = new FileWriter(sav);
                saved.write(events_manager.getHtml_Editor().getHtmlText());
                saved.close();
                Alert Confirm_Saved = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
                Confirm_Saved.setTitle("");
                Confirm_Saved.setHeaderText("Note sauvegardée");
                Confirm_Saved.showAndWait();
            } else {
                Alert Null = new Alert(Alert.AlertType.ERROR);
                Null.setTitle("Erreur");
                Null.setHeaderText("Aucune Note n'est sélectionner");
                Null.setContentText("Erreur : Appuyez sur le bouton de la note pour la sélectionner.");
                Null.showAndWait();
            }
        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
