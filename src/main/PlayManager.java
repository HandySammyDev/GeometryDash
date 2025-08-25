package main;

import square.Player;

import java.awt.*;

public class PlayManager {

    //Class
    GamePanel gp;
    KeyHandler keyH;

    //Player Square
    public Player playerS = new Player(gp, keyH, Color.green);
    final int SQR_START_X;
    final int SQR_START_Y;

    //Other
    public boolean gameOn;
    boolean gameOver;

    public PlayManager(){

        //Start Y will be around the center of the play area
        //Start X will be around the left side of the play area
        SQR_START_X = 100;
        SQR_START_Y = 450;

        //Set the starting sqr
        playerS.setXY(SQR_START_X,SQR_START_Y);

    }
    public void update(){

        playerS.update();
    }

    public void draw(Graphics2D g2){
        playerS.draw(g2);
    }
}
