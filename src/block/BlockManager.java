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
    int mapBlockNumber[][];

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

            int col = 0;
            int row = 0;

            while (col < GamePanel.screenBlockCol && row < GamePanel.screenBlockRow) {

                String line = br.readLine();

                while(col < GamePanel.screenBlockRow){

                    String numbers[] = line.split( " ");

                    int num = Integer.parseInt(numbers[col]);

                    mapBlockNumber[col][row] = num;
                    col++;
                }
                if(col == GamePanel.screenBlockCol){
                    col = 0;
                    row++;
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

        while(worldCol < GamePanel.screenBlockCol && worldRow < GamePanel.screenBlockRow){

            int blockSize = GamePanel.blockSize;
            int blockNumber = mapBlockNumber[worldCol][worldRow];

            int worldX = worldCol * blockSize; //64
            int worldY = worldRow * blockSize; //64
            int screenX = worldX - pm.playerS.worldX + pm.playerS.screenX;
            int screenY = worldY - pm.playerS.worldY + pm.playerS.screenY;

            //We create a boundary from the player(center) to the edges of the screen
            //Optimise code for rendering performance
            if(worldX + blockSize > pm.playerS.worldX - pm.playerS.screenX &&
               worldX - blockSize < pm.playerS.worldX + pm.playerS.screenX &&
               worldY + blockSize > pm.playerS.worldY - pm.playerS.screenY &&
               worldY - blockSize < pm.playerS.worldY + pm.playerS.screenY){

                g2.setColor(block[blockNumber].color);
                g2.fillRect(screenX, screenY, blockSize, blockSize);
            }

            worldCol++;

            if(worldCol == GamePanel.screenBlockCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
