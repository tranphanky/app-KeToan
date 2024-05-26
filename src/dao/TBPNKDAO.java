/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.TBPNK;
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
public class TBPNKDAO implements DAOInterface<TBPNK>{

    public static TBPNKDAO getInstance(){
        return new TBPNKDAO();
    }

    @Override
    public int insert(TBPNK t) {
        String sql="INSERT INTO bangphieunhapkho (TenHangHoa,MaSo,DonViTinh,SoLuongTheoChungTu,SoLuongThucNhap,DonGia,ThanhTien,MaPNK) VALUE (?,?,?,?,?,?,?,?)";
        int result=0;
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,t.getTenHangHoa());
            pst.setString(2,t.getMaSo());
            pst.setString(3, t.getDonViTinh());
            pst.setInt(4, t.getSoLuongTheoChungTu());
            pst.setInt(5, t.getSoLuongThucNhap());
            pst.setInt(6, t.getDonGia());
            pst.setInt(7, t.getThanhTien());
            pst.setString(8,t.getMaPNK());
            result=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TBPNKDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(TBPNK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TBPNK t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TBPNK> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TBPNK selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<TBPNK> selectAllNoMaPNK(String maPNK) {
        ArrayList<TBPNK> list = new ArrayList<TBPNK>();
        String sql = "SELECT * FROM bangphieunhapkho WHERE MaPNK=?";
        
        try {
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,maPNK);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {                
                int stt = rs.getInt("STT");
                String tenHH = rs.getString("TenHangHoa");
                String maSo = rs.getString("MaSo");
                String donViTinh = rs.getString("DonViTinh");          
                int soLuongTheoChungTu = rs.getInt("SoLuongTheoChungTu");
                int soLuongThucNhap = rs.getInt("SoLuongThucNhap");
                int donGia = rs.getInt("DonGia");
                int thanhTien  = rs.getInt("thanhTien");
                
                TBPNK tbpnk = new TBPNK(stt, tenHH, maSo, donViTinh, soLuongTheoChungTu, soLuongThucNhap, donGia, thanhTien,maPNK);
                list.add(tbpnk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HangHoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
}
