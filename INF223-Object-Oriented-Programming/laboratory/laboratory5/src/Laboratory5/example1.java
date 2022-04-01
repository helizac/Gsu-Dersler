package Laboratory5;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;

public class example1 implements WindowListener{

    /* Example 2 Explanation: Create a simple app that changes the background to the color of the button when the buttons are pressed. */

    Frame frame;
    myCanvas4 panel;

    public example1(){
        frame = new Frame();
        panel = new myCanvas4();

        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(1000, 800);
        frame.setResizable(true);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        example1 example = new example1();
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

class myCanvas4 extends Canvas implements MouseMotionListener {

    public myCanvas4(){setBackground(Color.lightGray); addMouseMotionListener(this);}

    public void paint(Graphics graphics){

        graphics.setColor(Color.BLACK);

        graphics.drawOval(350, 150,200,200);
        graphics.drawLine(450,350, 100, 600);
        graphics.drawLine(100, 600, 300, 600);
        graphics.drawLine(300, 600, 300, 680);
        graphics.drawLine(300, 680, 250, 800);
        graphics.drawLine(550, 250, 1000, 700);
        graphics.drawLine(100, 600, 100, 680);
        graphics.drawLine(100, 680, 300, 680);

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        int x = e.getPoint().x, y = e.getPoint().y;
        int rad_x = 450, rad_y = 250;
        if(
                (x>=350 && x<=550 && y>=150 && y<=350 && (((rad_x-x)*(rad_x-x) + (rad_y-y)*(rad_y-y)) <= 10000)) ||
                (x>=100 && x<=450 && y>=350 && y<=600 && ((float)(600-y)/(float)(x-100)) >= 0 && (float)(600-y)/(float)(x-100) <= 5/7f) ||
                (x>=450 && x<=1000 && y>=150 && y<=700 && ((float)(700-y)/(float)(1000-x)) >= 0 && (float)(700-y)/(float)(1000-x) <= 1) ||
                (x>=250 && x<=300 && y>=680 && y<=800 && ((float)(800-y)/(float)(x-250)) >= 0 && (float)(800-y)/(float)(x-250) <= 12/5f) ||
                (x>=300 && x <=1000 && y >= 680 && y <= 800)
        ){
            this.setBackground(Color.red);
        }
        else{
            this.setBackground(Color.lightGray);
        }

    }
}