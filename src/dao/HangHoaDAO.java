/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.HangHoa;
import database.JDBCUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class HangHoaDAO implements DAOInterface<HangHoa>{

    public static HangHoaDAO getInstance(){
        return new HangHoaDAO();
    }
    @Override
    public int insert(HangHoa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(HangHoa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(HangHoa t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<HangHoa> selectAll() {
        ArrayList<HangHoa> listHH = new ArrayList<HangHoa>();
        String sql = "SELECT * FROM hanghoa";
        
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                String maHH = rs.getString("MaHH");
                String tenHH = rs.getString("TenHH");
                String dvt = rs.getString("DVT");
                
                HangHoa hh = new HangHoa(maHH, tenHH, dvt);
                listHH.add(hh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHH;
    }

    @Override
    public HangHoa selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public ArrayList<String> getMaHH(){
        ArrayList<String> listMaHH = new ArrayList<>();
        ArrayList<HangHoa> listHH = HangHoaDAO.getInstance().selectAll();
        for (HangHoa hangHoa : listHH) {
            String nameHH = hangHoa.getMaHH();
            listMaHH.add(nameHH);
        }
        return listMaHH;
    }
    public static void main(String[] args) {
        ArrayList<HangHoa> listHH = HangHoaDAO.getInstance().selectAll();
        
        System.out.println(listHH);
    }
    
}
