package Laboratory8;

import java.awt.*;
import java.awt.event.*;

public class calculator implements WindowListener, ActionListener{
    GridBagLayout a = new GridBagLayout();

    GridBagConstraints b = new GridBagConstraints();

    TextField t1;

    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17;

    int operationInt, operationCount;

    double firstNumber;

    Frame f = new Frame();

    Panel p = new Panel();

    public calculator()

    {
        p.setLayout(a);
        b.fill=GridBagConstraints.BOTH;
        b.insets=new Insets(3,3,3,3);

        b.gridx=0;
        b.gridy=0;
        b.gridwidth=4;
        b.gridheight=1;
        t1 = new TextField("");
        a.setConstraints(t1, b);
        p.add(t1);

        b.gridx=0;
        b.gridy=1;
        b.gridwidth=1;
        b.gridheight=1;
        b1 = new Button("C");
        a.setConstraints(b1,b);
        p.add(b1);

        b.gridx=1;
        b.gridy=1;
        b.gridwidth=1;
        b.gridheight=1;
        b2 = new Button("/");
        a.setConstraints(b2,b);
        p.add(b2);

        b.gridx=2;
        b.gridy=1;
        b.gridwidth=1;
        b.gridheight=1;
        b3 = new Button("*");
        a.setConstraints(b3,b);
        p.add(b3);

        b.gridx=3;
        b.gridy=1;
        b.gridwidth=1;
        b.gridheight=1;
        b4 = new Button("-");
        a.setConstraints(b4,b);
        p.add(b4);

        b.gridx=0;
        b.gridy=2;
        b.gridwidth=1;
        b.gridheight=1;
        b5 = new Button("7");
        a.setConstraints(b5,b);
        p.add(b5);

        b.gridx=1;
        b.gridy=2;
        b.gridwidth=1;
        b.gridheight=1;
        b6 = new Button("8");
        a.setConstraints(b6,b);
        p.add(b6);

        b.gridx=2;
        b.gridy=2;
        b.gridwidth=1;
        b.gridheight=1;
        b7 = new Button("9");
        a.setConstraints(b7,b);
        p.add(b7);

        b.gridx=3;
        b.gridy=2;
        b.gridwidth=1;
        b.gridheight=2;
        b8 = new Button("+");
        a.setConstraints(b8,b);
        p.add(b8);

        b.gridx=0;
        b.gridy=3;
        b.gridwidth=1;
        b.gridheight=1;
        b9 = new Button("4");
        a.setConstraints(b9,b);
        p.add(b9);

        b.gridx=1;
        b.gridy=3;
        b.gridwidth=1;
        b.gridheight=1;
        b10 = new Button("5");
        a.setConstraints(b10,b);
        p.add(b10);

        b.gridx=2;
        b.gridy=3;
        b.gridwidth=1;
        b.gridheight=1;
        b11 = new Button("6");
        a.setConstraints(b11,b);
        p.add(b11);

        b.gridx=0;
        b.gridy=4;
        b.gridwidth=1;
        b.gridheight=1;
        b12 = new Button("1");
        a.setConstraints(b12,b);
        p.add(b12);

        b.gridx=1;
        b.gridy=4;
        b.gridwidth=1;
        b.gridheight=1;
        b13 = new Button("2");
        a.setConstraints(b13,b);
        p.add(b13);

        b.gridx=2;
        b.gridy=4;
        b.gridwidth=1;
        b.gridheight=1;
        b14 = new Button("3");
        a.setConstraints(b14,b);
        p.add(b14);

        b.gridx=3;
        b.gridy=4;
        b.gridwidth=1;
        b.gridheight=2;
        b15 = new Button("=");
        a.setConstraints(b15,b);
        p.add(b15);

        b.gridx=0;
        b.gridy=5;
        b.gridwidth=2;
        b.gridheight=1;
        b16 = new Button("0");
        a.setConstraints(b16,b);
        p.add(b16);

        b.gridx=2;
        b.gridy=5;
        b.gridwidth=1;
        b.gridheight=1;
        b17 = new Button(".");
        a.setConstraints(b17,b);
        p.add(b17);

        Button[] buttons = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17};

        for(int i = 0; i < 17; i++){
            buttons[i].addActionListener(this);
        }

        p.setBackground(Color.lightGray);

        f.add(p);

        f.addWindowListener(this);

        f.pack();

        f.setSize(240,280);

        f.setResizable(false);

        f.setVisible(true);

    }

    public static void main(String args[])

    {

        calculator uygulama = new calculator();

    }

    public void actionPerformed(ActionEvent e) {
        try{
            String text = t1.getText();

            if(e.getSource() == b1){
                t1.setText("");
            }

            else if(e.getSource() == b2){
                operationCount++;
                operationInt = 4;
                firstNumber = Double.parseDouble(text);
                t1.setText("");
            }
            else if(e.getSource() == b3){
                operationCount++;
                operationInt = 3;
                firstNumber = Double.parseDouble(text);
                t1.setText("");
            }
            else if(e.getSource() == b4){
                operationCount++;
                if(t1.getText().length() == 0){
                    t1.setText("-");
                }
                else{
                    operationInt = 2;
                    firstNumber = Double.parseDouble(text);
                    t1.setText("");
                }
            }
            else if(e.getSource() == b8){
                operationCount++;
                operationInt = 1;
                firstNumber = Double.parseDouble(text);
                t1.setText("");
            }

            // Equal
            else if(e.getSource() == b15){
                if(operationCount >= 3){
                    t1.setText("Hatalı Giriş!");
                }
                else{
                    if(operationInt == 1){
                        t1.setText(String.valueOf(Double.parseDouble(text) + firstNumber));
                    }
                    else if(operationInt == 2){
                        t1.setText(String.valueOf(firstNumber - Double.parseDouble(text)));
                    }
                    else if(operationInt == 3){
                        t1.setText(String.valueOf(Double.parseDouble(text) * firstNumber));
                    }
                    else if(operationInt == 4){
                        if(Double.parseDouble(text) == 0){
                            t1.setText("Sıfıra bölünemez");
                        }
                        else{
                            t1.setText(String.valueOf(firstNumber / Double.parseDouble(text)));
                        }
                    }

                    try{
                        if((int) Double.parseDouble(t1.getText()) == Double.parseDouble(t1.getText())){
                            t1.setText(String.valueOf((int) Double.parseDouble(t1.getText())));
                        }
                    }
                    catch (Exception exception){
                        return;
                    }

                    text = t1.getText();
                }
            }

            // Point
            else if(e.getSource() == b17){
                if(t1.getText().length() - t1.getText().replaceAll(".", "").length() > 1){
                    return;
                }
                else{
                    text += b17.getLabel();
                    t1.setText(text);
                }
            }

            else {
                String myNum = String.valueOf(e.getSource().toString().charAt(e.getSource().toString().length()-2));
                text += myNum;
                t1.setText(text);
            }
        }
        catch (Exception exception){
            return;
        }

    }

    public void windowOpened(WindowEvent e) {}

    public void windowClosing(WindowEvent e)

    {

        System.exit(0);

    }

    public void windowClosed(WindowEvent e) {}

    public void windowIconified(WindowEvent e) {}

    public void windowDeiconified(WindowEvent e) {}

    public void windowActivated(WindowEvent e) {}

    public void windowDeactivated(WindowEvent e) {}

}
