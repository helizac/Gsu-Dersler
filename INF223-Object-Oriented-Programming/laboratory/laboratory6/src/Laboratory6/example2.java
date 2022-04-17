package Laboratory6;

import java.awt.*;
import java.awt.event.*;

public class example2 implements WindowListener, ActionListener{

    /* Example 3 Explanation: Create a simple application that converts Turkish Lira to Dollars and Dollars to Turkish Liras */

    Frame frame;
    Panel panel;
    Label labelTL, labelUSD, labelWarning;
    TextField textTL, textUSD;
    Button button2, buttonTLtoUSD;

    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    String roman = new String();

    int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    int romanToDecimal(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {

            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
            }
        }
        return res;
    }

    public example2(){

        frame = new Frame();
        panel = new Panel();
        labelTL = new Label("Sayı: ");
        labelUSD = new Label("Romen Sayı: ");
        labelWarning = new Label("");

        textTL = new TextField(44);
        textUSD = new TextField(44);

        buttonTLtoUSD = new Button("Roma Rakamına Çevir");
        buttonTLtoUSD.addActionListener(this);
        button2 = new Button("Normal Sayıya Çevir");
        button2.addActionListener(this);


        panel.add(labelTL);
        panel.add(textTL);
        panel.add(buttonTLtoUSD);


        panel.add(labelUSD);
        panel.add(textUSD);
        panel.add(button2);

        panel.add(labelWarning);
        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(650, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        example2 example = new example2();
    }
    public void actionPerformed(ActionEvent e) {
        try{
             if(e.getSource()==buttonTLtoUSD){
                 roman = "";
                if(3999>=Integer.parseInt(textTL.getText()) && 1 <= Integer.parseInt(textTL.getText())) {
                    int myInt = Integer.parseInt(textTL.getText());
                    for (int i = 0; i < values.length; i++) {
                        while ( myInt >= values[i]) {
                            myInt -= values[i];

                            roman += romanLiterals[i];
                        }
                    }
                    textUSD.setText(roman);
                }
                else{
                    textUSD.setText("Lütfen geçerli bir değer giriniz!");
                }
            }

             if(e.getSource() == button2){
                 textTL.setText(String.valueOf(romanToDecimal(String.valueOf(textUSD.getText()))));
             }

        }
        catch (Exception ex){

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