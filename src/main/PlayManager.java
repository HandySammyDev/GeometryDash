package main;

import block.Square;

import java.awt.*;

public class PlayManager {

    //Mino
    Square s = new Square(Color.green);
    final int SQR_START_X;
    final int SQR_START_Y;

    //Other
    public int dropInterval = 60;
    public boolean gameOn;
    boolean gameOver;

    public PlayManager(){

        //Start Y will be around the center of the play area
        //Start X will be around the left side of the play area
        SQR_START_X = 100;
        SQR_START_Y = 400;

        //Set the starting sqr
        s.setXY(SQR_START_X,SQR_START_Y);

    }
    public void update(){
        s.update();
    }

    public void draw(Graphics2D g2){
        s.draw(g2);
    }
}
