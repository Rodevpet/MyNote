package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.Join_Model;
import model.Path_Note;
import view.Dialog_Window_Error_Not_Found_Note;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Remove_Button_Controller implements EventHandler<Event>, Join_Controller, Join_Model {
    private Node node;
    private Path_Note path_note;
    public void remove() {
        node.getHtml_Editor().setHtmlText("");
        if (node.getCurrent() != null) {
            File delete = new File(path_note.getDirNote().getAbsolutePath() + "/" + node.getCurrent().getText());
            for (File sup : Objects.requireNonNull(delete.listFiles())) {
                sup.delete();
            }
            delete.delete();
            node.getSection().getChildren().remove(node.getCurrent());
            try {
                if (node.getSection().getChildren().get(node.getIndex())!=null){
                    node.setCurrent((Button)node.getSection().getChildren().get(node.getIndex()));
                    node.getCurrent().setId("onMouseEntered");
                }
            }catch (IndexOutOfBoundsException e) {
            }
        } else {
            new Dialog_Window_Error_Not_Found_Note();
            node.setCurrent(null);
        }
    }

    public void setController(Node node) {
        this.node = node;
    }

    @Override
    public void Join_Controller(Node node) throws IOException {
        this.node = node;
    }

    @Override
    public void handle(Event event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED){
            remove();
        }
    }

    @Override
    public void Join_Path_Note(Path_Note path_note) {
        this.path_note = path_note;
    }
}
