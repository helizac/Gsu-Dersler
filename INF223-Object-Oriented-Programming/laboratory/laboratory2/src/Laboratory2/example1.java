package Laboratory2;

import java.awt.*;
import java.awt.event.*;

public class example1 implements WindowListener, ActionListener{

    /* Example 1 Explanation: Create a simple application that prints whether the input is a prime number or not. */

    Frame frame;
    Panel panel;
    TextField textField, txt;
    Button button;

    public example1(){
        frame = new Frame();
        panel = new Panel();
        textField = new TextField(30);
        txt = new TextField(39);
        button = new Button("Control");
        button.addActionListener(this);

        panel.add(textField);
        panel.add(button);
        panel.add(txt);
        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(480, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }


    public static boolean isNumber(int number){

        boolean flag = false;
        for(int i = 2; i <= number/2; ++i){
            if(number % i == 0){
                flag=true;
                break;
            }
        }
        if(!flag){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        example1 example = new example1();
    }
    public void actionPerformed(ActionEvent e) {
        // Takes action information from all buttons
        String textInput = textField.getText();
        try{
            if(Integer.parseInt(textInput) >= 0){
                if(isNumber(Integer.parseInt(textInput))){
                    txt.setText(textInput + " is a prime number!");
                }
                else{
                    txt.setText(textInput + " is not a prime number!");
                }
            }
            else{
                txt.setText(textInput + " is not a positive number. Please enter a valid number!");
            }
        }
        catch (Exception exception){
            txt.setText(textInput + " is not a number. Please enter a valid positive number!");
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