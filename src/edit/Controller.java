package edit;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import main.Home_Controller;
import main.Main;

import java.io.IOException;

public class Controller {
    @FXML
    Button button;

    private Button history;
    public void load() throws IOException {
        button.setStyle("-fx-background-color: grey");
        Home_Controller load = (Home_Controller) Main.getLoader();
        load.loadNote(button, ResearchNote.researchNote("MyNote/" + button.getText() + "/Note.txt"));
        if (history != null)
        history.setStyle("-fx-background-color : white");
        history = button;
    }
}
