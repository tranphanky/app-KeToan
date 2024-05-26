/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author PC
 */
public class IntegerCellEditor extends DefaultCellEditor {
    JTextField textField;

    public IntegerCellEditor(JTextField textField) {
        super(textField);
        this.textField = textField;
    }

    public boolean stopCellEditing() {
        boolean isNumber;
        String value = (String) super.getCellEditorValue();
        isNumber = value.matches("[0-9]+");
        if(isNumber) {
            return super.stopCellEditing();
        } else {
            textField.setBorder(BorderFactory.createLineBorder(Color.red));
            JOptionPane.showMessageDialog(null, "Bạn chỉ có thể nhập số!");
        }
        return isNumber;
    }
}
