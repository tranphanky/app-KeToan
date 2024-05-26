 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class TBPNK extends PhieuNhapKho{
    private int STT;
    private String tenHangHoa;
    private String maSo;
    private String donViTinh;
    private int soLuongTheoChungTu;
    private int soLuongThucNhap;
    private int donGia;
    private int thanhTien;

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuongTheoChungTu() {
        return soLuongTheoChungTu;
    }

    public void setSoLuongTheoChungTu(int soLuongTheoChungTu) {
        this.soLuongTheoChungTu = soLuongTheoChungTu;
    }

    public int getSoLuongThucNhap() {
        return soLuongThucNhap;
    }

    public void setSoLuongThucNhap(int soLuongThucNhap) {
        this.soLuongThucNhap = soLuongThucNhap;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public TBPNK(String tenHangHoa, String maSo, String donViTinh, int soLuongTheoChungTu, int soLuongThucNhap, int donGia, int thanhTien, String maPNK) {
        super(maPNK);
        this.tenHangHoa = tenHangHoa;
        this.maSo = maSo;
        this.donViTinh = donViTinh;
        this.soLuongTheoChungTu = soLuongTheoChungTu;
        this.soLuongThucNhap = soLuongThucNhap;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public TBPNK(int STT, String tenHangHoa, String maSo, String donViTinh, int soLuongTheoChungTu, int soLuongThucNhap, int donGia, int thanhTien, String maPNK) {
        super(maPNK);
        this.STT = STT;
        this.tenHangHoa = tenHangHoa;
        this.maSo = maSo;
        this.donViTinh = donViTinh;
        this.soLuongTheoChungTu = soLuongTheoChungTu;
        this.soLuongThucNhap = soLuongThucNhap;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.STT;
        hash = 31 * hash + Objects.hashCode(this.tenHangHoa);
        hash = 31 * hash + Objects.hashCode(this.maSo);
        hash = 31 * hash + Objects.hashCode(this.donViTinh);
        hash = 31 * hash + this.soLuongTheoChungTu;
        hash = 31 * hash + this.soLuongThucNhap;
        hash = 31 * hash + this.donGia;
        hash = 31 * hash + this.thanhTien;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TBPNK other = (TBPNK) obj;
        if (this.STT != other.STT) {
            return false;
        }
        if (this.soLuongTheoChungTu != other.soLuongTheoChungTu) {
            return false;
        }
        if (this.soLuongThucNhap != other.soLuongThucNhap) {
            return false;
        }
        if (this.donGia != other.donGia) {
            return false;
        }
        if (this.thanhTien != other.thanhTien) {
            return false;
        }
        if (!Objects.equals(this.tenHangHoa, other.tenHangHoa)) {
            return false;
        }
        if (!Objects.equals(this.maSo, other.maSo)) {
            return false;
        }
        return Objects.equals(this.donViTinh, other.donViTinh);
    }

    @Override
    public String toString() {
        return "TBPNK{" + "STT=" + STT + ", tenHangHoa=" + tenHangHoa + ", maSo=" + maSo + ", donViTinh=" + donViTinh + ", soLuongTheoChungTu=" + soLuongTheoChungTu + ", soLuongThucNhap=" + soLuongThucNhap + ", donGia=" + donGia + ", thanhTien=" + thanhTien + '}';
    }

    

    
}
