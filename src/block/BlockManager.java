package block;

import main.GamePanel;
import main.PlayManager;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BlockManager {

    PlayManager pm;
    Block[] block;
    int[][] mapBlockNumber;
    boolean stopRender = false;

    public BlockManager(PlayManager pm){

        this.pm = pm;

        block = new Block[10];
        mapBlockNumber = new int[GamePanel.screenBlockCol][GamePanel.screenBlockRow];

        getBlockColor();
        loadMap("/maps/mapDemo1.txt");
    }

    public void getBlockColor(){
        block[0] = new Block(Color.blue);
        block[1] = new Block(Color.red);
        block[2] = new Block(Color.magenta);
        block[3] = new Block(Color.yellow);
    }
    public void loadMap(String mapFile){

        try {
            InputStream is = getClass().getResourceAsStream(mapFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int row = 0;
            int col = 0;

            while(row < GamePanel.screenBlockRow && col < GamePanel.screenBlockCol){

                String line = br.readLine(); //0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

                while(row < GamePanel.screenBlockRow){

                    String[] numbers = line.split(" ");

                    mapBlockNumber = new int[row][col];
                    //Wrong btw
                }
            }

            br.close();

        } catch(Exception e){

        }
    }
    // Draw blocks
    public void draw(Graphics2D g2){

        int worldCol = 0;
        int worldRow = 0;
        int x = 0;
        int y = 0;
        int blockSize = 64;

        while(worldCol < GamePanel.screenBlockCol && worldRow < GamePanel.screenBlockRow){

            block[0].setXY(x,y);
            block[0].draw(g2);

            x += blockSize;
            worldRow++;

            if(worldRow==GamePanel.screenBlockRow){
                worldRow = 0;
                worldCol++;

                y += blockSize;
                x = 0;
            }
        }
    }
}
