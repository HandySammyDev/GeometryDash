package block;

import java.awt.*;

public class Block extends Rectangle {

    private Color color;
    public final int SIZE = 64;
    public boolean collision = false;

    public Block(Color color){
        this.color = color;
    }
}
