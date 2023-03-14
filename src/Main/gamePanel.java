package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class gamePanel extends JPanel implements Runnable, KeyListener {
    //dimension
    public static int WIDTH=700;
    public static int HEIGHT=700;
    public static int SCALE=25;

    //game thread
    private Thread thread;
    private boolean run;
    private int FPS=60;
    private long targetTime = 1000/60;

    //image
    private BufferedImage image;
    private Graphics2D g;

    gamePanel(){
        super();
        setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if(thread==null){
            thread=new Thread(this);
            addKeyListener(this);
            thread.start();
        }
    }

    public void init(){
        image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        g=(Graphics2D) g;
        run=true;
    }

    @Override
    public void run() {
        init();
        long start;
        long wait;
        long elapsed;

        while (run){
            start=System.nanoTime();
            update();
            draw();
            drawToScreen();

            elapsed=System.nanoTime()-start;
            wait=targetTime-elapsed/1000000;
            try{
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){

    }

    public void draw(){

    }

    public void drawToScreen(){
        Graphics g2=getGraphics();
        g2.drawImage(image,0,0,null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
