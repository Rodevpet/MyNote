package model;

import java.io.File;

public class Path_Note {
    private final File Path_Note = new File(System.getProperty("user.home")+"/.note/");

    public File getPath_Note (){return Path_Note;}
}
