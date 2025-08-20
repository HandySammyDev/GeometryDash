package main;

import block.PlayerSqr;

import java.awt.*;

public class PlayManager {

    //Main Play Area
    final int WIDTH = GamePanel.WIDTH;
    final int HEIGHT = GamePanel.HEIGHT;
    public static int left_x = 0;
    public static int right_x = 1280;
    public static int top_y = 0;        //Might be flipped
    public static int bottom_y = 720;

    //Mino
    PlayerSqr ps = new PlayerSqr(Color.green);
    final int SQR_START_X;
    final int SQR_START_Y;

    //Other
    public static int dropInterval = 60;
    boolean gameOver;

    public PlayManager(){

        //Start Y will be around the center of the play area
        //Start X will be around the left side of the play area
        SQR_START_X = left_x + 100;
        SQR_START_Y = top_y + (bottom_y/2);

        //Set the starting sqr
        ps.setXY(SQR_START_X,SQR_START_Y);

    }

    public void draw(Graphics2D g2){

    }
}
