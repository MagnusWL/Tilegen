package tilegen;

import java.awt.Color;
import java.awt.Graphics;

public class Tile
{
    public static int TileWidth = 128, TileHeight = 128;
    public static int TileTileSize = 32;
    public static int TileTileW = TileWidth / TileTileSize;
    public static int TileTileH = TileHeight / TileTileSize;

    public int[][] tileTile = new int[TileWidth][TileHeight];
    
    boolean oLeft = false, oUp = false, oRight = false, oDown = false;
    TileSample sample;
    
    public Tile(TileSample sample)
    {   
        this.sample = sample;
    }
    
    public void drawTile(Graphics g, int x, int y)
    {
        g.setColor(Color.darkGray);
        for(int i = 0; i < TileTileW; i++)
            for(int j = 0; j < TileTileH; j++)
            {
                if(sample.tile[i][j] == 1)
                    g.fillRect(x + j * TileTileSize, y + i * TileTileSize, TileTileSize, TileTileSize);
            }
    }
}