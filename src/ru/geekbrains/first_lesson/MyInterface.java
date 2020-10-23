package ru.geekbrains.first_lesson;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.EventListener;

public interface MyInterface extends ItemListener {

public void color (JComboBox comboBox);
public void size (JRadioButton radioButton);
public void style (JCheckBox checkBox1, JCheckBox checkBox2);
}
