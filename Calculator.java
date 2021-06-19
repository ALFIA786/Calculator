package com.alfiaali;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.function.BinaryOperator;

public class Calculator implements ActionListener {


    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[11];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton , negButton ;
    JPanel panel;

    Font myFont = new Font("Ink Free" , Font.BOLD,30);


    double num1=0, num2=0, result=0;
    String operator;


    Calculator(){ // constructor for a class

        //initialize the constructor
        frame = new JFrame("Calculator");        // Title given "CALCULATOR"....
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // allows to close the program..
        frame.setSize(420,550);        // set frame's width nd height..
        frame.setLayout(null);                     // set fram'es layout..

        textField = new JTextField();                 //constructor that creates a new TextField.
        textField.setBounds(50,25,300,50 );         // set the text width nd height..
        textField.setFont(myFont);                     // Using font.
        textField.setEditable(false);                  // stop editing in the calculator by user..

        addButton = new JButton("+");        // add all the buttons..--
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton("+");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("()");

                                                    // in function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont); // set the path in here..
            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i < 11; i++) {
           numberButtons[i] = new JButton(String.valueOf(i));
           numberButtons[i].addActionListener(this);
           numberButtons[i].setFont(myFont);        // set the path of number buttons..
           numberButtons[i].setFocusable(false);

        }

        negButton.setBounds(50,430,100,50);  // implement the hieght,width  of negbutton
        delButton.setBounds(50,430,100,50);   // implement the hieght,width  of delbutton
        clrButton.setBounds(205,430,100,50);   // implement the hieght,width  of clrbutton


        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.black);


        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);




        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();    // instance
    }

    @Override                  // implement the method
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 11; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        }
        if (e.getSource()==subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        }
        if (e.getSource()==mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        }
        if (e.getSource()==divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        }

        if (e.getSource()==equButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case"+":
                    result=num1+num2;
                    break;
                case"-":
                    result=num1-num2;
                    break;
                case"*":
                    result=num1*num2;
                    break;
                case"/":
                    result=num1+num2;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operator);
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource()==clrButton) {
            textField.setText("");
        }
        if (e.getSource()==delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
            if (e.getSource()==negButton) {
                double temp = Double.parseDouble(textField.getText());
                temp*=-1;
                textField.setText(String.valueOf(temp));

                }

            }
    }
}