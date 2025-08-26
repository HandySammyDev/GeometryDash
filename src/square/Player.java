package square;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Square{

    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(KeyHandler keyH, Color color){
        this.color = color;
        this.keyH = keyH;

        screenX = GamePanel.screenWidth/2 - (GamePanel.blockSize/2);
        screenY = GamePanel.screenHeight/2 - (GamePanel.blockSize/2);

        setDefaultValues();
    }

    public void setXY(int x, int y){
        this.worldX = x;
        this.worldY = y;
    }
    public void setDefaultValues(){
        this.SIZE = 64;
        this.speed = 4;
        this.jump = 10;
        this.rotationRadians = 5;
        this.rotateSpeed = 0;
        this.rotationCounter = 0;

        this.leftCollision = false;
        this.rightCollision = false;
        this.bottomCollision = false;
        this.topCollision = false;

        this.isJump = false;
        this.isRotation = false;
        this.isDead = false;
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
