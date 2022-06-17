package GUI.Button;

import GUI.MyFont.MyFonts;

import java.awt.*;
import java.awt.event.*;
import java.util.UUID;

import static GUI.Button.StaticOperations.*;

public class CalculatorButton extends Button{

    private ButtonOperation operation;
    private String text;
    private final UUID uuid = UUID.randomUUID();

    public CalculatorButton(String buttonText, Color textColor, Color backgroundColor, Dimension size, ButtonOperation buttonOperation) {

        MyFonts myFonts = new MyFonts();

        this.setLabel(buttonText);
        this.setPreferredSize(size);
        this.setForeground(textColor);
        this.setBackground(backgroundColor);
        this.setFont(myFonts.times_new_roman);
        this.createImage(40,40);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {
                CalculatorButton source = (CalculatorButton) e.getSource();
                if(source.getUuid() == getUuid()){
                    setBackground(colorHighlight(backgroundColor, 0.65, 0.75));
                }
            }
            public void mouseReleased(MouseEvent e) {
                CalculatorButton source = (CalculatorButton) e.getSource();
                if(source.getUuid() == getUuid()){
                    setBackground(backgroundColor);
                }
            }
            public void mouseEntered(MouseEvent e) {
                CalculatorButton source = (CalculatorButton) e.getSource();
                if(source.getUuid() == getUuid()){
                    setBackground(colorHighlight(backgroundColor, 0.85, 0.95));
                }
            }
            public void mouseExited(MouseEvent e) {
                CalculatorButton source = (CalculatorButton) e.getSource();
                if(source.getUuid() == getUuid()){
                    setBackground(backgroundColor);
                }
            }
        });

        setText(buttonText);
        setOperation(buttonOperation);
    }

    private void setText(String Text) {this.text = Text;}
    public String getText() {return this.text;}

    public void setOperation(ButtonOperation operation) {this.operation = operation;}
    public ButtonOperation getOperation() {return this.operation;}

    public UUID getUuid() {return uuid;}
}