package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import model.Join_Model;
import model.Path_Note;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Node implements Initializable, Join_Model {
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
    private Button Button_Note;
    @FXML
    private TitledPane Option;
    @FXML
    private ScrollPane ScrollPane;
    @FXML
    private Pane List;

    private Button current;
    private Path_Note path_note;
    private final Add_Button_Controller ABC = new Add_Button_Controller();
    private final Remove_Button_Controller RBC = new Remove_Button_Controller();
    private final Save_Button_Controller SBC = new Save_Button_Controller();
    private final Html_Editor_Controller HEC = new Html_Editor_Controller();
    private final Button_Note_Controller BNC = new Button_Note_Controller();
    private final Path_Note PN = new Path_Note();
    private int index = 0;
    @FXML
    private void closeAction (ActionEvent evt){ System.exit(0); }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            Init_Controller();
            Init_Model();
            //TODO Here, We must create a class that contains template of Note Button beacause the Arraylist is not good
            if (path_note.indexation() != null) {
                ArrayList<URL> path_note_list = path_note.indexation();
                for (int i = 0; i != path_note_list.size(); i++) {
                    section.getChildren().add(FXMLLoader.load(path_note_list.get(i)));
                }
            }
            } catch(IOException e){
                e.printStackTrace();
            }


        section.layoutYProperty().bind((Bindings.when(Option.expandedProperty()).then(82).otherwise(25)));

        ScrollPane.setFitToWidth(true);
        main.heightProperty().addListener((observableValue, number, t1) -> {
            ScrollPane.setMinHeight(main.getHeight());
            List.setMinHeight(main.getHeight());
            section.setMinHeight(main.getHeight());
            Html_Editor.setMinHeight(main.getHeight());
        });
        main.widthProperty().addListener((observableValue, number, t1) -> Html_Editor.setMinWidth(main.getWidth() - 202));
    }
    private void Init_Controller () throws IOException {
        ABC.Join_Controller(this);
        RBC.Join_Controller(this);
        SBC.Join_Controller(this);
        HEC.Join_Controller(this);
        BNC.Join_Controller(this);
        PN.Join_Controller(this);
        Add_Button.addEventFilter(Event.ANY, ABC);
        Remove_Button.addEventFilter(Event.ANY, RBC);
        Save_Button.addEventFilter(Event.ANY, SBC);
        Html_Editor.addEventFilter(Event.ANY,HEC);
    }

    private void Init_Model (){
        ABC.Join_Path_Note(path_note);
        RBC.Join_Path_Note(path_note);
        SBC.Join_Path_Note(path_note);
    }
    public HTMLEditor getHtml_Editor(){
        return Html_Editor;
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



    public void setCurrent(Button current){
        this.current=current;
    }
    public Button getCurrent (){
        return current;
    }


    @Override
    public void Join_Path_Note(Path_Note path_note) {
        this.path_note = path_note;
    }
}
