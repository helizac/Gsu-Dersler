package GUI;
import GUI.Button.ButtonOperation;
import GUI.Button.CalculatorButton;
import GUI.MyFont.MyFonts;

import java.awt.*;
import java.awt.event.*;
import java.awt.Toolkit;

import java.util.stream.Stream;

public class Calculator implements WindowListener, ActionListener{

    Frame frame;
    Panel panel;

    Label standard, outputLayer;
    public String currentScreen;
    String buttonText, process;
    Double firstNumber;
    Integer operationInt;

    CalculatorButton[] column1, column2, column3, column4, column5, column6, calculatorButtons;

    public Calculator() {

        MyFonts myFonts = new MyFonts();

        // Creating main frame
        frame = new Frame();
        panel = new Panel();

        // Creating interior items
        standard = new Label("Standard");
        standard.setFont(myFonts.google_sans.deriveFont(28F));
        standard.setAlignment(Label.LEFT);
        standard.setPreferredSize(new Dimension(399, 40));
        outputLayer = new Label("0");
        outputLayer.setFont(myFonts.google_sans.deriveFont(40F));
        outputLayer.setAlignment(Label.RIGHT);
        outputLayer.setPreferredSize(new Dimension(399, 166));

        CalculatorButton[] digits = new CalculatorButton[10];
        CalculatorButton[] operations = new CalculatorButton[14];
        ButtonOperation[] operationList = GUI.Button.ButtonOperation.values();
        String[] operationSymbols = {"%", "CE", "C", "<~", "1/x", "x²", "√x", "÷", "×", "-", "+", "±", ".", "="};

        // Creating Buttons
        for(int i = 0; i<= 9; i++){digits[i] = new CalculatorButton(String.valueOf(i), Color.decode("#1b1b1b"), Color.WHITE, new Dimension(95, 64), ButtonOperation.Number);}
        for(int i = 0; i<=12; i++){operations[i] = (new CalculatorButton(operationSymbols[i], Color.BLACK, Color.decode("#f9f9f9"), new Dimension(95, 64), operationList[i]));}
        operations[operations.length-1] = (new CalculatorButton(operationSymbols[operationSymbols.length-1], Color.WHITE, Color.decode("#3f484d"), new Dimension(95, 64), operationList[operations.length-1]));

        // Editing Button Grid
        column1 = new CalculatorButton[]{operations[0],   operations[1],  operations[2],  operations[3]};
        column2 = new CalculatorButton[]{operations[4],   operations[5],  operations[6],  operations[7]};
        column3 = new CalculatorButton[]{digits[7],       digits[8],      digits[9],      operations[8]};
        column4 = new CalculatorButton[]{digits[4],       digits[5],      digits[6],      operations[9]};
        column5 = new CalculatorButton[]{digits[1],       digits[2],      digits[3],      operations[10]};
        column6 = new CalculatorButton[]{operations[11],  digits[0],      operations[12], operations[13]};

        calculatorButtons = Stream.of(column1, column2, column3, column4, column5, column6).flatMap(Stream::of).toArray(CalculatorButton[]::new);

        panel.add(standard);
        panel.add(outputLayer);
        for (CalculatorButton calculatorButton : calculatorButtons) {
            calculatorButton.addActionListener(this);
            panel.add(calculatorButton);
        }

        panel.setBackground(Color.decode("#f3f3f3"));
        frame.add(panel);
        frame.addWindowListener(this);
        frame.pack();
        frame.setTitle("Advanced Calculator");
        frame.setSize(420, 672);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("GUI/icon.png"));
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {}
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<24; i++) {
            if (e.getSource() == calculatorButtons[i]) {
                currentScreen = outputLayer.getText();

                if(currentScreen.length() >= 1){
                    if(currentScreen.charAt(0) == '0'){
                        currentScreen = currentScreen.substring(1);
                    }
                }

                buttonText = String.valueOf(calculatorButtons[i].getText());
                if(calculatorButtons[i].getOperation() == ButtonOperation.Number){
                    process = currentScreen + buttonText;
                    outputLayer.setText(process);
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Percent){
                    process = String.valueOf(Double.parseDouble(currentScreen)/100);
                    outputLayer.setText(process);
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.ClearEntry){
                    outputLayer.setText("0");
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Clear){
                    outputLayer.setText("0");
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Erase){
                    if(currentScreen.length()>1){
                        outputLayer.setText(currentScreen.substring(0, currentScreen.length()-1));
                    }
                    else{
                        outputLayer.setText("0");
                    }
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Reverse){
                    process = String.valueOf(1/Double.parseDouble(currentScreen));
                    outputLayer.setText(process);
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Square){
                    process = String.valueOf(Math.pow(Double.parseDouble(currentScreen), 2));
                    outputLayer.setText(process);
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Root){
                    process = String.valueOf(Math.sqrt(Double.parseDouble(currentScreen)));
                    outputLayer.setText(process);
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Divide){
                    firstNumber = Double.valueOf(currentScreen);
                    outputLayer.setText("0");
                    operationInt = 1;
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Multiply){
                    firstNumber = Double.valueOf(currentScreen);
                    outputLayer.setText("0");
                    operationInt = 2;
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Subtract){
                    firstNumber = Double.valueOf(currentScreen);
                    outputLayer.setText("0");
                    operationInt = 3;
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Add){
                    firstNumber = Double.valueOf(currentScreen);
                    outputLayer.setText("0");
                    operationInt = 4;
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Negative){
                    process = String.valueOf(Double.parseDouble(currentScreen)*(-1));
                    outputLayer.setText(process);
                }
                else if(calculatorButtons[i].getOperation() == ButtonOperation.Equal){
                    if(operationInt == 1){
                        process = String.valueOf(firstNumber / Double.parseDouble(currentScreen));
                        outputLayer.setText(process);
                    }
                    else if(operationInt == 2){
                        process = String.valueOf(firstNumber * Double.parseDouble(currentScreen));
                        outputLayer.setText(process);
                    }
                    else if(operationInt == 3){
                        process = String.valueOf(firstNumber - Double.parseDouble(currentScreen));
                        outputLayer.setText(process);
                    }
                    else if(operationInt == 4){
                        process = String.valueOf(firstNumber + Double.parseDouble(currentScreen));
                        outputLayer.setText(process);
                    }
                }

                if(Double.parseDouble(outputLayer.getText()) == (int)(Double.parseDouble(outputLayer.getText()))){
                    outputLayer.setText(String.valueOf((int)(Double.parseDouble(outputLayer.getText()))));
                }

                if(calculatorButtons[i].getOperation() == ButtonOperation.DecimalPoint){
                    if(!currentScreen.contains(".")){
                        if(currentScreen.length() < 1){
                            currentScreen = "0";
                        }
                        process = currentScreen + ".";
                        outputLayer.setText(process);
                    }
                }
            }
        }
    }
    public void windowOpened(WindowEvent e) {}
    public void windowClosing(WindowEvent e) {System.exit(0);}
    public void windowClosed(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowActivated(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
}