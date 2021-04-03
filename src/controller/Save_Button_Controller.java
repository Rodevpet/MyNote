package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save_Button_Controller implements EventHandler <Event>, Join_Controller{
    private Node node;


    @Override
    public void handle(Event event) {

    }

    @Override
    public void Join_Controller(Node node) throws IOException {
        this.node = node;
    }

    public void save() throws IOException {
        try {
            if (node.getCurrent() != null) {
                File sav = new File(node.getDirNote().getAbsolutePath() + "/" + node.getCurrent().getText() + "/Note.txt");
                FileWriter saved = new FileWriter(sav);
                saved.write(node.getHtml_Editor().getHtmlText());
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
}
