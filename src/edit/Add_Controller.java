package edit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Add_Controller {

    public Add_Controller(String Name) throws IOException {
        Properties info = System.getProperties();
        String user = info.getProperty("user.name");
        File directory = new File("/Users/"+user+"/Documents/Note/" + Name);
        directory.mkdir();
        String Fxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<?import javafx.scene.control.Button?>\n" +
                "\n" +
                "\n" +
                "<Button id=\"NoFocus\" fx:id=\"button\" mnemonicParsing=\"false\" stylesheets=\"@../style.css\" \n" +
                " onMouseEntered=\"#onMouseEntered\" onMouseExited=\"#onMouseExited\" onAction=\"#load\" prefWidth=\"195.0\" text=\"" + Name + "\" xmlns=\"http://javafx.com/javafx/8.0.171\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"edit.Controller\" />\n";
        FileWriter containFxml = new FileWriter(directory + "/" + Name + ".fxml");
        containFxml.write(Fxml);
        containFxml.close();
        File note = new File(directory.getAbsolutePath() + "/Note.txt");
        note.createNewFile();
    }
}
