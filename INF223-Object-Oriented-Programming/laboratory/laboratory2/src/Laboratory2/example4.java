package Laboratory2;

import java.awt.*;
import java.awt.event.*;

class myCanvas extends Canvas{
    int x = 10;
    int left = 1;
    public myCanvas(){
        setBackground(Color.lightGray);
    }

    public void paint(Graphics graphics){
        graphics.drawString("HELLO", x, this.getHeight()/2);
        x+=20*left;
        if(x >= this.getWidth() - 80){
            left = -1;
        }
        if(x <= 10){
            left = 1;
        }
        try{
            Thread.sleep(120);
        }
        catch(Exception e){}
        repaint();
    }
}

public class example4 implements WindowListener{

    /* Example 4 Explanation: Create an Application with a "HELLO" text that moves. If text reaches the corner of the screen, make it moves in to the other corner */

    private Frame frame;
    private myCanvas _canvas;

    public example4(){
        frame = new Frame();
        _canvas = new myCanvas();

        frame.add(_canvas);
        frame.addWindowListener(this);
        frame.setSize(480, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        example4 application = new example4();
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