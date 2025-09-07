package main;

import block.BlockManager;
import square.Player;

import java.awt.*;
import java.lang.ref.SoftReference;

public class PlayManager {

    //Class
    KeyHandler keyH = new KeyHandler();
    BlockManager bm = new BlockManager(this);

    //Player Square
    public Player playerS = new Player(keyH, Color.green);
    final int SQR_START_X;
    final int SQR_START_Y;

    //Other
    public boolean gameOn;
    boolean gameOver;

    public PlayManager(){

        //Start Y will be around the center of the play area
        //Start X will be around the left side of the play area
//        SQR_START_X = 100;
//        SQR_START_Y = 650;
        SQR_START_X = 500;
        SQR_START_Y = 450;

        //Set the starting sqr
        playerS.setXY(SQR_START_X,SQR_START_Y);

    }
    public void update(){

        playerS.update();
    }

    public void draw(Graphics2D g2){

        bm.draw(g2);
        playerS.draw(g2);
    }
}
