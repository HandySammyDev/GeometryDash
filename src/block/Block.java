package block;

import java.awt.*;

public class Block extends Rectangle {

    public Color color;
    public int x, y;
    public final int SIZE = 64;
    public boolean collision = false;

    public Block(Color color){
        this.color = color;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fillRect(x,y,SIZE,SIZE);
    }
}
