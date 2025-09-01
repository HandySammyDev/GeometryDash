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

    public BlockManager(PlayManager pm){

        this.pm = pm;

        block = new Block[10];
        mapBlockNumber = new int[GamePanel.screenBlockRow][GamePanel.screenBlockCol];

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

            while(row < GamePanel.screenBlockRow && col < GamePanel.screenBlockCol){

                String line = br.readLine(); //0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

                while(col < GamePanel.screenBlockCol){

                    String[] numbers = line.split(" "); //separates all the numbers by using spaces and puts em in a array

                    int number = Integer.parseInt(numbers[col]);

                    mapBlockNumber[row][col] = number;

                    col++;
                }

                if(col == GamePanel.screenBlockCol){
                    row++;
                    col = 0;
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

            int blockType = mapBlockNumber[worldRow][worldCol];

            block[blockType].setXY(x,y);
            block[blockType].draw(g2);

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
