package Laboratory6;

import java.awt.*;
import java.awt.event.*;

public class example1 implements WindowListener, ActionListener{

    Frame frame;
    Panel panel;
    Button buttonRed;
    TextField t1, t2;
    Label l1;

    int ranNum;

    public example1(){

        ranNum = (int) (Math.random()*4499)+4500;
        String n = String.valueOf(ranNum);
        while(n.charAt(0) == n.charAt(1) || n.charAt(0) == n.charAt(2) || n.charAt(0) == n.charAt(3) || n.charAt(1) == n.charAt(2) || n.charAt(1) == n.charAt(3) || n.charAt(2) == n.charAt(3)){
            ranNum = (int) (Math.random()*4499)+4500;
            n = String.valueOf(ranNum);
        }

        System.out.println(ranNum);

        frame = new Frame();
        panel = new Panel();

        l1 = new Label("");
        buttonRed = new Button("OK");
        buttonRed.setBackground(Color.red);
        buttonRed.addActionListener(this);
        t1 = new TextField(40);
        t2 = new TextField(55);


        panel.add(t1);
        panel.add(buttonRed);
        panel.add(t2);
        panel.add(l1);
        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(480, 360);
        frame.setResizable(true);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        example1 example = new example1();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonRed){
            String num = t1.getText();

            int count = 0;

            for (int i = 0; i < num.length()-1; i++) {
                for(int j=i+1; j < num.length()-1; j++){
                    if (num.charAt(i) == num.charAt(j)) {
                        count++;
                    }
                }
            }

            if(num.length() != 4){
                t2.setText("Lütfen 4 basamaklı bir sayı giriniz!");
            }
            else if(count != 0){
                t2.setText("Tekrarlayan sayı var, lütfen başka bir sayı giriniz");
            }
            else{
                String ranString = String.valueOf(ranNum);
                int correct = 0, wrong = 0;
                for(int i = 0; i < 4; i++){
                    if(num.charAt(i) == ranString.charAt(i)){
                        correct += 1;
                    }
                    else if(ranString.indexOf(num.charAt(i))!=-1){
                        wrong -= 1;
                    }

                    t2.setText(correct + " " + wrong);

                    if(correct == 0){
                        t2.setText(wrong + " ");
                    }
                    if(wrong == 0){
                        t2.setText(correct + " ");
                    }

                    if(wrong == 0 && correct == 0){
                        t2.setText("0");
                    }
                }

                if(correct == 4){
                    l1.setText("Sayıyı buldunuz!");
                }
                else{
                    l1.setText("");
                }
            }
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