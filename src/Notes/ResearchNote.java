package Notes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResearchNote {

    public String researchNote(String path) throws IOException {
        File note = new File(path);
        FileReader recup = new FileReader(note);
        int i = 0;
        String r = "";
        while ((i = recup.read()) != -1) {
            r += (char) i;
        }
        return r;
    }
}
