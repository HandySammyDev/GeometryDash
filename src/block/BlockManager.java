package block;

import main.GamePanel;
import main.PlayManager;

import java.awt.*;
import java.io.*;

public class BlockManager {

    PlayManager pm;
    Block[] block;
    int[][] mapBlockNumber;
    private int rows = GamePanel.screenBlockRow;
    private int cols = GamePanel.screenBlockCol * 2; // ERROR PRONE: Since we added double cols to the map

    public BlockManager(PlayManager pm){

        this.pm = pm;

        block = new Block[10];
        mapBlockNumber = new int[rows][cols];

        getBlockColor();
        loadMap("src/maps/mapDemo1.txt");
    }

    public void getBlockColor(){
        block[0] = new Block(Color.blue);
        block[1] = new Block(Color.red);
        block[2] = new Block(Color.magenta);
        block[3] = new Block(Color.yellow);
    }
    public void loadMap(String mapFile){

        try(BufferedReader br = new BufferedReader(new FileReader(mapFile))){
            String line;
            int row = 0;

            while((line = br.readLine()) != null && row < rows){

                String[] values = line.trim().split("\\s+"); // split by spaces

                for(int col = 0; col < cols; col++){
                    mapBlockNumber[row][col] = Integer.parseInt(values[col]);
                }

                row++;
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Draw blocks
    public void draw(Graphics2D g2){

        int blockSize = GamePanel.blockSize; //Change this to gp.blockSize

        for(int worldRow = 0; worldRow < rows; worldRow++){
            for(int worldCol = 0; worldCol < cols; worldCol++){

                int blockType = mapBlockNumber[worldRow][worldCol];

                int worldX = worldCol * blockSize;
                int worldY = worldRow * blockSize;
                int screenX = worldX - pm.playerS.playerX + pm.playerS.screenX;
                int screenY = worldY - pm.playerS.playerY + pm.playerS.screenY;

                //Helps with performance
                if(worldX + blockSize > pm.playerS.playerX - pm.playerS.screenX &&
                        worldX - blockSize < pm.playerS.playerX + pm.playerS.screenX &&
                        worldY + blockSize > pm.playerS.playerY - pm.playerS.screenY &&
                        worldY - blockSize < pm.playerS.playerY + pm.playerS.screenY) {

                    block[blockType].setXY(screenX, screenY);
                    block[blockType].draw(g2);
                }
            }
        }
    }
//    public void draw(Graphics2D g2){
//
//        int blockSize = 64;
//
//        for(int row = 0; row < rows; row++){
//            for(int col = 0; col < cols; col++){
//
//                int blockType = mapBlockNumber[row][col];
//                int x = col * blockSize;
//                int y = row * blockSize;
//
//                block[blockType].setXY(x,y);
//                block[blockType].draw(g2);
//            }
//        }
//    }
}