package tilegen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Screen extends JPanel implements KeyListener {

    static Dimension screenSize = new Dimension(1280, 768);
    public int tileW = (int) (screenSize.getWidth() / Tile.TileWidth);
    public int tileH = (int) (screenSize.getHeight() / Tile.TileHeight);
    public Tile[][] tiles = new Tile[tileW][tileH];
    public ArrayList<TileSample> samples = new ArrayList<>();

    public Screen() {
        setFocusable(true);		
        this.addKeyListener(this);
        
        createSamples();
        createTiles();
    }
    
    public void createTiles()
    {        
        tiles = new Tile[tileW][tileH];
        for (int i = 0; i < tileW; i++) {
            for (int j = 0; j < tileH; j++) {
                boolean sUp = false;
                boolean sDown = false;
                boolean sLeft = false;
                boolean sRight = false;

                if (j > 0) {
                    if (tiles[i][j - 1].sample.opens[2]) {
                        sUp = true;
                    }
                }

                if (i > 0) {
                    if (tiles[i - 1][j].sample.opens[1]) {
                        sLeft = true;
                    }
                }

                ArrayList<TileSample> posTiles = new ArrayList<>();

                for (int k = 0; k < samples.size(); k++) {
                    if (samples.get(k).opens[0] == sUp && samples.get(k).opens[3] == sLeft) {
                        if (!(j == tileH - 1 && samples.get(k).opens[2])
                                && !(i == tileW - 1 && samples.get(k).opens[1])) {
                            posTiles.add(samples.get(k));
                        }
                    }
                }

                tiles[i][j] = new Tile(posTiles.get((int) (Math.random() * posTiles.size())));
            }
        }
    }

    public void createSamples() {
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 0, 1}

        }, true, true, true, true));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 0, 1}
        }, false, true, true, true));
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {1, 0, 0, 1}
        }, true, false, true, true));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {1, 0, 0, 1}
        }, false, false, true, true));
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 1, 1, 1}
        }, true, true, false, true));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 1, 1, 1}
        }, false, true, false, true));
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {1, 1, 1, 1}
        }, true, false, false, true));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {1, 1, 1, 1}
        }, false, false, false, true));
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 1}
        }, true, true, true, false));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 0, 0, 1}
        }, false, true, true, false));
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1}
        }, true, false, true, false));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1}
        }, false, false, true, false));
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 1, 1, 1}
        }, true, true, false, false));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 1, 1, 1}
        }, false, true, false, false));
        samples.add(new TileSample(new int[][]{
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1}
        }, true, false, false, false));
        samples.add(new TileSample(new int[][]{
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        }, false, false, false, false));
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, screenSize.width, screenSize.height);

        for (int i = 0; i < tileW; i++) {
            for (int j = 0; j < tileH; j++) {
                tiles[i][j].drawTile(g, i * Tile.TileWidth, j * Tile.TileHeight);
                g.setColor(Color.black);
                //  g.drawRect(i * Tile.TileWidth, j * Tile.TileHeight, Tile.TileWidth, Tile.TileHeight);
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        createTiles();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
