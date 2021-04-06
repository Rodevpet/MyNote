package model;

import java.util.ArrayList;

public class shortcut {
    private String text_entered = "";
    private String text_out = null;
    public shortcut (ArrayList text){
        int x = 0;
        System.out.println(text.size());
        while (x!=text.size()){
            text_entered += text.get(x);
            ++x;
        }
        System.out.println(text_entered);
        if (text_entered.equals("tst")){
            text_out = "test";
        }
    }

    public String getShortcut (){
        return text_out;
    }

    public String getText_entered (){
        return text_entered;
    }
}
