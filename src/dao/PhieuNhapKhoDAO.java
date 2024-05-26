/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.PhieuNhapKho;
import database.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author PC
 */
public class PhieuNhapKhoDAO implements DAOInterface<PhieuNhapKho>{

    public static PhieuNhapKhoDAO getInstance(){
        return new PhieuNhapKhoDAO();
    }
    @Override
    public int insert(PhieuNhapKho t) {
        int result=0;
        String sql = "INSERT INTO phieunhapkho (MaPNK,NgayChungTu,TKNo,TKCo,TenNguoiGiao,TomTat,MaKho,MaKH,SoChungTuGoc,ThueGTGT,Cong,ChiuThue,HinhThuc) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPNK());
            pst.setDate(2, t.getNgayChungTu());
            pst.setString(3, t.getTkNo());
            pst.setString(4, t.getTkCo());
            pst.setString(5,t.getTenNguoiGiao());
            pst.setString(6, t.getTomTat());
            pst.setString(7, t.getMaKho());
            pst.setString(8, t.getMaKH());
            pst.setString(9, t.getKemtheoCTG());
            pst.setDouble(10, t.getThueGTGT());
            pst.setDouble(11, t.getCong());
            pst.setString(12,t.getChiuThue());
            pst.setString(13, t.getHinhThuc());
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
    public int update(PhieuNhapKho t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(PhieuNhapKho t) {
        int result=0;
        String sql = "DELETE FROM phieunhapkho WHERE MaPNK=?";
         try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaPNK());
            result=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<PhieuNhapKho> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PhieuNhapKho selectById(String maPNK) {
         String sql = "SELECT * FROM phieunhapkho WHERE MaPNK = ?";
         PhieuNhapKho p = new PhieuNhapKho();
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maPNK);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                String ma = rs.getString("MaPNK");
                Date ngayChungTu = rs.getDate("NgayChungTu");
                String tkNo = rs.getString("TKNo");
                String tkCo = rs.getString("TKCo");
                String tenNguoiGiao = rs.getString("TenNguoiGiao");
                String tomTat = rs.getString("TomTat");
                String maKho = rs.getString("MaKho");
                String maKH = rs.getString("MaKH");
                String chungTu = rs.getString("SoChungTuGoc");
                double thueGTGT = rs.getDouble("ThueGTGT");
                double cong = rs.getDouble("Cong");
                String chiuThue = rs.getString("ChiuThue");
                String hinhThuc = rs.getString("HinhThuc");
                p = new PhieuNhapKho(maPNK, ngayChungTu, tkNo, tkCo, tenNguoiGiao, tomTat, maKho, maKH, thueGTGT, cong, chungTu,chiuThue,hinhThuc);
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public int updateSum(double sum,String maPNK){
        
        int result=0;
        try {
            String sql = "UPDATE phieunhapkho SET Cong=? WHERE MaPNK=?";
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setDouble(1, sum);
            pst.setString(2, maPNK);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
        public static void main(String[] args) {
        PhieuNhapKho t = new PhieuNhapKho("LOL2");
        PhieuNhapKhoDAO.getInstance().delete(t);
    }
}

