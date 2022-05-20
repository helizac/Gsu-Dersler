package Laboratory9;

import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class app implements WindowListener, ActionListener{

    GridBagLayout a = new GridBagLayout();

    GridBagConstraints b = new GridBagConstraints();

    Button encryptButton, decryptButton;

    TextArea plain, ciphered;

    Frame f = new Frame();

    Panel p = new Panel();

    public app()

    {

        p.setLayout(a);
        b.fill=GridBagConstraints.HORIZONTAL;
        b.insets=new Insets(5, 8, 5, 8);

        b.gridx=0;
        b.gridy=0;
        b.gridwidth = 3;
        b.gridheight = 4;
        plain = new TextArea(15, 20);
        a.setConstraints(plain, b);
        p.add(plain);

        b.gridx=3;
        b.gridy=1;
        b.gridwidth = 1;
        b.gridheight = 1;
        b.weighty = 2;
        encryptButton = new Button("Şifrele >>>");
        a.setConstraints(encryptButton, b);
        p.add(encryptButton);

        b.gridx=3;
        b.gridy=3;
        b.gridwidth = 1;
        b.gridheight = 1;
        b.weighty = 2;
        decryptButton = new Button("<<< Şifreyi Çöz");
        a.setConstraints(decryptButton, b);
        p.add(decryptButton);

        b.gridx=5;
        b.gridy=0;
        b.gridwidth = 3;
        b.gridheight = 4;
        ciphered = new TextArea(15,20);
        a.setConstraints(ciphered, b);
        p.add(ciphered);

        plain.setText("Bir metin giriniz.");
        ciphered.setText("Bir metin giriniz.");

        encryptButton.addActionListener(this);
        decryptButton.addActionListener(this);

        p.setBackground(Color.lightGray);

        f.add(p);

        f.addWindowListener(this);

        f.pack();

        f.setSize(600,400);

        f.setResizable(true);

        f.setVisible(true);

    }

    public static void main(String args[]) {app uygulama = new app();}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == encryptButton){
            ciphered.setText(encrypt(plain.getText()));
        }
        if(e.getSource() == decryptButton){
            plain.setText(decrypt(ciphered.getText()));
        }

    }

    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {System.exit(0);}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    public static String encrypt(String s){

        String encrypted_Text = new String("");
        s = editText(s);
        int len = s.length();
        int count = 0;
        int matrixEdge = ((int) Math.sqrt(len)) + 1;

        char matrix[][] = new char[matrixEdge][matrixEdge];

        for(int i = 0; i < matrixEdge; i++){
            for(int j = 0; j < matrixEdge; j++){
                if(count < len){
                    matrix[j][i] = s.charAt(count);
                    count++;
                }
            }
        }

        int count2 = 0;

        for(int i = 0; i < matrixEdge; i++) {
            for(int j = 0; j < matrixEdge; j++) {
                if(count2 <= len){
                    if((int)matrix[i][j] != 0){
                        encrypted_Text = encrypted_Text + (matrix[i][j]);
                        count2++;
                    }
                }
            }
        }

        return encrypted_Text;
    }

    public static String decrypt(String s){
        String decrypted_Text = new String("");
        int len = s.length();
        int count = 0;
        int matrixEdge = ((int) Math.sqrt(len)) + 1;

        char matrix[][] = new char[matrixEdge][matrixEdge];

        for(int i = 0; i < matrixEdge; i++){
            int row = len / matrixEdge;
            if(i < (len - (row * matrixEdge))) {
                for(int j = 0; j < row+1; j++) {
                    matrix[i][j] = s.charAt(count);
                    count++;
                }
            }
            else {
                for (int j = 0; j < row; j++) {
                    matrix[i][j] = s.charAt(count);
                    count++;
                }
            }
        }

        int count2 = 0;

        for(int i = 0; i < matrixEdge; i++) {
            for(int j = 0; j < matrixEdge; j++) {
                if(count2 <= len){
                    if(Character.isLetter(matrix[j][i])){
                        decrypted_Text = decrypted_Text + (matrix[j][i]);
                        count2++;
                    }
                }
            }
        }

        return decrypted_Text;
    }
    public static String editText(String s){
        int len = s.length();
        String alphaString = "";

        for( int i =0; i < len; i++){
            if (Character.isLetter(s.charAt(i))) {
                alphaString=alphaString+s.charAt(i);
            }
        }
        alphaString = alphaString.toLowerCase(Locale.ROOT);

        return alphaString;
    }

}
