package block;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import main.KeyHandler;

public class Square extends Rectangle {

    private int x, y;
    public static final int SIZE = 64; // 30x30 block(might need to change to 80x80)
    public int speed = 7;
    public int jump = 10;
    public Color color;

    public boolean leftCollision, rightCollision, bottomCollision; //might not need left collision
    public boolean isJump, isRotation;
    public boolean isDead;

    Graphics2D g2D;
    Rectangle2D.Double r = new Rectangle2D.Double(x,y,SIZE,SIZE);

    public Square(Color color){
        this.color = color;
    }

    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void moves(){
        x += speed;
    }
    public void rotation(){

        g2D.setColor(color);
        g2D.rotate(Math.toRadians(0));
        g2D.fill(r);

        int X = x+width;
        int Y = y+height;
        int round = 1;

        int i = 0;
        while(KeyHandler.spacePressed){

            while(i<90){

                g2D.translate(x,y);
                g2D.rotate(Math.toRadians(i), X, Y);  // rotate around the bottom-right corner of the rectangle
            }
        }

    }
    public void jump(){

    }
    public void collision(){

    }

    public void update(){

        rotation();
        moves();
    }

    public void draw(Graphics2D g2){

        this.g2D = g2;

        g2D.setColor(color);
        g2D.fillRect(x, y, SIZE,SIZE);
    }
}
