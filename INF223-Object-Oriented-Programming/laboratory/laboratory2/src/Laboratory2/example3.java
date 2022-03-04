package Laboratory2;

import java.awt.*;
import java.awt.event.*;

public class example3 implements WindowListener, ActionListener{

    /* Example 3 Explanation: Create a simple application that converts Turkish Lira to Dollars and Dollars to Turkish Liras */

    Frame frame;
    Panel panel;
    Label labelTL, labelUSD, labelWarning;
    TextField textTL, textUSD;
    Button buttonUSDtoTL, buttonTLtoUSD;

    public example3(){
        frame = new Frame();
        panel = new Panel();
        labelTL = new Label("₺: ");
        labelUSD = new Label("$: ");
        labelWarning = new Label("Instant Rate: 1₺ = 14.24$");

        textTL = new TextField(44);
        textUSD = new TextField(44);

        buttonTLtoUSD = new Button("₺ -> $");
        buttonUSDtoTL = new Button("$ -> ₺");
        buttonUSDtoTL.addActionListener(this);
        buttonTLtoUSD.addActionListener(this);

        panel.add(labelTL);
        panel.add(textTL);
        panel.add(buttonTLtoUSD);

        panel.add(labelUSD);
        panel.add(textUSD);
        panel.add(buttonUSDtoTL);

        panel.add(labelWarning);
        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(480, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        example3 example = new example3();
    }
    public void actionPerformed(ActionEvent e) {
        try{
            labelWarning.setText("Instant Rate: 1₺ = 14.24$");
            if(e.getSource()==buttonUSDtoTL){
                if(Double.parseDouble(textUSD.getText())>0){
                    double currentAmount = (Double.parseDouble(textUSD.getText())) * (14.24);
                    textTL.setText(String.valueOf(currentAmount));
                }
                else{
                    labelWarning.setText("Please enter a valid value!");
                }
            }
            else if(e.getSource()==buttonTLtoUSD){
                if(Double.parseDouble(textTL.getText())>0){
                    double currentAmount = (Double.parseDouble(textTL.getText())) / (14.24);
                    textUSD.setText(String.valueOf(currentAmount));
                }
                else{
                    labelWarning.setText("Please enter a valid value!");
                }
            }

        }
        catch (Exception ex){
            labelWarning.setText("Please enter a valid value!");
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