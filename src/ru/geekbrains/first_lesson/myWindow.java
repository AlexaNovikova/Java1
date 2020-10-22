package ru.geekbrains.first_lesson;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myWindow extends JFrame{
    JLabel label1=new JLabel("Введите первое число");
    JLabel label2=new JLabel("Введите второе число");
    String[] operationType ={ "Сумма", "Разность", "Умножение", "Деление"};
    JComboBox comboBoxOperationType = new JComboBox (operationType);
    JLabel label3=new JLabel();
    public JButton buttonRez=new JButton("Результат");
    JTextField textField1 =new JTextField(10);
    JTextField textField2=new JTextField(10);

    myWindow(){
        super("Калькулятор");
        this.setSize(350,300);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,10,15));
        c.add(label1);
        c.add(textField1);
        c.add(label2);
        c.add(textField2);
        c.add(comboBoxOperationType);
        c.add(buttonRez);
        c.add(label3);
        Handler handler = new Handler();
        buttonRez.addActionListener(handler);

    }

    public class Handler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==buttonRez) {
                try {
                    int x = Integer.parseInt(textField1.getText());
                    int y = Integer.parseInt(textField2.getText());
                    double result;
                    switch ((String)comboBoxOperationType.getSelectedItem()) {
                        case "Сумма":
                            result = x + y;
                            break;
                        case "Разность":
                            result = x - y;
                            break;
                        case "Умножение":
                            result = x * y;
                            break;
                        case "Деление":
                            result = (double)x /(double) y;
                            break;
                        default:
                            System.out.println("Не выбран тип операции!");
                            result = 0;
                            break;

                    }
                    JOptionPane.showMessageDialog(null,result);

                    label3.setText(String.valueOf(result));

                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"Введите корректные данные!");
                    return;
                }

        }
    }
}}

