package model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResearchNote {
    private File NoteLoading;
    private FileReader recovery;

    public ResearchNote() {
    }

    public String ResearchNote(String path) throws IOException {
        NoteLoading = new File (path);
        recovery = new FileReader(NoteLoading);
        int i = 0;
        String r = "";
        while ((i = recovery.read()) != -1) {
            r += (char) i;
        }
        recovery.close();
        return r;
    }
}
