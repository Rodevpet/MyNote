package controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.HTMLEditor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Node implements Initializable {
    @FXML
    VBox section;
    @FXML
    private Pane main;
    @FXML
    private Button Add_Button;
    @FXML
    private Button Remove_Button;
    @FXML
    private Button Save_Button;
    @FXML
    private HTMLEditor Html_Editor;
    @FXML
    private TitledPane Option;
    @FXML
    private ScrollPane ScrollPane;
    @FXML
    private Pane List;

    private final int i = 0;
    private Button current;
    private Add_Button_Controller ABC = new Add_Button_Controller();
    private Remove_Button_Controller RBC = new Remove_Button_Controller();
    private final Save_Button_Controller SBC = new Save_Button_Controller();
    private final Html_Editor_Controller HEC = new Html_Editor_Controller();
    private File DirNote = new File(System.getProperty("user.home")+"/.note");
    protected int index = 0;
    @FXML
    private void closeAction (ActionEvent evt){ System.exit(0); }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            Init_Controller();
        } catch (IOException e) {
            e.printStackTrace();
        }
        section.layoutYProperty().bind((Bindings.when(Option.expandedProperty()).then(82).otherwise(25)));
        if (!DirNote.exists()){
            DirNote.mkdir();
        }
        for (File dur : Objects.requireNonNull(DirNote.listFiles())) {
            if (dur.isDirectory()) {
                File[] files = dur.listFiles((dir1, name) -> name.toLowerCase().endsWith(".fxml"));
                assert files != null;
                for (File file : files) {
                    try {
                        URL url = new File(file.getAbsolutePath()).toURI().toURL();
                        section.getChildren().add(FXMLLoader.load(url));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        ScrollPane.setFitToWidth(true);
        main.heightProperty().addListener((observableValue, number, t1) -> {
            ScrollPane.setMinHeight(main.getHeight());
            List.setMinHeight(main.getHeight());
            section.setMinHeight(main.getHeight());
            Html_Editor.setMinHeight(main.getHeight());
        });
        main.widthProperty().addListener((observableValue, number, t1) -> Html_Editor.setMinWidth(main.getWidth() - 202));
    }
    public void Init_Controller () throws IOException {
        ABC.Join_Controller(this);
        RBC.Join_Controller(this);
        SBC.Join_Controller(this);
        HEC.Join_Controller(this);
        Add_Button.addEventFilter(Event.ANY, ABC);
        Remove_Button.addEventFilter(Event.ANY, RBC);
        Save_Button.addEventFilter(Event.ANY, SBC);
        Html_Editor.addEventFilter(Event.ANY,HEC);
    }
    public HTMLEditor getHtml_Editor(){
        return Html_Editor;
    }

    public File getDirNote (){
        return DirNote;
    }
    public int getIndex (){
        return index;
    }
    public void setIndex(int index){
        this.index=index;
    }
    public VBox getSection (){
        return section;
    }

    public void loadNote(Button current, String note) {
        this.current = current;
        Html_Editor.setHtmlText(note);
    }


    public void setCurrent(Button c){
        current=c;
    }
    public Button getCurrent (){
        return current;
    }

    public void remove() {
        RBC.remove();
    }


    //TODO Voir comment ajouter directement un tableau entre les bonnes balise grâce à xml ou html
    public void add_tab(){
    //TODO Ajouter un tableau
    }

    public void delete_tab(){
      //TODO supprimer un tableau
    }

    public void add_row(){
        //TODO ajouter une ligne
    }

    public void delete_row (){
        //TODO Supprimer une ligne
    }

    public void add_column (){
        //TODO Ajouter une colonne
    }

    public void delete_column (){
        //TODO Supprimer une colone
    }


}
