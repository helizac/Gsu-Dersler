package Laboratory4;

import java.awt.*;
import java.awt.event.*;

public class example2 implements WindowListener, ActionListener{

    /* Example 2 Explanation: Create a simple app that changes the background to the color of the button when the buttons are pressed. */

    Frame frame;
    Panel panel;
    Button button;

    public example2(){
        frame = new Frame();
        panel = new Panel();

        button = new Button();
        button.setPreferredSize(new Dimension(100,100));
        button.setBackground(Color.red);
        button.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                panel.setBackground(Color.RED);
                button.setBackground(Color.WHITE);
            }
            public void mouseExited(MouseEvent e) {
                panel.setBackground(Color.YELLOW);
                button.setBackground(Color.RED);
            }
        });

        panel.add(button);
        panel.setBackground(Color.YELLOW);

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
    public void actionPerformed(ActionEvent e) {}
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