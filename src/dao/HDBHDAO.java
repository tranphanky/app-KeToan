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
import model.HDBH;

/**
 *
 * @author PC
 */
public class HDBHDAO implements DAOInterface<HDBH>{
    
    public static HDBHDAO getInstance(){
        return new HDBHDAO();
    }
    @Override
    public int insert(HDBH t) {
        int result=0;
        String sql = "INSERT INTO hoadonbanhang (MaHDBH,NgayChungTu,TKNo,TKCo,NguoiMua,NoiDung,MaKho,MaNH,MaKH,CongTienHang,ThueGTGT,Sum) VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaHDBH());
            pst.setDate(2, t.getNgayChungTu());
            pst.setString(3, t.getTkNo());
            pst.setString(4, t.getTkCo());
            pst.setString(5,t.getNguoiMua());
            pst.setString(6, t.getNoiDung());
            pst.setString(7, t.getMaKho());
            pst.setString(8, t.getMaNH());
            pst.setString(9, t.getMaKH());
            pst.setInt(10, t.getCongTienHang());
            pst.setDouble(11, t.getThueGTGT());
            pst.setDouble(12, t.getSum());
            result = pst.executeUpdate();
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
    public int update(HDBH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(HDBH t) {
        int result=0;
        String sql = "DELETE FROM hoadonbanhang WHERE MaHDBH=?";
         try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaHDBH());
            result=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int updateSum(int congTienHang,double thueGTGT,double sum,String maHDBH){
        
        int result=0;
        try {
            String sql = "UPDATE hoadonbanhang SET CongTienHang=?,ThueGTGT=?,Sum=? WHERE MaHDBH=?";
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, congTienHang);
            pst.setDouble(2, thueGTGT);
            pst.setDouble(3, sum);
            pst.setString(4, maHDBH);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<HDBH> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HDBH selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
