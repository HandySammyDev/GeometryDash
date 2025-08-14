package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 5;
    final int tileSize = originalTileSize * scale; //80x80 tile

    //Ratio 16x9 (1280x720)
    final int maxScreenCol = 16;
    final int maxScreenRow = 9;
    final int screenWidth = tileSize * maxScreenCol; //1280
    final int screenHeight = tileSize * maxScreenRow; //720

    final int FPS = 60;

    //Set player's default positions
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    int playerJump = 20;

    //Key inputs
    KeyHandler keyHandler = new KeyHandler();

    Thread gameThread;

    GamePanel(){

        //Panel Settings
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(null);

        //Implement KeyListner
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

        //pm = new PlayManager
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

        //Key inputs
        if(keyHandler.upPressed){
            playerY -= playerJump;
        }
        if(keyHandler.downPressed){
            playerY += playerSpeed;
        }
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose();
    }
}
