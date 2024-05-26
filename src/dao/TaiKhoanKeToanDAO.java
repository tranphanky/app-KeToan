/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import model.TaiKhoanKeToan;
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
public class TaiKhoanKeToanDAO implements DAOInterface<TaiKhoanKeToan>{
    
    public static TaiKhoanKeToanDAO getInstance() {
        return new TaiKhoanKeToanDAO();
    }

   
    
    @Override
    public ArrayList<TaiKhoanKeToan> selectAll() {
        ArrayList<TaiKhoanKeToan> result = new ArrayList<TaiKhoanKeToan>();
        
        String sql = "SELECT thuoctinhloaitk.TenThuocTinh,thuoctinhloaitk.SoHieuC1, tentk.TenTK,tentk.SoHieuC2 FROM thuoctinhloaitk LEFT JOIN tentk ON thuoctinhloaitk.IDTTTK = tentk.IDTTTK;";
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                String TKC1_Ten = rs.getString("TenThuocTinh");
                int TKC1_SoHieu = rs.getInt("SoHieuC1");
                String TKC2_Ten = rs.getString("TenTK");
                int TKC2_SoHieu = rs.getInt("SoHieuC2");
                TaiKhoanKeToan tk = new TaiKhoanKeToan(TKC1_Ten, TKC1_SoHieu, TKC2_Ten, TKC2_SoHieu);
                result.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanKeToanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }

    @Override
    public TaiKhoanKeToan selectById(String t) {
        TaiKhoanKeToan tk  = new TaiKhoanKeToan();
        return tk;
    }

    @Override
    public int insert(TaiKhoanKeToan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(TaiKhoanKeToan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TaiKhoanKeToan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<String> getName(){
        ArrayList<String> listName = new ArrayList<String>();
        ArrayList<TaiKhoanKeToan> listTK = TaiKhoanKeToanDAO.getInstance().selectAll();
        for (TaiKhoanKeToan tk : listTK) {
            if(tk.getTaiKhoanC2_Ten()==null){
                String name = tk.getTaiKhoanC1_Ten();
                String soHieu = tk.getTaiKhoanC1_SoHieu()+"";
                listName.add(soHieu+": "+name);
                 
            } else {
                String name = tk.getTaiKhoanC1_Ten() + ":" + tk.getTaiKhoanC2_Ten();
                String soHieu = tk.getTaiKhoanC1_SoHieu() + tk.getTaiKhoanC2_SoHieu() + "";
                listName.add(soHieu+": "+name);
            }
           
        }
        return listName;
    }
    public static void main(String[] args) {
        ArrayList<String> listName = TaiKhoanKeToanDAO.getInstance().getName();
        System.out.println(listName);
        
    }
    
    
}
