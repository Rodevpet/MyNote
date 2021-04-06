package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ResearchNote {
    private File NoteLoading;
    private FileReader recovery;

    public String ResearchNote(String path) {
        NoteLoading = new File (path);
        try {
            recovery = new FileReader(NoteLoading);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int i = 0;
        String r = "";
        while (true) {
            try {
                if (!((i = recovery.read()) != -1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            r += (char) i;
        }
        try {
            recovery.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }
}
