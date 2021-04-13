package model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import controller.Events_Manager;

import java.io.IOException;

public class Controller {
    @FXML
    Button button;
    private static Button history;
    private static boolean New;
    public void load() throws IOException {
        focus();
        Events_Manager load = (Events_Manager) Main.getLoader();
        //load.loadNote(button, new ResearchNote().ResearchNote(System.getProperty("user.home")+"/.Note/"+button.getText() + "/Note.txt"));
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
