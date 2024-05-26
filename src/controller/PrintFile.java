/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author PC
 */
public class PrintFile {
    public int Print(String fileName){
        int result = 1;
       
       try {
           Desktop desktop = null;
        if (Desktop.isDesktopSupported()) {
            desktop = Desktop.getDesktop();
        }         
        desktop.print(new File(fileName));
       } catch(Exception e){
           result=0;
       }
       return result;
    }
}
