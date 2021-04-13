package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.shortcut;

import java.io.IOException;
import java.util.ArrayList;

public class Html_Editor_Controller implements EventHandler <Event>, Join {
    private Events_Manager events_manager;
    private ArrayList<String> ch = new ArrayList<String>();;

    @Override
    public void handle(Event event) {
        if (KeyEvent.KEY_PRESSED.equals(event)) {
            OnKeyPressed((KeyEvent) event);
        }
    }

    public void OnKeyPressed (KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE || keyEvent.getCode() == KeyCode.ENTER) {
                    shortcut n = new shortcut(ch);
                    String v = n.getShortcut();
                    String f = n.getText_entered();
                    String text = events_manager.getHtml_Editor().getHtmlText();
                    events_manager.getHtml_Editor().setHtmlText(text.replace(f, v));
                    ch.clear();
                    events_manager.getHtml_Editor().requestFocus();
                    events_manager.getHtml_Editor().getCursor();
                } else {
                    ch.add(keyEvent.getText());
                }
                ;
    }

    @Override
    public void Join_Manager(Events_Manager events_manager) throws IOException {
        this.events_manager = events_manager;
    }
}
