package OOP_Class;

import java.awt.*;
import java.awt.event.*;

class myCanvas extends Canvas{
    int x = 10;
    int left = 1;
    public myCanvas(){
        setBackground(Color.lightGray);
    }

    public void paint(Graphics graphics){
        graphics.drawString("Hello", x, this.getHeight()/2);
        x+=20*left;
        if(x >= 430){
            left = -1;
        }
        if(x <= 10){
            left = 1;
        }
        try{
            Thread.sleep(60);
        }
        catch(Exception e){}
        repaint();
    }
}

public class graphic101 implements WindowListener{

    private Frame frame;
    private myCanvas _canvas;

    public graphic101(){
        frame = new Frame();
        _canvas = new myCanvas();

        frame.add(_canvas);
        frame.addWindowListener(this);
        frame.setSize(480, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        graphic101 application = new graphic101();
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