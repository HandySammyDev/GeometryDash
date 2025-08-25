package square;

import java.awt.*;

public class Square extends Rectangle {

    private int x, y;
    public static final int SIZE = 64; // 30x30 block(might need to change to 80x80)
    public int speed = 4;
    public int jump = 10;
    public int rotationRadians = 5;
    public int rotateSpeed = 0;
    public int rotationCounter = 1;
    public Color color;

    public boolean leftCollision, rightCollision, bottomCollision; //might not need left collision
    public boolean isJump, isRotation;
    public boolean isDead;

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

    }
    public void jump(){

    }
    public void collision(){

    }

    public void update(){

        rotateSpeed++;
        moves();
        if(rotateSpeed > 20){

            rotationRadians += 5;

            if(rotationRadians==90){
                rotationRadians = 0;
            }
            rotateSpeed = 0;
        }
    }

    public void draw(Graphics2D g2){

        // Enable better rendering quality
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Moves the origin to the center of the square
        g2.translate(x,y); //100, 400

        // Rotates around the new origin
        g2.rotate(rotationRadians);

        // Draw sqr centered at (0,0)
        g2.setColor(color);
        g2.fillRect(-SIZE/2, -SIZE/2, SIZE, SIZE); //-32, -32, 64,64
    }
}
