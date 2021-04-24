package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import model.Book_Note;
import model.Button_Note;
import model.Note_Parent_Child;
import model.Path_Note;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Objects;

public class Three_Controller implements Join {
    private Events_Manager events_manager;
    private Book_Note Node;
    private Path_Note path_note = new Path_Note();
    private ArrayList <Note_Parent_Child> Tree = new ArrayList<Note_Parent_Child>();
    public void Init (){
        listeRepertoire(new Path_Note().getPath_Note(),events_manager.getSection());
        /*System.err.println("Parent | Child");
        for (int i=0; i!=Tree.size();i++){
            if (i==1){
                events_manager.getTree_view().setRoot(new Book_Note(Tree.get(i).getParent(),events_manager,Tree.get(i).getPath()));
            }
            System.err.println(Tree.get(i).getParent()+" | "+Tree.get(i).getChild());
        }*/
        }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
    public void listeRepertoire ( File repertoire, Book_Note book_note ) {
        if ( repertoire.isDirectory ( ) ) {
            Book_Note b = new Book_Note(repertoire.getName(),events_manager,repertoire);
            book_note.getChildren().add(b);
            book_note = b;
            //Tree.add(new Note_Parent_Child(repertoire.getParentFile().getName(),repertoire.getName(),repertoire));
            File[] list = repertoire.listFiles();
            if (list != null){
                for ( int i = 0; i < list.length; i++) {
                    // Appel récursif sur les sous-répertoires
                    listeRepertoire( list[i],b);
                }
            } else {
                System.err.println(repertoire + " : Erreur de lecture.");
            }
        }else{
            book_note.getChildren().add(new TreeItem(new Button_Note(repertoire.getName(),events_manager,repertoire)));
        }
    }
}
