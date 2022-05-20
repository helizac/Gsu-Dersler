package Laboratory10;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class example10 implements WindowListener, ActionListener{

    Frame frame;
    Panel panel;
    Label l1, l2;
    TextField t1, t2;
    TextArea l3;
    Button button;

    public example10(){

        frame = new Frame();
        panel = new Panel();
        l1 = new Label("Asker Sayısı: ");
        l2 = new Label("Kılıcın Verildiği Asker: ");
        l3 = new TextArea("");

        t1 = new TextField(10);
        t2 = new TextField(10);
        t1.setText("10");
        t2.setText("5");

        button = new Button("Savaş");
        button.addActionListener(this);


        panel.add(l1);
        panel.add(t1);
        panel.add(l2);
        panel.add(t2);
        panel.add(button);
        panel.add(l3);

        panel.setBackground(Color.lightGray);

        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setSize(540, 270);
        frame.setResizable(true);
        frame.setVisible(true);
    }


    public static void main(String[] args){
        example10 example = new example10();
    }
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button){

                String star = "";
                int number = Integer.parseInt(t1.getText());
                int turn = Integer.parseInt(t2.getText()) - 1;
                ArrayList<Integer> arr = new ArrayList<Integer>();

                for(int i = 1; i < number+1; i++){
                    arr.add(i);
                }

                int len = arr.size()-1;
                while(len > 1){
                    try{
                        star = star + String.valueOf(arr) + "\n";

                        if(turn != len){
                            arr.remove(turn+1);
                            len = arr.size()-1;
                            if(turn == len){
                                turn = 0;
                            }
                            else {
                                turn += 1;
                            }
                        }
                        else{
                            arr.remove(0);
                            len = arr.size()-1;
                            turn = 0;
                        }
                    }
                    catch (Exception exception){
                        System.out.println(exception);
                    }
                }

                star = star + String.valueOf(arr) + "\n";

                if(turn == 1){
                    arr.remove(0);
                    star = star + String.valueOf(arr) + "\n";
                }
                else{
                    arr.remove(1);
                    star = star + String.valueOf(arr) + "\n";
                }

                System.out.println(star);
                l3.setText(star);
            }

        }
        catch (Exception ex){
            return;
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
