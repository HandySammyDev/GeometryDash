package square;

import main.GamePanel;
import main.KeyHandler;

import java.awt.*;

public class Player extends Square{

    public final int screenX;
    public final int screenY;

    //Pause
    private boolean pause = false;

    public Player(KeyHandler keyH, Color color){
        this.color = color;

        screenX = GamePanel.screenWidth/2 - (GamePanel.blockSize/2);  // 1280/2 - (64/2) = 608
        screenY = GamePanel.screenHeight/2 - (GamePanel.blockSize/2); // 720/2  - (64/2) = 328

        setDefaultValues();
    }

    public void setXY(int x, int y){
        this.playerX = x;
        this.playerY = y;
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
    public void moves(){
        if(KeyHandler.pausePressed){
            playerX += 2;
        }
    }
    public void rotation(){
        rotateSpeed++;

        if(rotateSpeed > 20){

            rotationRadians += 5;

            if(rotationRadians==90){
                rotationRadians = 0;
                finishedRotate = false;
            }
            rotateSpeed = 0;
        }
    }

    public void jump(){
        if(KeyHandler.spacePressed){
            playerY -= 5;
        }
        else{
            playerY += 5;
        }
    }
    public void collision(){

    }
    public void pauseGame(){

    }

    private boolean finishedRotate = true;
    public void update(){

        moves();
        //jump();
    }

    public void draw(Graphics2D g2){

        // Enable better rendering quality
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Moves the origin to the center of the square
        g2.translate(playerX,playerY); //100, 450

        // Rotates around the new origin
//        g2.rotate(rotationRadians);

        // Draw sqr centered at (0,0)
        g2.setColor(color);
        g2.fillRect(-SIZE/2, -SIZE/2, SIZE, SIZE); //-32, -32, 64,64
    }
}
