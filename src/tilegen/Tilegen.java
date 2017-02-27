package tilegen;

import javax.swing.JFrame;

public class Tilegen {

    
    static JFrame frame = new JFrame();

    public static void main(String[] args) {
        new Tilegen();
    }

    public Tilegen()
    {
        Screen screen = new Screen();
        frame.add(screen);
        frame.setUndecorated(true);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize((int)Screen.screenSize.getWidth(), (int)Screen.screenSize.getHeight());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
