package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalBlockSize = 16; //16x16 tile
    final int scale = 4;
    final int blockSize = originalBlockSize * scale; //64x64 tile

    //Ratio 16x9 (1280x720)
    public final int screenBlockCol = 11;
    public final int screenBlockRow = 18;
    final int screenHeight = blockSize * screenBlockCol; //720
    final int screenWidth = blockSize * screenBlockRow; //1280

    final int FPS = 60;

    //Key inputs
    KeyHandler keyHandler = new KeyHandler();

    Thread gameThread;
    PlayManager pm = new PlayManager();

    GamePanel(){

        //Panel Settings
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(null);

        //Implement KeyListener
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){

        //Runs and updates in the background
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){


            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        pm.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        pm.draw(g2);
    }
}
