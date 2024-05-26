/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.JDBCUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.PhieuXuatKho;

/**
 *
 * @author PC
 */
public class PhieuXuatKhoDAO implements DAOInterface<PhieuXuatKho>{

    public static PhieuXuatKhoDAO getInstance(){
        return new PhieuXuatKhoDAO();
    }
    @Override
    public int insert(PhieuXuatKho t) {
        int result=0;
        String sql = "INSERT INTO phieuxuatkho (MaPXK,NgayChungTu,TKNo,TKCo,TenNguoiNhan,TomTat,MaKho,MaKH,SoChungTuGoc,Cong) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPXK());
            pst.setDate(2, t.getNgayChungTu());
            pst.setString(3, t.getTkNo());
            pst.setString(4, t.getTkCo());
            pst.setString(5,t.getTenNguoiNhan());
            pst.setString(6, t.getTomTat());
            pst.setString(7, t.getMaSoKho());
            pst.setString(8, t.getMaKH());
            pst.setString(9, t.getKemtheoCTG());
            pst.setDouble(10, t.getCong());
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
    public int update(PhieuXuatKho t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int updateSum(double sum,String maPXK){
        
        int result=0;
        try {
            String sql = "UPDATE phieuxuatkho SET Cong=? WHERE MaPXK=?";
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDouble(1, sum);
            pst.setString(2, maPXK);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(PhieuXuatKho t) {
        int result=0;
        String sql = "DELETE FROM phieuxuatkho WHERE MaPXK=?";
         try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPXK());
            result=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<PhieuXuatKho> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PhieuXuatKho selectById(String maPXK) {
        String sql = "SELECT * FROM phieuxuatkho WHERE MaPXK = ?";
        PhieuXuatKho p = new PhieuXuatKho();
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maPXK);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                String ma = rs.getString("MaPXK");
                Date ngayChungTu = rs.getDate("NgayChungTu");
                String tkNo = rs.getString("TKNo");
                String tkCo = rs.getString("TKCo");
                String tenNguoiNhan = rs.getString("TenNguoiNhan");
                String tomTat = rs.getString("TomTat");
                String maKho = rs.getString("MaKho");
                String maKH = rs.getString("MaKH");
                String chungTu = rs.getString("SoChungTuGoc");            
                double cong = rs.getDouble("Cong");
                p = new PhieuXuatKho(ma, ngayChungTu, tkNo, tkCo, tenNguoiNhan, tomTat, maKho, maKH, cong, chungTu);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
}
