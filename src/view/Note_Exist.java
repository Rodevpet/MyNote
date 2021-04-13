package view;

import javafx.scene.control.Alert;

public class Note_Exist {
    public Note_Exist(){
        Alert exist = new Alert(Alert.AlertType.ERROR);
        exist.setTitle("Erreur");
        exist.setHeaderText("Note déjà existante");
        exist.setContentText("Erreur : la note que vous essayez de créer existe déjà.");
        exist.showAndWait();
    }
}
