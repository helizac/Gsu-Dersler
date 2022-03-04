package Laboratory2;

import java.awt.*;
import java.awt.event.*;

public class example2 implements WindowListener, ActionListener{

    /* Example 2 Explanation: Create a simple app that changes the background to the color of the button when the buttons are pressed. */

    Frame frame;
    Panel panel;
    Button buttonRed, buttonYellow, buttonWhite;

    public example2(){
        frame = new Frame();
        panel = new Panel();

        buttonRed = new Button("RED");
        buttonRed.setBackground(Color.red);
        buttonYellow = new Button("YELLOW");
        buttonYellow.setBackground(Color.yellow);
        buttonWhite = new Button("WHITE");
        buttonWhite.setBackground(Color.white);
        buttonRed.addActionListener(this);
        buttonYellow.addActionListener(this);
        buttonWhite.addActionListener(this);

        panel.add(buttonRed);
        panel.add(buttonYellow);
        panel.add(buttonWhite);
        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(480, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        example2 example = new example2();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonRed){
            panel.setBackground(Color.red);
        }
        else if(e.getSource()==buttonYellow){
            panel.setBackground(Color.yellow);
        }
        else if(e.getSource()==buttonWhite){
            panel.setBackground(Color.WHITE);
        }
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