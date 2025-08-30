package square;

import java.awt.*;

public class Square extends Rectangle{

    public int worldX, worldY;
    public int playerX, playerY;
    public int SIZE;
    public int speed;
    public int jump;
    public int rotationRadians;
    public int rotateSpeed;
    public int rotationCounter;
    public Color color;

    public boolean leftCollision, rightCollision, bottomCollision, topCollision;
    public boolean isJump, isRotation;
    public boolean isDead;

    public void setXY(int x, int y){

    }
}