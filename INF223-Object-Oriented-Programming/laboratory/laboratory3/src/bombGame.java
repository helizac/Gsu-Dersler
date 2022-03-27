import java.awt.*;
import java.awt.event.*;
import java.security.Key;
import java.util.Random;

public class bombGame implements WindowListener{

    private Frame frame;
    private myCanvas _canvas;

    public bombGame(){
        frame = new Frame();
        _canvas = new myCanvas();

        frame.add(_canvas);
        frame.addWindowListener(this);
        frame.setSize(800, 600);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        bombGame application = new bombGame();
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

class myCanvas extends Canvas implements KeyListener {

    int x;
    int box_x = new Random().nextInt(750);
    int bomb_x;
    int bomb_y;
    double acceleration = 4;
    public boolean isBomb;
    public boolean canPress = true;
    public int score = 0;
    public myCanvas(){setBackground(Color.blue); addKeyListener(this);}

    public void paint(Graphics graphics){

        graphics.fillRect(0, this.getHeight()-50,this.getWidth(),50);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(box_x, this.getHeight()-80,30,30);

        graphics.setColor(Color.darkGray);

        graphics.fillRect(x, 50, 50, 25);

        if(isBomb){
            graphics.setColor(Color.red);
            graphics.fillOval(bomb_x, bomb_y,20, 10);
        }

        try{
            Thread.sleep(30);

            x += 8;
            if(x>=this.getWidth()){
                x = -50;
            }
            if(isBomb){
                canPress = false;
                bomb_x += 10;
                acceleration += .25;
                bomb_y = (int)(bomb_y + acceleration);
                if (bomb_y >= 800){
                    acceleration = 5;
                    canPress = true;
                }

                if( box_x - 10 <= bomb_x && bomb_x <= box_x + 30 && this.getHeight()-80 <= bomb_y && bomb_y <= this.getHeight()-50){
                    box_x = 5000;
                    score = 1;
                    graphics.drawString("Game Over", this.getWidth()/2, 100);
                }
            }
        }
        catch(Exception e){}

        if(score == 0){
            repaint();
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyPressed(KeyEvent e) {
        if(canPress){
            bomb_x = x;
            bomb_y = 70;
            if(e.getKeyCode() == KeyEvent.VK_DOWN){
                isBomb = true;
            }
        }
    }
}