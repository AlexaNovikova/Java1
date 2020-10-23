package ru.geekbrains.first_lesson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyWindow extends JFrame {
    JLabel label = new JLabel("Любой текст");
    JComboBox comboBox;
    JRadioButton rb15;
    JRadioButton rb20;
    JRadioButton rb25;
    JCheckBox cbItalic;
    JCheckBox cbBold;
    int size;
   int style;


    MyWindow (){
        super("Текст");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        size=15;
        label.setFont(new Font("Standart", Font.PLAIN,size));
        setSize(500,400);
        setLocationRelativeTo(null);
        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER, 40,30));
        String [] colors ={ "Черный", "Синий", "Красный"};
        comboBox=new JComboBox(colors);
        rb15=new JRadioButton("15");
        rb20=new JRadioButton("20");
        rb25=new JRadioButton("25");
        ButtonGroup group= new ButtonGroup();
        group.add(rb15);
        group.add(rb20);
        group.add(rb25);
        cbItalic = new JCheckBox("Курсив");
        cbBold = new JCheckBox("Жирный");
        c.add(label);
        c.add(comboBox);
        c.add(cbItalic);
        c.add(cbBold);
        c.add(rb15);
        c.add(rb20);
        c.add(rb25);
        setVisible(true);
        size=10;
        Listener listener= new Listener();

        comboBox.addItemListener(listener);
        cbBold.addItemListener(listener);
        cbItalic.addItemListener(listener);
        rb20.addItemListener(listener);
        rb15.addItemListener(listener);
        rb25.addItemListener(listener);
    }

    public class Listener implements MyInterface {

        @Override
        public void color(JComboBox comboBox) {
            if (comboBox.getSelectedIndex() == 0) {
            label.setForeground(Color.BLACK);
            }
            if (comboBox.getSelectedIndex()==1){
                label.setForeground(Color.BLUE);
            }
            if (comboBox.getSelectedIndex()==2){
                label.setForeground(Color.RED);
            }

        }
        @Override
        public void size(JRadioButton radioButton) {
        if (radioButton.getText()=="15"){
            size=15;
            label.setFont(new Font("Font15", style,size));
        }
        if (radioButton.getText()=="20"){

            size=20;
            label.setFont(new Font("Font20", style,size));
        }
        if ( radioButton.getText()=="25"){
            size=25;
            label.setFont(new Font("Font25", style,size));
        }

 }

        @Override
        public void style(JCheckBox checkBox1, JCheckBox checkBox2) {
            if (checkBox1.getText() == "Жирный") {
                if (checkBox1.isSelected() && checkBox2.isSelected() == false) {
                    style = Font.BOLD;
                }
                else style=0;
            }
            if (checkBox2.getText() == "Курсив") {
                if (checkBox1.isSelected() == false && checkBox2.isSelected()) {
                    style = Font.ITALIC;
                }

            }
            if (checkBox1.getText() == "Жирный" && checkBox2.getText() == "Курсив") {
                if (checkBox1.isSelected() && checkBox2.isSelected())
                    style = 3;
            }
            else style=0;
             label.setFont(new Font("font", style,size));
        }



        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getSource()==comboBox)
            {
                color(comboBox);
            }
            if (e.getSource()==cbBold)
            {
                style(cbBold,cbItalic);
            }
            if (e.getSource()==cbItalic)
            {
                style(cbBold,cbItalic);
            }
            if (e.getSource()==cbItalic&&e.getSource()==cbBold){
                style(cbBold,cbItalic);
            }
            if (e.getSource()==rb15)
            {
                size(rb15);
            }
            if (e.getSource()==rb20)
            {
                size(rb20);
            }
            if (e.getSource()==rb25)
            {
                size(rb25);
            }
        }
    }

    }


