package block;

import java.awt.*;

public class Block extends Rectangle {

    public int x, y;
    public static final int SIZE = 30; // 30x30 block(might need to change to 80x80)
    public Color c;

    public Block(Color c){
        this.c = c;
    }
    public void draw(Graphics2D g2){
        g2.setColor(c);
        g2.fillRect(x, y, SIZE,SIZE);
    }
}
