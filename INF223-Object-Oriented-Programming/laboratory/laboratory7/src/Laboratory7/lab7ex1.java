package Laboratory7;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class lab7ex1 implements WindowListener{

    private final Frame frame;
    private final myCanvas71 _canvas;

    public lab7ex1(){
        frame = new Frame();
        _canvas = new myCanvas71();

        frame.add(_canvas);
        frame.addWindowListener(this);
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        lab7ex1 application = new lab7ex1();
    }

    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

}

class myCanvas71 extends Canvas implements KeyListener{

    int ball_x = 400;
    int ball_y = 300;
    double random = new Random().nextDouble()*(1.5)-1;
    boolean negativity = new Random().nextBoolean();
    double acceleration_x = random;
    double acceleration_y = 1 - random*random;
    int speed = 15;
    boolean stop = false;
    int score_1 = 0, score_2 = 0;
    int box1_y = 250, box2_y = 250;

    public myCanvas71(){
        if(negativity){
            acceleration_y *= -1;
        }
        setBackground(Color.LIGHT_GRAY);
        this.addKeyListener(this);
    }

    public void paint(Graphics graphics){

        graphics.setFont(new Font("Default", Font.PLAIN, 32));
        graphics.setColor(Color.GREEN.darker());
        graphics.fillRect(0,0,50,600);
        graphics.fillRect(740,0,50,600);

        graphics.setColor(Color.RED.darker());
        graphics.fillOval(ball_x, ball_y,20,20);

        graphics.setColor(Color.DARK_GRAY.brighter().brighter());
        graphics.fillRect(60,box1_y,20,100);
        graphics.fillRect(710,box2_y,20,100);

        graphics.setColor(Color.BLACK);
        graphics.drawString(score_1 + " : " + score_2, 375, 100);

        try{
            Thread.sleep(20);

            if(ball_x <= 0){
                score_1 += 1;
                stop = true;
            }
            if(ball_x <= 70 && ball_x >= 60 && ball_y > box1_y && ball_y < box1_y + 100){
                acceleration_x *= -1;
            }
            if(ball_x >= 740){
                score_2 +=1;
                stop = true;
            }
            if(ball_x <= 710 && ball_x >= 700 && ball_y > box2_y && ball_y < box2_y + 100){
                acceleration_x *= -1;
            }
            if(ball_y <= 5){
                acceleration_y *= -1;
            }
            if(ball_y >= 540){
                acceleration_y *= -1;
            }

            ball_x += acceleration_x*speed;
            ball_y += acceleration_y*speed;
        }
        catch(Exception e){}

        if(stop){
            graphics.setColor(Color.LIGHT_GRAY);
            graphics.fillRect(375,50,200,100);
            graphics.setColor(Color.BLACK);
            graphics.drawString(score_1 + " : " + score_2, 375, 100);
            graphics.drawString("PRESS R TO RESTART", 235, 150);
        }
        if(!stop){
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(box1_y >= 30)
            if(e.getKeyCode() == KeyEvent.VK_A) box1_y -= 20;
        if(box1_y <= 430)
            if(e.getKeyCode() == KeyEvent.VK_Z) box1_y += 20;
        if(box2_y >= 30)
            if(e.getKeyCode() == KeyEvent.VK_UP) box2_y -= 20;
        if(box2_y <= 430)
            if(e.getKeyCode() == KeyEvent.VK_DOWN) box2_y += 20;

        if(e.getKeyCode() == KeyEvent.VK_R){
            ball_x = 400;
            ball_y = 300;
            random = new Random().nextDouble()*(1.5)-1;
            negativity = new Random().nextBoolean();
            acceleration_x = random;
            acceleration_y = 1 - random*random;
            stop=false;
            repaint();
        }
    }
}