package model;

public enum MODE_BUTTON {
    ON_MOUSE_CLICKED (0),
    ON_MOUSE_EXITED (1),
    ON_MOUSE_ENTERED (2);

    int MODE;

    MODE_BUTTON (int Mode){
        this.MODE = Mode;
    }

    public int get (){
        return MODE;
    }
}
