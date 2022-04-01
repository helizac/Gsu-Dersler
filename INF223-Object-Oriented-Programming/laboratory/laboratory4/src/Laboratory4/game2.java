package Laboratory4;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class game2 implements WindowListener{

    private Frame frame;
    private myCanvas2 _canvas;

    public game2(){
        frame = new Frame();
        _canvas = new myCanvas2();

        frame.add(_canvas);
        frame.addWindowListener(this);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        game2 application = new game2();
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

class myCanvas2 extends Canvas implements KeyListener {

    int angle = 90;
    int shooting_angle = 90;
    int x;
    int box_x = new Random().nextInt(750);
    int bomb_x = box_x + 35;
    int bomb_y = 550;
    int acc_up = 30;
    double acceleration = 4;
    public boolean isBomb;
    public boolean canPress = true;
    public int score = 0;
    public myCanvas2(){setBackground(Color.gray.brighter()); addKeyListener(this);}

    public void paint(Graphics graphics){

        graphics.setColor(Color.gray);
        graphics.fillRect(0, this.getHeight()-50,this.getWidth(),50);
        graphics.setColor(Color.gray.brighter().brighter());
        graphics.fillRect(box_x, this.getHeight()-90,70,40);

        graphics.setColor(Color.gray.darker());

        int additional_x = (int)((Math.cos(Math.toRadians(angle)))*35);
        int additional_y = (int)((Math.abs(Math.sin(Math.toRadians(angle))))*35);

        graphics.drawLine(box_x+34, this.getHeight()-91, box_x+34+additional_x, this.getHeight()-91-additional_y);
        graphics.drawLine(box_x+38, this.getHeight()-91, box_x+38+additional_x, this.getHeight()-91-additional_y);

        graphics.drawLine(box_x+34+additional_x, this.getHeight()-91-additional_y, box_x+38+additional_x, this.getHeight()-91-additional_y);

        graphics.setColor(Color.gray.darker());
        graphics.fillRect(x, 50, 100, 50);

        if(isBomb){
            canPress = false;
            graphics.setColor(Color.gray.darker().darker());
            graphics.fillOval(bomb_x, bomb_y,20, 10);

            bomb_x += 40/Math.tan(Math.toRadians(shooting_angle));
            acceleration += .25;
            bomb_y = (int)(bomb_y - acc_up + acceleration);

            if (bomb_y < -20){
                acceleration = 4;
                canPress = true;
            }

            if( x <= bomb_x && bomb_x <= x + 100 && 50 <= bomb_y && bomb_y <= 90){
                x = 5000;
                score = 1;
                graphics.setFont(new Font("Monospaced", Font.PLAIN, 32));
                graphics.drawString("Game Over", 400, 150);
            }

        }

        x += 8;
        if(x>=this.getWidth()){
            x = -100;
        }

        try{
            Thread.sleep(60);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        if(score == 0){
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if(canPress){
            if(e.getKeyCode() == KeyEvent.VK_UP){
                shooting_angle = angle;
                bomb_x = box_x+35+(int)((Math.cos(Math.toRadians(angle)))*35);
                bomb_y = this.getHeight()-110-(int)((Math.abs(Math.sin(Math.toRadians(angle))))*35);
                isBomb = true;
            }
        }
        if(angle > 46){
            if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                angle -= 2;
            }
        }
        if(angle < 134){
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                angle += 2;
            }
        }
    }
}