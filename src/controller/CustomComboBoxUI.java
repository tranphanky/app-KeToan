/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author PC
 */
public class CustomComboBoxUI extends BasicComboBoxUI{
   @Override
    protected ComboPopup createPopup() {
        BasicComboPopup popup = new BasicComboPopup(comboBox) {
            @Override
            protected void configurePopup() {
                super.configurePopup();
                // Set the preferred size of the popup
                JScrollPane scrollPane = (JScrollPane) getComponent(0);
                JList<?> list = (JList<?>) scrollPane.getViewport().getView();
                list.setFixedCellHeight(30);
                list.setPreferredSize(new Dimension(200, list.getPreferredSize().height));
                scrollPane.setPreferredSize(new Dimension(200, scrollPane.getPreferredSize().height));
            }
        };
        return popup;
    }
}
