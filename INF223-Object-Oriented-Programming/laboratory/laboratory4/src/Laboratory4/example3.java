package Laboratory4;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class example3 implements WindowListener{

    private Frame frame;
    private myCanvas _canvas;

    public example3(){
        frame = new Frame();
        _canvas = new myCanvas();

        frame.add(_canvas);
        frame.addWindowListener(this);
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        example3 application = new example3();
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

class myCanvas extends Canvas {

    int ball_x = new Random().nextInt(75)*10;
    int ball_y = new Random().nextInt(52)*10;
    double random = new Random().nextDouble()*2-1;
    boolean negativity = new Random().nextBoolean();
    double acceleration_x = random;
    double acceleration_y = 1 - random*random;
    int speed = 15;

    public myCanvas(){
        if(negativity){
            acceleration_y *= -1;
        }
        setBackground(Color.DARK_GRAY);
    }

    public void paint(Graphics graphics){

        graphics.setColor(Color.decode("#12ad7b"));
        graphics.fillRect(350,250,250,175);

        graphics.setColor(Color.RED);
        graphics.fillOval(ball_x, ball_y,20,20);

        try{
            Thread.sleep(30);

            if(ball_x <= 5){
                acceleration_x *= -1;
            }
            if(ball_x >= 765){
                acceleration_x *= -1;
            }
            if(ball_y <= 5){
                acceleration_y *= -1;
            }
            if(ball_y >= 540){
                acceleration_y *= -1;
            }

            if(ball_x >= 350 && ball_x <= 600 && ball_y >= 250 && ball_y <= 425){
                speed = 5;
            }
            else{
                speed = 15;
            }


            ball_x += acceleration_x*speed;
            ball_y += acceleration_y*speed;
        }
        catch(Exception e){}

        repaint();

    }
}