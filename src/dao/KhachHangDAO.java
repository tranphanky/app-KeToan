/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;

/**
 *
 * @author PC
 */
public class KhachHangDAO  implements DAOInterface<KhachHang>{

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }
    
    
    @Override
    public int insert(KhachHang t) {
        int result=1;
        try {
            String sql = "INSERT INTO khachhang (MaKH,TenKH,DiaChi,MaSoThue) VALUE (?,?,?,?)";
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaKH());
            pst.setString(2, t.getTenKH());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getMaSoThue());
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
    public int update(KhachHang t) {
        int result=1;
        try {
            String sql = "UPDATE khachhang SET MaKH=?,TenKH=?,DiaChi=?,MaSoThue=? WHERE MaKH=?";
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaKH());
            pst.setString(2, t.getTenKH());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getMaSoThue());
            pst.setString(5, t.getMaKH());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            result=0;
        }
        return result;
    }
    
    public int updateKH(KhachHang t,String maKH) {
        int result=1;
        try {
            String sql = "UPDATE khachhang SET MaKH=?,TenKH=?,DiaChi=?,MaSoThue=? WHERE MaKH=?";
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaKH());
            pst.setString(2, t.getTenKH());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getMaSoThue());
            pst.setString(5, maKH);
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            result=0;
        }
        return result;
    }

    @Override
    public int delete(KhachHang t) {
        int result=1;
        try {
            String sql = "DELETE FROM khachhang WHERE MaKH=? AND TenKH=? AND DiaChi=? AND MaSoThue=?";
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaKH());
            pst.setString(2, t.getTenKH());
            pst.setString(3, t.getDiaChi());
            pst.setString(4, t.getMaSoThue());
            result = pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
            result=0;
        }
        return result;
    }

    @Override
    public ArrayList<KhachHang> selectAll() {
       ArrayList<KhachHang> result = new ArrayList<KhachHang>();
        
        String sql = "SELECT * FROM khachhang";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                String maKH = rs.getString("MaKH");
                String tenKH = rs.getString("TenKH");
                String diaChi = rs.getString("DiaChi");
                String maSoThue = rs.getString("MaSoThue");
                KhachHang kh = new KhachHang(maKH, tenKH, diaChi, maSoThue);
                result.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanKeToanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public KhachHang selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static void main(String[] args) {
      
        
    }
}
