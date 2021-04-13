package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Add_Controller {
private File note;
    public Add_Controller(String Name) throws IOException {
        File directory = new File(System.getProperty("user.home")+"/.note/"+Name);
        directory.mkdir();
        String Fxml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "\n" +
                "<?import javafx.scene.control.Button?>\n" +
                "\n" +
                "\n" +
                "<Button id=\"onMouseExited\" fx:id=\"Button_Note\" stylesheets=\""+this.getClass().getResource("/resources/style.css")+"\" mnemonicParsing=\"false\"\n" +
                "prefWidth=\"195.0\" text=\"" + Name + "\" xmlns=\"http://javafx.com/javafx/8.0.171\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"controller.Note_Button_Controller\" />\n";
        FileWriter containFxml = new FileWriter(directory + "/" + Name + ".fxml");
        containFxml.write(Fxml);
        containFxml.close();
        note = new File(directory.getAbsolutePath() + "/Note.txt");
        note.createNewFile();
    }

    public File getNote (){
        return note;
    }
}
