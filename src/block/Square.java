package block;

import java.awt.*;

public class Square extends Rectangle {

    private int x, y;
    public static final int SIZE = 80; // 30x30 block(might need to change to 80x80)
    public int speed = 10;
    public int jump = 10;
    public Color c;

    public boolean leftCollision, rightCollision, bottomCollision; //might not need left collision
    public boolean isJump, isRotation;
    public boolean isDead;

    public Square(Color c){
        this.c = c;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void rotation(){
        
    }

    public void draw(Graphics2D g2){
        g2.setColor(c);
        g2.fillRect(x, y, SIZE,SIZE);
    }
}
