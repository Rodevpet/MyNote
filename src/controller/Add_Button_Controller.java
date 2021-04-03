package controller;

import edit.Add_Controller;
import edit.Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Add_Button_Controller implements EventHandler <Event>, Join_Controller{
    private Node node;
    public void setController (Node node){
        this.node = node;
    }

    @Override
    public void handle(Event event) {
        TextInputDialog CreateNote = new TextInputDialog();
        CreateNote.setTitle("Créer une Note");
        CreateNote.setHeaderText("Veuillez saisir le nom de la note à créer : ");
        Optional<String> Name = CreateNote.showAndWait();
        URL url = null;
        if (Name.isPresent()) {
            System.out.println(node.getDirNote().getAbsolutePath() + "/" + Name.get());
            File directory = new File(node.getDirNote().getAbsolutePath()+ "/" + Name.get());
            if (directory.exists()) {
                Alert exist = new Alert(Alert.AlertType.ERROR);
                exist.setTitle("Erreur");
                exist.setHeaderText("Note déjà existante");
                exist.setContentText("Erreur : la note que vous essayez de créer existe déjà.");
                exist.showAndWait();
            } else {
                node.setIndex(0);
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
                    node.getSection().getChildren().add(node.getIndex(), FXMLLoader.load(url));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                node.getHtml_Editor().setHtmlText("");
                Controller.setHistory((Button) node.getSection().getChildren().get(node.getIndex()));
                node.getSection().getChildren().get(node.getIndex()).setId("Focus");
                if (node.getCurrent()!=null) {
                    node.getSection().getChildren().get(node.getIndex()).setId("NoFocus");
                }
                node.setCurrent((Button) node.getSection().getChildren().get(node.getIndex()));
            }
        }
    }

    @Override
    public void Join_Controller(Node node) throws IOException {
        this.node = node;
    }
}
