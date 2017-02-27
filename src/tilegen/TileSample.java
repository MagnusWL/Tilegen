package tilegen;

public class TileSample{
    int[][] tile;
    boolean[] opens = new boolean[4];
    public TileSample(int[][] tile, boolean upO, boolean rightO, boolean downO, boolean leftO)
    {
        opens[0] = upO;
        opens[1] = rightO;
        opens[2] = downO;
        opens[3] = leftO;
        this.tile = tile;
    }
}