package edit;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import main.Home_Controller;
import main.Main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Controller {
    @FXML
    Button button;
    private static Button history;
    private static boolean New;
    public void load() throws IOException {
        focus();
        Home_Controller load = (Home_Controller) Main.getLoader();
        load.loadNote(button, new ResearchNote().ResearchNote(System.getProperty("user.home")+"/.Note/"+button.getText() + "/Note.txt"));
        nofocus();
    }

    public void onMouseEntered (){
        if (!button.getId().equals("Focus")) {
            button.setId("onMouseEntered");
        }
    }

    public void  focus (){
            button.setId("Focus");
    }

    public void nofocus (){
        if (history != button && history!=null) {
            history.setId("NoFocus");
        }
        history = button;
    }

    public void onMouseExited() {
        if (!button.getId().equals("Focus")){
            button.setId("NoFocus");
        }
    }

    public static void setHistory(Button History){
        history = History;
    }
}
