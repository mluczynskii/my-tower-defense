package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JComponent implements Runnable {
    Thread loop;

    static final int fps = 60;
    static final double interval = 1e9 / fps;

    public static final int ogTileSize = 32;
    public static final int scale = 2;
    public static final int tileSize = ogTileSize * scale;

    public static final int colNum = 16;
    public static final int rowNum = 10;

    public static final int screenWidth = colNum * tileSize;
    public static final int screenHeight = rowNum * tileSize;

    public GamePanel () {
        setPreferredSize(new Dimension(screenWidth, screenHeight));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
    }

    // Game Loop
    @Override
    public void run () {
        double nextDrawTime = System.nanoTime() + interval; 
        while (loop != null) {
            update();
            repaint();
            try {
                double remainder = nextDrawTime - System.nanoTime();
                remainder = remainder/1e6;
                if (remainder < 0)
                    remainder = 0;
                Thread.sleep((long)remainder);
                nextDrawTime = nextDrawTime + interval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void startLoop () {
        loop = new Thread(this);
        loop.start();
    }

    public void update () {
        // TODO: Implement logic
    }

    @Override
    public void paintComponent (Graphics graphics) {
        // TODO: Implement logic
    }
    
}
