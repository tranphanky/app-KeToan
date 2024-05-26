/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.TBPXK;
import database.JDBCUtil;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class TBPXKDAO implements DAOInterface<TBPXK>{

    public static TBPXKDAO getInstance(){
        return new TBPXKDAO();
    }

    @Override
    public int insert(TBPXK t) {
        String sql="INSERT INTO bangphieuxuatkho (TenHangHoa,MaSo,DonViTinh,SoLuongYeuCau,SoLuongThucNhap,DonGia,ThanhTien,MaPXK) VALUE (?,?,?,?,?,?,?,?)";
        int result=0;
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,t.getTenHangHoa());
            pst.setString(2,t.getMaSo());
            pst.setString(3, t.getDonViTinh());
            pst.setInt(4, t.getSoLuongYeuCau());
            pst.setInt(5, t.getSoLuongThucNhap());
            pst.setInt(6, t.getDonGia());
            pst.setInt(7, t.getThanhTien());
            pst.setString(8,t.getMaPXK());
            result=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TBPXKDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(TBPXK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TBPXK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TBPXK> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TBPXK selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<TBPXK> selectAllNoMaPXK(String maPXK) {
        ArrayList<TBPXK> list = new ArrayList<TBPXK>();
        String sql = "SELECT * FROM bangphieuxuatkho WHERE MaPXK=?";
        
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,maPXK);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                int stt = rs.getInt("STT");
                String tenHH = rs.getString("TenHangHoa");
                String maSo = rs.getString("MaSo");
                String donViTinh = rs.getString("DonViTinh");          
                int soLuongYeuCau = rs.getInt("SoLuongYeuCau");
                int soLuongThucNhap = rs.getInt("SoLuongThucNhap");
                int donGia = rs.getInt("DonGia");
                int thanhTien  = rs.getInt("thanhTien");
                
                TBPXK tbpnk = new TBPXK(stt,tenHH, maSo, donViTinh, soLuongYeuCau, soLuongThucNhap, donGia, thanhTien, maPXK);
                list.add(tbpnk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
