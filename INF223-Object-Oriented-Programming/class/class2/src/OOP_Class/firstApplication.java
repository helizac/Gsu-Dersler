package OOP_Class;

import java.awt.*;
import java.awt.event.*;

public class firstApplication implements WindowListener, ActionListener{

    Frame frame;
    Panel panel;
    TextField textField;
    Button button;



    public firstApplication(){
        frame = new Frame();
        panel = new Panel();
        textField = new TextField(30);
        button = new Button("OK");
        button.addActionListener(this);

        panel.add(textField);
        panel.add(button);
        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(480, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        firstApplication application = new firstApplication();
    }
    public void actionPerformed(ActionEvent e) {
        // Takes action information from all buttons
        String textInput = textField.getText();
        System.out.println(textInput);
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