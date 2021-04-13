package view;

import javafx.scene.control.Alert;

public class Warning_Note_Not_Found {
    public Warning_Note_Not_Found (){
        Alert exist = new Alert(Alert.AlertType.ERROR);
        exist.setTitle("Erreur");
        exist.setHeaderText("Aucune Note sélectionner");
        exist.setContentText("Erreur : Aucune note n'est sélectionner \n Cliquez sur le bouton de la note pour que celle-ci soit supprimer.");
        exist.showAndWait();
    }
}
