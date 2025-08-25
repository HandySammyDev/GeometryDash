package block;

import main.GamePanel;

public class BlockManager {

    GamePanel gp;
    Block[] block;
    int mapBlockNumber[][];

    public BlockManager(GamePanel gp){

        this.gp = gp;

        block = new Block[10];
        mapBlockNumber = new int[gp.screenBlockCol][gp.screenBlockRow];

        getBlockColor();
        loadMap("/maps/mapDemo1.txt");
    }

    
}
