package main;

import javax.swing.*;

public class Window {
    public static void main (String[] args) {
        JFrame frame = new JFrame("my-tower-defense");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel gp = new GamePanel();
        frame.add(gp);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gp.startLoop();
    }
}