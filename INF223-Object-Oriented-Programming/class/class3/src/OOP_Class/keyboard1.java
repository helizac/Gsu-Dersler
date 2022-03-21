package OOP_Class;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


class myCanvas2 extends Canvas implements KeyListener{

    int x = 400, y = 300;

    public myCanvas2(){
        setBackground(Color.lightGray);
        addKeyListener(this);
    }

    public void paint(Graphics graphics){
        Font times_new_roman = new Font("Times New Roman", Font.PLAIN, 40);
        graphics.setFont(times_new_roman);
        graphics.drawString("+", x, y);
    }


    public void keyTyped(KeyEvent e) {}  // alphanumeric keys
    public void keyPressed(KeyEvent e) { // all keys

        int key = e.getKeyCode();

        switch (key){
            case(KeyEvent.VK_UP): y = y-10; break;
            case(KeyEvent.VK_DOWN): y = y+10; break;
            case(KeyEvent.VK_LEFT): x = x-10; break;
            case(KeyEvent.VK_RIGHT): x = x+10; break;
        }
        repaint();

    }
    public void keyReleased(KeyEvent e) {}
}

public class keyboard1 implements WindowListener {

    private Frame frame;
    private myCanvas2 canvas2;

    public keyboard1(){
        frame = new Frame();
        canvas2 = new myCanvas2();

        frame.add(canvas2);
        frame.addWindowListener(this);
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        keyboard1 application = new keyboard1();
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
