/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author PC
 */
public class OpenFileWord {
    public static int open(String maPNK) {
        int result=1;
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            result=0;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.OPEN)) {
            System.out.println("OPEN is not supported");
            result=0;
        }

        try {
            File file = new File("SaveFile\\PhieuNhapKho\\PNK_"+maPNK+".docx");
            desktop.open(file);
        } catch (IOException e) {
            System.out.println("Error opening file");
            e.printStackTrace();
            result=0;
        }
        return result;
    }
    public static int openPXK(String maPXK) {
        int result=1;
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            result=0;
        }
        
        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.OPEN)) {
            System.out.println("OPEN is not supported");
            result=0;
        }

        try {
            File file = new File("SaveFile\\PhieuXuatKho\\PXK_"+maPXK+".docx");
            desktop.open(file);
        } catch (IOException e) {
            System.out.println("Error opening file");
            e.printStackTrace();
            result=0;
        }
        return result;
    }
}
