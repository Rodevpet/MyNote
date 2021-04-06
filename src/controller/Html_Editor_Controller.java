package controller;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.shortcut;

import java.util.ArrayList;

public class Html_Editor_Controller implements EventHandler <Event>, Join_Controller {
    private Node node;
    private final ArrayList<String> ch = new ArrayList<>();

    @Override
    public void Join_Controller(Node node) {
        this.node = node;
    }

    @Override
    public void handle(Event event) {
        if (event.getEventType() == KeyEvent.KEY_PRESSED) {
            OnKeyPressed((KeyEvent) event);
        }
    }

    private void OnKeyPressed (KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.SPACE || keyEvent.getCode() == KeyCode.ENTER) {
                    shortcut n = new shortcut(ch);
                    String v = n.getShortcut();
                    String f = n.getText_entered();
                    String text = node.getHtml_Editor().getHtmlText();
                    node.getHtml_Editor().setHtmlText(text.replace(f, v));
                    ch.clear();
                    node.getHtml_Editor().requestFocus();
                    node.getHtml_Editor().getCursor();
                } else {
                    ch.add(keyEvent.getText());
                }
    }
}
