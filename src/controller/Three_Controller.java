package controller;

import javafx.scene.control.TreeItem;
import model.Note_Book;
import model.Button_Note;
import model.Note_Parent_Child;
import model.Path_Note;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Three_Controller implements Join {
    private Events_Manager events_manager;
    private boolean root = true;
    private Path_Note path_note = new Path_Note();
    private ArrayList <Note_Parent_Child> Tree = new ArrayList<Note_Parent_Child>();
    public void Init (){
        listeRepertoire(new Path_Note().getPath_Note(),null);
        }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
    public void listeRepertoire ( File repertoire, Note_Book noteBook) {
        if ( repertoire.isDirectory ( ) ) {
            Note_Book b = null;
            if (root==true){
                b = new Note_Book("/",events_manager,repertoire);
                events_manager.getTree_view().setRoot(b);
                root = false;
            }else{
                b = new Note_Book(repertoire.getName(),events_manager,repertoire);
                noteBook.getChildren().add(b);
            }
            noteBook = b;
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
            noteBook.getChildren().add(new TreeItem(new Button_Note(repertoire.getName(),events_manager,repertoire)));
        }
    }
}
