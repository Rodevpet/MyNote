package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Remove_Button_Controller implements EventHandler<Event>, Join_Controller {
    private Node node;
    public void remove() {
        node.getHtml_Editor().setHtmlText("");
        if (node.getCurrent() != null) {
            File delete = new File(node.getDirNote().getAbsolutePath() + "/" + node.getCurrent().getText());
            for (File sup : Objects.requireNonNull(delete.listFiles())) {
                sup.delete();
            }
            delete.delete();
            node.getSection().getChildren().remove(node.getCurrent());
            try {
                if (node.getSection().getChildren().get(node.getIndex())!=null){
                    node.setCurrent((Button)node.getSection().getChildren().get(node.getIndex()));
                    node.getCurrent().setId("Focus");
                }
            }catch (IndexOutOfBoundsException e) {
            }
        } else {
            Alert exist = new Alert(Alert.AlertType.ERROR);
            exist.setTitle("Erreur");
            exist.setHeaderText("Aucune Note sélectionner");
            exist.setContentText("Erreur : Aucune note n'est sélectionner \n Cliquez sur le bouton de la note pour que celle-ci soit supprimer.");
            exist.showAndWait();
            node.setCurrent(null);
        }
    }

    public void setContreller(Node node) {
        this.node = node;
    }

    @Override
    public void Join_Controller(Node node) throws IOException {

    }

    @Override
    public void handle(Event event) {

    }
}
