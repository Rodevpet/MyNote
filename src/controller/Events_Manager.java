package controller;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
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
import java.util.ResourceBundle;

public class Events_Manager implements Initializable{
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
    public HTMLEditor Html_Editor;
    @FXML
    private TitledPane Option;
    @FXML
    private ScrollPane ScrollPane;
    @FXML
    private Pane List;
    private Button Current_Button;
    private final Add_Button_Controller ABC = new Add_Button_Controller();
    private final Remove_Button_Controller RBC = new Remove_Button_Controller();
    private final Save_Button_Controller SBC = new Save_Button_Controller();
    private final Html_Editor_Controller HEC = new Html_Editor_Controller();
    private final Three_Controller TC = new Three_Controller();
    private Note_Button_Controller NBC = new Note_Button_Controller();
    private int i = 0;
    private Button current;
    private File DirNote = new File(System.getProperty("user.home")+"/.note");
    protected int index = 0;

    public Events_Manager() {
    }

    @FXML
    private void closeAction (ActionEvent evt){ System.exit(0); }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            Init_Controller();
            TC.Init();
        } catch (IOException e) {
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
    public void Init_Controller () throws IOException {
        ABC.Join_Manager(this);
        RBC.Join_Manager(this);
        SBC.Join_Manager(this);
        HEC.Join_Manager(this);
        TC.Join_Manager(this);
        NBC.setEvents_manager(this);
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
    public VBox getSection (){
        return section;
    }

    public Button getCurrent_Button() {
        return Current_Button;
    }
    public void setCurrent_Button(Button Current_Button){
        this.Current_Button = Current_Button;
    }



}
