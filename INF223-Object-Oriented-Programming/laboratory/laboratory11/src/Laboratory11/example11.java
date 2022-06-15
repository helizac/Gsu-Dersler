package Laboratory11;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class example11 implements WindowListener, ActionListener{

    Frame frame;
    Panel panel;
    TextArea l3;
    Button button;

    ArrayList<String> myFiles;
    ArrayList<Long> index;

    public int[] sortArray(ArrayList<Long> arr){

        int[] myList = new int[arr.size()];
        Long[] myArr = arr.toArray(new Long[0]);

        for(int i = 0; i < myArr.length; i++){
            int right = 0;
            for(int j = 0; j < myArr.length; j++){
                if (myArr[i] > myArr[j]){
                    right++;
                }
            }
            myList[i] = right;
            right = 0;
        }

        return myList;
    }

    public example11(){

        frame = new Frame();
        panel = new Panel();
        l3 = new TextArea("");

        button = new Button("Dosyaları Sırala");
        button.addActionListener(this);

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
        example11 example = new example11();
    }
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource() == button) {

                myFiles = new ArrayList<String>();
                index = new ArrayList<Long>();

                File folder = new File("/Windows/");
                File[] listOfFiles = folder.listFiles();

                for (File file : listOfFiles) {
                    if (file.isFile() && (file.lastModified() != 0)) {
                        myFiles.add(file.getName());
                    }
                }

                for(int i = 0; i < myFiles.size(); i++){
                    File _file = new File("/Windows/" + myFiles.get(i));
                    index.add(_file.lastModified());
                }

                int[] order = sortArray(index);

                String[] FileNames = new String[order.length];
                Date[] FileTimeStamps = new Date[order.length];

                for(int i = 0; i < order.length; i++){
                    FileNames[order[i]] = myFiles.get(i);
                    FileTimeStamps[order[i]] = new Date(index.get(i));
                }

                String lstr = "";

                for(int i = 0; i < FileNames.length; i++){

                    if(FileNames[i] != null){
                        String space = ".";
                        String mySpace = space.repeat(70 - FileNames[i].length());

                        lstr += FileNames[i] + mySpace + String.valueOf(FileTimeStamps[i]) + "\n";
                    }

                }

                l3.setText(lstr);
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