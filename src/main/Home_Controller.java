package main;

import edit.Add_Controller;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;

public class Home_Controller implements Initializable {
    @FXML
    VBox section;
    @FXML
    Pane main;
    @FXML
    Button more;
    @FXML
    HTMLEditor HtmlEditor;
    @FXML
    TitledPane Option;
    @FXML
    ScrollPane ScrollPane;
    @FXML
    Pane List;

    private Button current;
    private final Properties info = System.getProperties();
    private final String user = info.getProperty("user.name");
    private final File DirNote = new File("/Users/"+user+"/.Note/");

    @FXML
    private void closeAction (ActionEvent evt){
        System.exit(0);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        section.layoutYProperty().bind((Bindings.when(Option.expandedProperty()).then(82).otherwise(25)));
        if (!DirNote.exists()){
            Path path = Paths.get(DirNote.getAbsolutePath());
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (File dur : Objects.requireNonNull(DirNote.listFiles())) {
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
        for (Node button : section.getChildren()){
            Button n = (Button) button;
            n.getStylesheets().add("style.css");
        }
        ScrollPane.setFitToWidth(true);
        main.heightProperty().addListener((observableValue, number, t1) -> {
            ScrollPane.setMinHeight(main.getHeight());
            List.setMinHeight(main.getHeight());
            section.setMinHeight(main.getHeight());
            HtmlEditor.setMinHeight(main.getHeight());
        });
        main.widthProperty().addListener((observableValue, number, t1) -> HtmlEditor.setMinWidth(main.getWidth() - 202));
    }

    public void loadNote(Button current, String note) {
       this.current = current;
        HtmlEditor.setHtmlText(note);
    }

    public void save() throws IOException {
        try {
            if (current != null) {
                File sav = new File(DirNote + "/" + current.getText() + "/Note.txt");
                FileWriter saved = new FileWriter(sav);
                saved.write(HtmlEditor.getHtmlText());
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
        HtmlEditor.setHtmlText("");
        if (current != null) {
            File delete = new File(DirNote + "/" + current.getText());
            for (File sup : Objects.requireNonNull(delete.listFiles())) {
                sup.delete();
            }
            delete.delete();
            section.getChildren().remove(current);
        } else {
            Alert exist = new Alert(Alert.AlertType.ERROR);
            exist.setTitle("Erreur");
            exist.setHeaderText("Aucune Note sélectionner");
            exist.setContentText("Erreur : Aucune note n'est sélectionner \n Cliquez sur le bouton de la note pour que celle-ci soit supprimer.");
            exist.showAndWait();
        }
        current = null;
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
