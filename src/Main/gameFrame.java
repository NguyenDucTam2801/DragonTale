package Main;

import javax.swing.*;

public class gameFrame extends JFrame {
    gameFrame(){
        new gamePanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setVisible(true);
    }

}
