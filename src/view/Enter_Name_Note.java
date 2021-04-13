package view;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Enter_Name_Note {
    public Optional<String> Enter_Name_Note(){
        TextInputDialog CreateNote = new TextInputDialog();
        CreateNote.setTitle("Créer une Note");
        CreateNote.setHeaderText("Veuillez saisir le nom de la note à créer : ");
        Optional<String> Name = CreateNote.showAndWait();
        return Name;
    }
}
