package edit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.Home_Controller;
import main.Main;

import java.io.IOException;

public class Controller {
    @FXML
    Button button;

    public void load() throws IOException {
        Home_Controller load = (Home_Controller) Main.getLoader();
        load.loadNote(button.getText(), new ResearchNote().researchNote("MyNote/" + button.getText() + "/Note.txt"));
    }
}
