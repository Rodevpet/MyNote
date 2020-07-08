package main;

import edit.Add_Controller;
import javafx.animation.RotateTransition;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Transform;
import javafx.scene.web.HTMLEditor;
import javafx.util.Duration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class Home_Controller implements Initializable {
    @FXML
    VBox section;
    @FXML
    MenuButton MoreMenu;
    @FXML
    AnchorPane main;
    @FXML
    Button more;
    @FXML
    HTMLEditor HtmlEditor;

    private String IdNote = "";
    private File DirNote = new File("MyNote");
    private boolean ButtonMoreStatut = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println(DirNote.getAbsolutePath());
        for (File dur : DirNote.listFiles()) {
            if (dur.isDirectory()) {
                File[] files = dur.listFiles((dir1, name) -> name.toLowerCase().endsWith(".fxml"));
                assert files != null;
                for (File file : files) {
                    try {
                        URL url = new File(file.getAbsolutePath()).toURI().toURL();
                        section.getChildren().add(FXMLLoader.load(url));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void loadNote(String id, String note) {
        IdNote = id;
        HtmlEditor.setHtmlText(note);
    }

    public void save() throws IOException {
        if (!IdNote.equals("")) {
            File sav = new File(DirNote + "/" + IdNote + "/Note.txt");
            FileWriter saved = new FileWriter(sav);
            saved.write(HtmlEditor.getHtmlText());
            saved.close();
        } else {
            Alert Null = new Alert(Alert.AlertType.ERROR);
            Null.setTitle("Erreur");
            Null.setHeaderText("Aucune Note n'est sélectionner");
            Null.setContentText("Erreur : Appuyez sur le bouton de la note pour la sélectionner.");
            Null.showAndWait();
        }
    }

    public void add() throws IOException, RuntimeException {
        TextInputDialog CreateNote = new TextInputDialog();
        CreateNote.setTitle("Créer une Note");
        CreateNote.setHeaderText("Veuillez saisir le nom de la note à créer : ");
        Optional<String> Name = CreateNote.showAndWait();
        if (Name.isPresent()) {
            File directory = new File(DirNote + "/" + Name.get());
            if (directory.exists()) {
                Alert exist = new Alert(Alert.AlertType.ERROR);
                exist.setTitle("Erreur");
                exist.setHeaderText("Note déjà existante");
                exist.setContentText("Erreur : la note que vous essayez de créer existe déjà.");
                exist.showAndWait();
            } else {
                new Add_Controller(Name.get());
                File file = new File(directory + "/" + Name.get() + ".fxml");
                URL url = new File(file.getAbsolutePath()).toURI().toURL();
                section.getChildren().add(FXMLLoader.load(url));
            }
        }
    }

    public void remove() {
        if (!IdNote.equals(null)) {
            File delete = new File(DirNote + "/" + IdNote);
            System.out.println(delete.getAbsolutePath());
            for (File sup : Objects.requireNonNull(delete.listFiles())) {
                sup.delete();
            }
            delete.delete();
        } else {
            Alert exist = new Alert(Alert.AlertType.ERROR);
            exist.setTitle("Erreur");
            exist.setHeaderText("Aucune Note sélectionner");
            exist.setContentText("Erreur : Aucune note n'est sélectionner \n Cliquez sur le bouton de la note pour que celle-ci soit supprimer.");
            exist.showAndWait();
        }
        section.getChildren().remove(IdNote);
        IdNote = "";
    }

    //TODO Voir comment ajouter directement un tableau entre les bonnes balise grâce à xml ou html
    public void add_tab(){
    //TODO Ajouter un tableau
    }

    public void delete_tab(){
      //TODO supprimer un tableau
    }

    public void add_row(){
        //TODO ajouter une ligne
    }

    public void delete_row (){
        //TODO Supprimer une ligne
    }

    public void add_column (){
        //TODO Ajouter une colonne
    }

    public void delete_column (){
        //TODO Supprimer une colone
    }

}
