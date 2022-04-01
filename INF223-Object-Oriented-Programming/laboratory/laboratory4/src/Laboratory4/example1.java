package Laboratory4;

import java.awt.*;
import java.awt.event.*;

class myCanvas1 extends Canvas implements MouseListener, MouseMotionListener{

    private Point point;

    public myCanvas1(){
        setBackground(Color.lightGray);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics graphics){
        graphics.drawString("Merhaba", point.x, point.y);
        graphics.drawString(point.x + " , " + point.y, point.x, point.y-10);
    }

    public void mouseMoved(MouseEvent e){
        point = e.getPoint();
        repaint();
    }


    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}}

public class example1 implements WindowListener {

    private Frame frame;
    private myCanvas1 canvas1;

    public example1(){
        frame = new Frame();
        canvas1 = new myCanvas1();

        frame.add(canvas1);
        frame.addWindowListener(this);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        example1 application = new example1();
    }

    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}