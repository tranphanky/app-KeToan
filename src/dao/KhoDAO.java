/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import java.sql.Connection;
import model.Kho;
import database.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class KhoDAO implements DAOInterface<Kho>{
    public static KhoDAO getInstance(){
        return new KhoDAO();
    }

    @Override
    public int insert(Kho t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Kho t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Kho t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Kho> selectAll() {
        ArrayList<Kho> listKho = new ArrayList<Kho>();
        String sql = "SELECT * FROM kho";
        
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                String maSoKho = rs.getString("MaKho");
                String tenKho = rs.getString("TenKho");
                String diaDiem = rs.getString("DiaDiem");
                
                Kho k = new Kho(maSoKho, tenKho, diaDiem);
                listKho.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listKho;
    }

    @Override
    public Kho selectById(String t) {
        String sql = "SELECT * FROM kho WHERE MaKho = ?";
        Kho k = new Kho();
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                String maKho = rs.getString("MaKho");
                String tenKho = rs.getString("TenKho");
                String diaDiem = rs.getString("DiaDiem");
                
                k = new Kho(maKho, tenKho, diaDiem);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return k;
    }
    
    public static void main(String[] args) {
        Kho k = KhoDAO.getInstance().selectById("KHO01");
        System.out.println(k);
    }
}
