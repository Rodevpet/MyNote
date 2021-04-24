package model;

import java.io.File;

public class Note_Parent_Child {
    private String Parent;
    private String Child;
    private File Path;
    public Note_Parent_Child(String Parent, String Child, File Path){
        this.Parent = Parent;
        this.Child = Child;
        this.Path = Path;
    }

    public String getParent (){return Parent;}
    public String getChild (){return Child;}
    public File getPath (){return Path;}
}
