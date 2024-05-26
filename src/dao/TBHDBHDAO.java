/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TBHDBH;

/**
 *
 * @author PC
 */
public class TBHDBHDAO implements DAOInterface<TBHDBH>{

    public static TBHDBHDAO getInstance(){
        return new TBHDBHDAO();
    }
    @Override
    public int insert(TBHDBH t) {
        String sql="INSERT INTO banghdbh (SoLuong,DonGia,SoTien,MaHH,TenHH,USD,MaHDBH) VALUE (?,?,?,?,?,?,?)";
        int result=0;
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1,t.getSoLuong());
            pst.setInt(2,t.getDonGia());
            pst.setInt(3, t.getSoTien());
            pst.setString(4, t.getMaHH());
            pst.setString(5, t.getTenHH());
            pst.setInt(6, t.getUsd());
            pst.setString(7, t.getMaHDBH());
            result=pst.executeUpdate();
        } catch (SQLException e) {
            if (e instanceof java.sql.SQLIntegrityConstraintViolationException &&
                e.getMessage().contains("Duplicate entry")) {
                result=2;
            } else {
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
            }
        }
        return result;
    }

    @Override
    public int update(TBHDBH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TBHDBH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TBHDBH> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TBHDBH selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
