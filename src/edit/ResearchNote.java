package edit;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ResearchNote {
    private static File note;
    private static FileReader recup;
    public static String researchNote(String path) throws IOException {
        note = new File(path);
        recup = new FileReader(note);
        int i = 0;
        String r = "";
        while ((i = recup.read()) != -1) {
            r += (char) i;
        }
        return r;
    }

    public static void ferme() throws IOException {
        System.out.println(recup);
        recup.close();
    }
}
