package controller;

import model.Add_Controller;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import model.Join_Model;
import model.Path_Note;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

public class Add_Button_Controller implements EventHandler <Event>, Join_Controller, Join_Model {
    private Node node;
    private Path_Note path_note;
    @Override
    public void handle(Event event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED){
            Add_Note();
        }
    }

    @Override
    public void Join_Controller(Node node) throws IOException {
        this.node = node;
    }

    private void Add_Note (){
        TextInputDialog CreateNote = new TextInputDialog();
        CreateNote.setTitle("Créer une Note");
        CreateNote.setHeaderText("Veuillez saisir le nom de la note à créer : ");
        Optional<String> Name = CreateNote.showAndWait();
        URL url = null;
        if (Name.isPresent()) {
            File directory = new File(path_note.getDirNote().getAbsolutePath()+ "/" + Name.get());
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
                //Button_Note_Controller.setHistory((Button) node.getSection().getChildren().get(node.getIndex()));
                node.getSection().getChildren().get(node.getIndex()).setId("onMouseClicked");
                if (node.getCurrent()!=null) {
                    node.getCurrent().setId("onMouseExited");
                }
                node.setCurrent((Button) node.getSection().getChildren().get(node.getIndex()));
            }
        }
    }

    @Override
    public void Join_Path_Note(Path_Note path_note) {
        this.path_note = path_note;
    }
}
