package Laboratory12;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
 
public class example12 implements WindowListener, ActionListener{

    public static String[] alphabet = new String[]{"a", "b", "c", "ç", "d", "e", "f", "g", "ğ", "h", "ı", "i", "j", "k", "l", "m", "n", "o", "ö", "p", "r", "s", "ş", "t", "u", "ü", "v", "y", "z"};

    public Integer[][] cipher_matrix = new Integer[29][29];

    public Integer[] cipher_flattened = new Integer[841];

    GridBagLayout a = new GridBagLayout();

    GridBagConstraints b = new GridBagConstraints();

    Button encryptButton, decryptButton;

    TextArea plain, ciphered;

    Frame f = new Frame();

    Panel p = new Panel();

    public example12()

    {
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i=100; i<1000; i++){
            numbers.add(i);
        }

        for(int i=0; i < 841; i++){
            Random rand = new Random();
            int randomNumber = numbers.get(rand.nextInt(numbers.size()));
            cipher_matrix[i/29][i-(i/29)*29] = randomNumber;
            cipher_flattened[i] = randomNumber;
            numbers.remove(Integer.valueOf(randomNumber));
        }



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

    public static void main(String args[]) {example12 uygulama = new example12();}

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == encryptButton){
            ciphered.setText(encrypt(plain.getText(), cipher_matrix));
        }
        if(e.getSource() == decryptButton){
            plain.setText(decrypt(ciphered.getText(), cipher_flattened));
        }

    }

    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {System.exit(0);}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}

    public static String encrypt(String s, Integer[][] cipher_matrix){

        String encrypted_Text = new String("");
        s = editText(s);

        if(s=="")
            return "Lütfen geçerli bir değer\ngiriniz";

        for(int i = 0; i<s.length()/2;i++){
            encrypted_Text += cipher_matrix[Arrays.asList(alphabet).indexOf(String.valueOf(s.charAt(i*2)))][Arrays.asList(alphabet).indexOf(String.valueOf(s.charAt(i*2+1)))];
        }

        if(s.length()%2 != 0){
            encrypted_Text += cipher_matrix[Arrays.asList(alphabet).indexOf(String.valueOf(s.charAt(s.length()-1)))][Arrays.asList(alphabet).indexOf(String.valueOf(s.charAt(s.length()-1)))];
        }

        return encrypted_Text;
    }

    public static String decrypt(String s, Integer[] cipher_flattened){
        String decrypted_Text = new String("");

        for(int i = 0; i<s.length()/3;i++){

            String number3 = String.valueOf(s.charAt(i*3)) + String.valueOf(s.charAt(i * 3 + 1)) + String.valueOf(s.charAt(i * 3 + 2));

            int numIndex = Arrays.asList(cipher_flattened).indexOf(Integer.valueOf(number3));

            decrypted_Text += alphabet[numIndex/29];
            decrypted_Text += alphabet[numIndex % 29];
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
 
// Soft wrap
