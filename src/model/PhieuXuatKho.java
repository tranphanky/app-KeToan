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
public class PhieuXuatKho {
    private String maPXK;
    private Date ngayChungTu;
    private String tkNo;
    private String tkCo;
    private String tenNguoiNhan;
    private String tomTat;
    private String maSoKho;
    private String maKH;
    private double Cong;
    private String kemtheoCTG;

    public String getKemtheoCTG() {
        return kemtheoCTG;
    }

    public void setKemtheoCTG(String kemtheoCTG) {
        this.kemtheoCTG = kemtheoCTG;
    }
    
    
    public String getMaPXK() {
        return maPXK;
    }

    public void setMaPXK(String maPXK) {
        this.maPXK = maPXK;
    }

    public Date getNgayChungTu() {
        return ngayChungTu;
    }

    public void setNgayChungTu(Date ngayChungTu) {
        this.ngayChungTu = ngayChungTu;
    }

    public String getTkNo() {
        return tkNo;
    }

    public void setTkNo(String tkNo) {
        this.tkNo = tkNo;
    }

    public String getTkCo() {
        return tkCo;
    }

    public void setTkCo(String tkCo) {
        this.tkCo = tkCo;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getMaSoKho() {
        return maSoKho;
    }

    public void setMaSoKho(String maSoKho) {
        this.maSoKho = maSoKho;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public double getCong() {
        return Cong;
    }

    public void setCong(double Cong) {
        this.Cong = Cong;
    }

    public PhieuXuatKho() {
    }

    
    public PhieuXuatKho(String maPXK) {
        this.maPXK = maPXK;
    }

    public PhieuXuatKho(String maPXK, Date ngayChungTu, String tkNo, String tkCo, String tenNguoiNhan, String tomTat, String maSoKho, String maKH, double Cong, String kemtheoCTG) {
        this.maPXK = maPXK;
        this.ngayChungTu = ngayChungTu;
        this.tkNo = tkNo;
        this.tkCo = tkCo;
        this.tenNguoiNhan = tenNguoiNhan;
        this.tomTat = tomTat;
        this.maSoKho = maSoKho;
        this.maKH = maKH;
        this.Cong = Cong;
        this.kemtheoCTG = kemtheoCTG;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.maPXK);
        hash = 67 * hash + Objects.hashCode(this.ngayChungTu);
        hash = 67 * hash + Objects.hashCode(this.tkNo);
        hash = 67 * hash + Objects.hashCode(this.tkCo);
        hash = 67 * hash + Objects.hashCode(this.tenNguoiNhan);
        hash = 67 * hash + Objects.hashCode(this.tomTat);
        hash = 67 * hash + Objects.hashCode(this.maSoKho);
        hash = 67 * hash + Objects.hashCode(this.maKH);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.Cong) ^ (Double.doubleToLongBits(this.Cong) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.kemtheoCTG);
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
        final PhieuXuatKho other = (PhieuXuatKho) obj;
        if (Double.doubleToLongBits(this.Cong) != Double.doubleToLongBits(other.Cong)) {
            return false;
        }
        if (!Objects.equals(this.maPXK, other.maPXK)) {
            return false;
        }
        if (!Objects.equals(this.tkNo, other.tkNo)) {
            return false;
        }
        if (!Objects.equals(this.tkCo, other.tkCo)) {
            return false;
        }
        if (!Objects.equals(this.tenNguoiNhan, other.tenNguoiNhan)) {
            return false;
        }
        if (!Objects.equals(this.tomTat, other.tomTat)) {
            return false;
        }
        if (!Objects.equals(this.maSoKho, other.maSoKho)) {
            return false;
        }
        if (!Objects.equals(this.maKH, other.maKH)) {
            return false;
        }
        if (!Objects.equals(this.kemtheoCTG, other.kemtheoCTG)) {
            return false;
        }
        return Objects.equals(this.ngayChungTu, other.ngayChungTu);
    }

    @Override
    public String toString() {
        return "PhieuXuatKho{" + "maPXK=" + maPXK + ", ngayChungTu=" + ngayChungTu + ", tkNo=" + tkNo + ", tkCo=" + tkCo + ", tenNguoiNhan=" + tenNguoiNhan + ", tomTat=" + tomTat + ", maSoKho=" + maSoKho + ", maKH=" + maKH + ", Cong=" + Cong + ", kemtheoCTG=" + kemtheoCTG + '}';
    }
    
    

    

    
    
    
}
