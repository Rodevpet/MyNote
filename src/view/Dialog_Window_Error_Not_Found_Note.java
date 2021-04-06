package view;

import javafx.scene.control.Alert;

public class Dialog_Window_Error_Not_Found_Note {
    public Dialog_Window_Error_Not_Found_Note(){
        Alert exist = new Alert(Alert.AlertType.ERROR);
        exist.setTitle("Erreur");
        exist.setHeaderText("Aucune Note sélectionner");
        exist.setContentText("Erreur : Aucune note n'est sélectionner \n Cliquez sur le bouton de la note pour que celle-ci soit supprimer.");
        exist.showAndWait();
    }
}
