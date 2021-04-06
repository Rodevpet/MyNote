package model;

import controller.Add_Button_Controller;
import controller.Join_Controller;
import controller.Node;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class Path_Note implements Join_Controller {
    private final int PATH_ROOT_EXIST = 0;
    private final int PATH_ROOT_NOT_EXIST = 1;
    private final int PATH_NOTE_EXIST = 2;
    private final int PATH_NOTE_NOT_EXIST = 3;
    private final File DirNote = new File(System.getProperty("user.home")+"/.note");
    private Node node;
    private final Add_Button_Controller BN = new Add_Button_Controller();
    private ArrayList <URL> eo = new ArrayList<URL>();
    public ArrayList<URL> indexation () throws MalformedURLException {
        for (File root : Objects.requireNonNull(DirNote.listFiles())) {
            if (Dir_Exist()==PATH_ROOT_EXIST)
                if (Is_Dir (root)==PATH_NOTE_EXIST){
                    File[] files = root.listFiles((dir1, name) -> name.toLowerCase().endsWith(".fxml"));
                    assert files != null;
                    for (File Fxml_Note : files) {
                        try {
                            URL url = new File(Fxml_Note.getAbsolutePath()).toURI().toURL();
                            eo.add(url);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
        if (eo != null){
            return eo;
        }else {
            return null;
        }
    }

    private int Is_Dir(File root) {
        if (root.isDirectory()){
            return PATH_NOTE_EXIST;
        }else {
            return PATH_NOTE_NOT_EXIST;
        }
    }

    public int Dir_Exist (){
        if (!DirNote.exists()){
            DirNote.mkdir();
            return PATH_ROOT_EXIST;
        }else {
            return PATH_ROOT_NOT_EXIST;
        }
    }

    public File getDirNote (){
        return DirNote;
    }

    @Override
    public void Join_Controller(Node node) throws IOException {
        this.node = node;
        node.Join_Path_Note(this);
    }

}
