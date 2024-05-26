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
import model.NhapLieuKhac;

/**
 *
 * @author PC
 */
public class NhapLieuKhacDAO implements DAOInterface<NhapLieuKhac>{
    public static NhapLieuKhacDAO getInstance(){
        return new NhapLieuKhacDAO();
        
    }

    @Override
    public int insert(NhapLieuKhac t) {
        int result=0;
//        String sql = "INSERT INTO nhaplieukhac (MaPNK,NgayChungTu,TKNo,TKCo,TenNguoiGiao,TomTat,MaKho,MaKH,ThueGTGT,Cong) VALUES (?,?,?,?,?,?,?,?,?,?)";
//        try {
//            Connection conn = JDBCUtil.getConnection();
//            PreparedStatement pst = conn.prepareStatement(sql);
//            pst.setString(1, t.getMaPNK());
//            pst.setDate(2, t.getNgayChungTu());
//            pst.setString(3, t.getTkNo());
//            pst.setString(4, t.getTkCo());
//            pst.setString(5,t.getTenNguoiGiao());
//            pst.setString(6, t.getTomTat());
//            pst.setString(7, t.getMaKho());
//            pst.setString(8, t.getMaKH());
//            pst.setDouble(9, t.getThueGTGT());
//            pst.setDouble(10, t.getCong());
//            result = pst.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(PhieuNhapKhoDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return result;
    }

    @Override
    public int update(NhapLieuKhac t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(NhapLieuKhac t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<NhapLieuKhac> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NhapLieuKhac selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
